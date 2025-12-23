package com.modgen.aetheriaascendant.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.modgen.aetheriaascendant.AetheriaAscendant;
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
import com.modgen.aetheriaascendant.ModEntities;
import com.modgen.aetheriaascendant.ModDimensions;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;
import com.modgen.aetheriaascendant.entity.ModGenNPCEntity;
import com.modgen.aetheriaascendant.network.ModNetworking;

/**
 * ModGen Commands - FEATURE-GATED IMPLEMENTATION
 * Only includes commands for enabled features to prevent dangling references
 */
public class ModGenCommand {
    
    // Available content IDs
    private static final List<String> NPC_TYPES = Arrays.asList("aether_traveler", "cloud_weaver");
    private static final List<String> STRUCTURE_IDS = Arrays.asList("sky_temple", "cloud_village", "aether_structure");
    private static final List<String> DIMENSION_IDS = Arrays.asList("aether");
    
    public static void register() {
        CommandRegistrationCallback.EVENT.register(ModGenCommand::registerCommands);
    }
    
    private static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher, 
                                        CommandRegistryAccess registryAccess, 
                                        CommandManager.RegistrationEnvironment environment) {
        
        // NPC type suggestions
        SuggestionProvider<ServerCommandSource> npcSuggestions = (ctx, builder) -> 
            CommandSource.suggestMatching(NPC_TYPES, builder);

        // Structure suggestions
        SuggestionProvider<ServerCommandSource> structureSuggestions = (ctx, builder) -> 
            CommandSource.suggestMatching(STRUCTURE_IDS, builder);

        // Dimension suggestions
        SuggestionProvider<ServerCommandSource> dimensionSuggestions = (ctx, builder) -> 
            CommandSource.suggestMatching(DIMENSION_IDS, builder);

        dispatcher.register(literal("modgen")
            // /modgen spawnnpc <type> - ACTUALLY SPAWN an NPC
            .then(literal("spawnnpc")
                .then(argument("type", StringArgumentType.string())
                    .suggests(npcSuggestions)
                    .executes(ctx -> spawnNPC(ctx, StringArgumentType.getString(ctx, "type")))))
            // /modgen trade <npc_id> - Open trading screen with NPC
            .then(literal("trade")
                .then(argument("npcId", StringArgumentType.string())
                    .suggests(npcSuggestions)
                    .executes(ctx -> openTrade(ctx, StringArgumentType.getString(ctx, "npcId")))))
            // /modgen placestructure <id> - ACTUALLY PLACE a structure
            .then(literal("placestructure")
                .then(argument("structureId", StringArgumentType.string())
                    .suggests(structureSuggestions)
                    .executes(ctx -> placeStructure(ctx, StringArgumentType.getString(ctx, "structureId")))))
            // /modgen opendimension <id> - ACTUALLY TELEPORT to dimension
            .then(literal("opendimension")
                .then(argument("dimensionId", StringArgumentType.string())
                    .suggests(dimensionSuggestions)
                    .executes(ctx -> openDimension(ctx, StringArgumentType.getString(ctx, "dimensionId")))))
            // /modgen debug - Print debug info with validation
            .then(literal("debug")
                .executes(ModGenCommand::debug))
        );
    }

    /**
     * ACTUALLY SPAWNS an NPC entity - ID-DRIVEN with STRICT validation
     */
    private static int spawnNPC(CommandContext<ServerCommandSource> ctx, String npcId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        ServerWorld world = player.getServerWorld();
        
        // STRICT ID validation - no fallbacks
        if (!NPC_TYPES.contains(npcId)) {
            player.sendMessage(Text.literal("§c!!! INVALID NPC ID: " + npcId + " !!!"), false);
            player.sendMessage(Text.literal("§7Valid NPCs: " + String.join(", ", NPC_TYPES)), false);
            return 0;
        }
        
        // STRICT data validation
        var npcDef = AetheriaAscendant.NPC_MANAGER.getNPCDefinition(npcId);
        if (npcDef == null) {
            player.sendMessage(Text.literal("§c!!! ORPHAN NPC: " + npcId + " has no definition !!!"), false);
            return 0;
        }
        
        try {
            ModGenNPCEntity npc = ModEntities.NPC_ENTITY_TYPE.create(world);
            if (npc != null) {
                double x = player.getX() + player.getRotationVector().x * 2;
                double y = player.getY();
                double z = player.getZ() + player.getRotationVector().z * 2;
                
                npc.setPosition(x, y, z);
                npc.setNpcId(npcDef.id);
                npc.setNpcName(npcDef.name);
                
                world.spawnEntity(npc);
                
                player.sendMessage(Text.literal("§a✓ Spawned NPC: §f" + npcDef.name + " §7(" + npcDef.title + ")"), false);
                return 1;
            }
        } catch (Exception e) {
            player.sendMessage(Text.literal("§cError spawning NPC: " + e.getMessage()), false);
        }
        return 0;
    }

    /**
     * Open trading screen with specified NPC
     */
    private static int openTrade(CommandContext<ServerCommandSource> ctx, String npcId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        
        // Validate NPC ID
        if (!NPC_TYPES.contains(npcId)) {
            player.sendMessage(Text.literal("§c!!! INVALID NPC ID: " + npcId + " !!!"), false);
            player.sendMessage(Text.literal("§7Valid NPCs: " + String.join(", ", NPC_TYPES)), false);
            return 0;
        }
        
        // Get NPC definition
        var npcDef = AetheriaAscendant.NPC_MANAGER.getNPCDefinition(npcId);
        if (npcDef == null) {
            player.sendMessage(Text.literal("§c!!! NPC not found: " + npcId + " !!!"), false);
            return 0;
        }
        
        // Get trades for this NPC
        var trades = AetheriaAscendant.TRADING_SYSTEM.getTradesForNpc(npcId);
        if (trades.isEmpty()) {
            player.sendMessage(Text.literal("§eThis NPC has no trades available."), false);
            return 0;
        }
        
        // Send trading screen packet
        ModNetworking.sendOpenTrading(player, npcId, npcDef.name, trades);
        player.sendMessage(Text.literal("§aOpening trades with §f" + npcDef.name + "§a..."), true);
        return 1;
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
        
        var structureData = AetheriaAscendant.STRUCTURE_REGISTRY.getStructure(structureId);
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

    private static int openDimension(CommandContext<ServerCommandSource> ctx, String dimensionId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        
        if (!DIMENSION_IDS.contains(dimensionId) || "none".equals(dimensionId)) {
            player.sendMessage(Text.literal("§cUnknown dimension: " + dimensionId), false);
            return 0;
        }
        
        try {
            RegistryKey<World> dimensionKey = RegistryKey.of(RegistryKeys.WORLD, 
                Identifier.of(AetheriaAscendant.MOD_ID, dimensionId));
            ServerWorld targetWorld = source.getServer().getWorld(dimensionKey);
            
            if (targetWorld == null) {
                player.sendMessage(Text.literal("§cDimension not loaded: " + dimensionId), false);
                return 0;
            }
            
            TeleportTarget target = new TeleportTarget(
                targetWorld,
                player.getPos(),
                player.getVelocity(),
                player.getYaw(),
                player.getPitch(),
                TeleportTarget.NO_OP
            );
            player.teleportTo(target);
            
            player.sendMessage(Text.literal("§a✓ Teleported to dimension: §f" + dimensionId), false);
            return 1;
        } catch (Exception e) {
            player.sendMessage(Text.literal("§cError teleporting: " + e.getMessage()), false);
            return 0;
        }
    }

    private static int debug(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        
        source.sendMessage(Text.literal("§6╔═══════════════════════════════════════╗"));
        source.sendMessage(Text.literal("§6║      §eMODGEN DEBUG INFO              §6║"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        source.sendMessage(Text.literal("§6║ §7Mod ID: §faetheriaascendant"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        source.sendMessage(Text.literal("§6║ §e§lLOADED CONTENT:                    §6║"));
        source.sendMessage(Text.literal("§6║ §7Quests:     §7(disabled)"));
        source.sendMessage(Text.literal("§6║ §7Items:      §f6"));
        source.sendMessage(Text.literal("§6║ §7Mobs:       §f3"));
        source.sendMessage(Text.literal("§6║ §7Structures: §f3"));
        source.sendMessage(Text.literal("§6║ §7NPCs:       §f2"));
        source.sendMessage(Text.literal("§6║ §7Dimensions: §f1"));
        source.sendMessage(Text.literal("§6╚═══════════════════════════════════════╝"));
        
        AetheriaAscendant.VALIDATOR.printEnabledModules();
        
        return 1;
    }
}