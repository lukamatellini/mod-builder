package com.modgen.luckyblocks.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.modgen.luckyblocks.LuckyBlocks;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import java.util.*;
import static net.minecraft.server.command.CommandManager.*;

/**
 * ModGen Commands - FEATURE-GATED IMPLEMENTATION
 * Only includes commands for enabled features to prevent dangling references
 */
public class ModGenCommand {
    
    // Available content IDs

    private static final List<String> STRUCTURE_IDS = Arrays.asList("small_stone_building");

    
    public static void register() {
        CommandRegistrationCallback.EVENT.register(ModGenCommand::registerCommands);
    }
    
    private static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, 
                                        CommandRegistryAccess registryAccess, 
                                        CommandManager.RegistrationEnvironment environment) {
        

        // Structure suggestions
        SuggestionProvider<ServerCommandSource> structureSuggestions = (ctx, builder) -> 
            CommandSource.suggestMatching(STRUCTURE_IDS, builder);


        dispatcher.register(literal("modgen")
            // /modgen placestructure <id> - ACTUALLY PLACE a structure
            .then(literal("placestructure")
                .then(argument("structureId", StringArgumentType.string())
                    .suggests(structureSuggestions)
                    .executes(ctx -> placeStructure(ctx, StringArgumentType.getString(ctx, "structureId")))))
            // /modgen debug - Print debug info with validation
            .then(literal("debug")
                .executes(ModGenCommand::debug))
        );
    }

    /**
     * ACTUALLY PLACES structure from ID-DRIVEN data registry
     */
    private static int placeStructure(CommandContext<ServerCommandSource> ctx, String structureId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        ServerWorld world = player.getServerWorld();
        
        if (!STRUCTURE_IDS.contains(structureId) || "none".equals(structureId)) {
            player.sendMessage(Text.literal("§c!!! INVALID STRUCTURE ID: " + structureId + " !!!"), false);
            return 0;
        }
        
        var structureData = LuckyBlocks.STRUCTURE_REGISTRY.getStructure(structureId);
        if (structureData == null) {
            player.sendMessage(Text.literal("§c!!! ORPHAN STRUCTURE: " + structureId + " has no data !!!"), false);
            return 0;
        }
        
        BlockPos pos = player.getBlockPos().add(3, 0, 3);
        
        try {
            int blocksPlaced = structureData.placeAt(world, pos);
            player.sendMessage(Text.literal("§a✓ Placed structure: §f" + structureData.name + " §7(" + blocksPlaced + " blocks)"), false);
            return 1;
        } catch (Exception e) {
            player.sendMessage(Text.literal("§cError placing structure: " + e.getMessage()), false);
            return 0;
        }
    }

    private static int debug(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        
        source.sendMessage(Text.literal("§6╔═══════════════════════════════════════╗"));
        source.sendMessage(Text.literal("§6║      §eMODGEN DEBUG INFO              §6║"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        source.sendMessage(Text.literal("§6║ §7Mod ID: §fluckyblocks"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        source.sendMessage(Text.literal("§6║ §e§lLOADED CONTENT:                    §6║"));
        source.sendMessage(Text.literal("§6║ §7Quests:     §7(disabled)"));
        source.sendMessage(Text.literal("§6║ §7Items:      §f2"));
        source.sendMessage(Text.literal("§6║ §7Mobs:       §f0"));
        source.sendMessage(Text.literal("§6║ §7Structures: §f1"));
        source.sendMessage(Text.literal("§6║ §7NPCs:       §f0"));
        source.sendMessage(Text.literal("§6║ §7Dimensions: §f0"));
        source.sendMessage(Text.literal("§6╚═══════════════════════════════════════╝"));
        
        LuckyBlocks.VALIDATOR.printEnabledModules();
        
        return 1;
    }
}