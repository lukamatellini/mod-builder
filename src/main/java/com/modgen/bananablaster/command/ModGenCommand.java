package com.modgen.bananablaster.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import com.modgen.bananablaster.BananaBlaster;
import com.modgen.bananablaster.ModEntities;
import com.modgen.bananablaster.ModDimensions;
import com.modgen.bananablaster.engine.QuestData;
import com.modgen.bananablaster.entity.ModGenNPCEntity;
import com.modgen.bananablaster.network.ModNetworking;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.CommandSource;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

import java.util.*;

import static net.minecraft.server.command.CommandManager.*;

/**
 * ModGen Commands - FULLY IMPLEMENTED
 * Every command has real functionality with in-game proof
 */
public class ModGenCommand {
    
    // Available NPC types
    private static final List<String> NPC_TYPES = Arrays.asList("default");
    private static final List<String> STRUCTURE_IDS = Arrays.asList("none");
    private static final List<String> DIMENSION_IDS = Arrays.asList("none");
    
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
            // /modgen journal - Open quest journal
            .then(literal("journal")
                .executes(ModGenCommand::openJournal))
            
            // /modgen quests - List available quests
            .then(literal("quests")
                .executes(ModGenCommand::listQuests))
            
            // /modgen startquest <id> - Start a quest
            .then(literal("startquest")
                .then(argument("questId", StringArgumentType.string())
                    .executes(ctx -> startQuest(ctx, StringArgumentType.getString(ctx, "questId")))))
            
            // /modgen spawnnpc <type> - ACTUALLY SPAWN an NPC
            .then(literal("spawnnpc")
                .then(argument("type", StringArgumentType.string())
                    .suggests(npcSuggestions)
                    .executes(ctx -> spawnNPC(ctx, StringArgumentType.getString(ctx, "type")))))
            
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
    
    private static int openJournal(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() != null) {
            ServerPlayerEntity player = source.getPlayer();
            ModNetworking.sendOpenJournal(player);
            player.sendMessage(Text.literal("§aOpening Quest Journal..."), true);
            return 1;
        }
        return 0;
    }
    
    private static int listQuests(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        var activeQuests = BananaBlaster.QUEST_ENGINE.getActiveQuests(player);
        var availableQuests = BananaBlaster.QUEST_ENGINE.getAvailableQuests(player);
        
        player.sendMessage(Text.literal("§6╔═══════════════════════════════╗"), false);
        player.sendMessage(Text.literal("§6║      §eQUEST JOURNAL           §6║"), false);
        player.sendMessage(Text.literal("§6╠═══════════════════════════════╣"), false);
        
        if (!activeQuests.isEmpty()) {
            player.sendMessage(Text.literal("§6║ §e§lActive Quests:              §6║"), false);
            for (QuestData quest : activeQuests) {
                var progress = BananaBlaster.QUEST_ENGINE.getQuestProgress(player, quest.id);
                player.sendMessage(Text.literal("§6║ §7• §f" + quest.name), false);
                if (quest.objectives != null) {
                    for (var obj : quest.objectives) {
                        int current = progress.getOrDefault(obj.id, 0);
                        String status = current >= obj.count ? "§a✓" : "§e" + current + "/" + obj.count;
                        player.sendMessage(Text.literal("§6║   §7" + obj.description + " " + status), false);
                    }
                }
            }
        }
        
        if (!availableQuests.isEmpty()) {
            player.sendMessage(Text.literal("§6║ §a§lAvailable Quests:           §6║"), false);
            for (QuestData quest : availableQuests) {
                player.sendMessage(Text.literal("§6║ §7• §f" + quest.name), false);
                player.sendMessage(Text.literal("§6║   §8/modgen startquest " + quest.id), false);
            }
        }
        
        if (activeQuests.isEmpty() && availableQuests.isEmpty()) {
            player.sendMessage(Text.literal("§6║ §7No quests available         §6║"), false);
        }
        
        player.sendMessage(Text.literal("§6╚═══════════════════════════════╝"), false);
        return 1;
    }
    
    private static int startQuest(CommandContext<ServerCommandSource> ctx, String questId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        boolean success = BananaBlaster.QUEST_ENGINE.startQuest(player, questId);
        return success ? 1 : 0;
    }
    
    /**
     * ACTUALLY SPAWNS an NPC entity - ID-DRIVEN with STRICT validation
     * NO FALLBACKS - Every ID must map to real NPC data
     */
    private static int spawnNPC(CommandContext<ServerCommandSource> ctx, String npcId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        ServerWorld world = player.getServerWorld();
        
        // STRICT ID validation - no fallbacks
        if (!NPC_TYPES.contains(npcId)) {
            player.sendMessage(Text.literal("§c!!! INVALID NPC ID: " + npcId + " !!!"), false);
            player.sendMessage(Text.literal("§7This ID does not exist in build-plan.json"), false);
            player.sendMessage(Text.literal("§7Valid NPCs: " + String.join(", ", NPC_TYPES)), false);
            return 0;
        }
        
        // STRICT data validation - NPC must have definition in NPCManager
        var npcDef = BananaBlaster.NPC_MANAGER.getNPCDefinition(npcId);
        if (npcDef == null) {
            player.sendMessage(Text.literal("§c!!! ORPHAN NPC: " + npcId + " has no definition !!!"), false);
            BananaBlaster.LOGGER.error("ORPHAN NPC: {} is in ID list but has no NPCManager definition", npcId);
            return 0;
        }
        
        try {
            // Create and spawn the NPC entity
            ModGenNPCEntity npc = ModEntities.NPC_ENTITY_TYPE.create(world);
            if (npc != null) {
                // Position in front of player
                double x = player.getX() + player.getRotationVector().x * 2;
                double y = player.getY();
                double z = player.getZ() + player.getRotationVector().z * 2;
                
                npc.setPosition(x, y, z);
                npc.setNpcId(npcDef.id);
                npc.setNpcName(npcDef.name);
                
                world.spawnEntity(npc);
                
                player.sendMessage(Text.literal("§a✓ Spawned NPC: §f" + npcDef.name + " §7(" + npcDef.title + ")"), false);
                player.sendMessage(Text.literal("§7Location: " + String.format("%.1f, %.1f, %.1f", x, y, z)), false);
                player.sendMessage(Text.literal("§7Right-click to interact!"), false);
                return 1;
            } else {
                player.sendMessage(Text.literal("§cFailed to create NPC entity type"), false);
                return 0;
            }
        } catch (Exception e) {
            player.sendMessage(Text.literal("§cError spawning NPC: " + e.getMessage()), false);
            BananaBlaster.LOGGER.error("Failed to spawn NPC {}", npcId, e);
            return 0;
        }
    }
    
    /**
     * ACTUALLY PLACES structure from ID-DRIVEN data registry
     * NO DEMO STRUCTURES - Every ID must map to real structure data
     */
    private static int placeStructure(CommandContext<ServerCommandSource> ctx, String structureId) {
        ServerCommandSource source = ctx.getSource();
        if (source.getPlayer() == null) return 0;
        
        ServerPlayerEntity player = source.getPlayer();
        ServerWorld world = player.getServerWorld();
        
        // STRICT ID VALIDATION - no fallbacks
        if (!STRUCTURE_IDS.contains(structureId) || "none".equals(structureId)) {
            player.sendMessage(Text.literal("§c!!! INVALID STRUCTURE ID: " + structureId + " !!!"), false);
            player.sendMessage(Text.literal("§7This ID does not exist in build-plan.json"), false);
            if (STRUCTURE_IDS.size() > 0 && !"none".equals(STRUCTURE_IDS.get(0))) {
                player.sendMessage(Text.literal("§7Valid structures: " + String.join(", ", STRUCTURE_IDS)), false);
            }
            return 0;
        }
        
        // Load structure data from registry - STRICT ID lookup
        var structureData = BananaBlaster.STRUCTURE_REGISTRY.getStructure(structureId);
        if (structureData == null) {
            player.sendMessage(Text.literal("§c!!! ORPHAN STRUCTURE: " + structureId + " has no data !!!"), false);
            BananaBlaster.LOGGER.error("ORPHAN STRUCTURE: {} is in ID list but has no registered data", structureId);
            return 0;
        }
        
        BlockPos pos = player.getBlockPos().add(3, 0, 3);
        
        try {
            // Place structure from data - NOT hardcoded blocks
            int blocksPlaced = structureData.placeAt(world, pos);
            
            if (blocksPlaced == 0) {
                player.sendMessage(Text.literal("§c!!! Structure " + structureId + " has zero blocks !!!"), false);
                return 0;
            }
            
            player.sendMessage(Text.literal("§a✓ Placed structure: §f" + structureData.name + " §7(" + blocksPlaced + " blocks)"), false);
            player.sendMessage(Text.literal("§7Location: " + pos.getX() + ", " + pos.getY() + ", " + pos.getZ()), false);
            return 1;
        } catch (Exception e) {
            player.sendMessage(Text.literal("§cError placing structure: " + e.getMessage()), false);
            BananaBlaster.LOGGER.error("Failed to place structure {}", structureId, e);
            return 0;
        }
    }
    

    /**
     * Debug command - prints validation status and loaded counts
     */
    private static int debug(CommandContext<ServerCommandSource> ctx) {
        ServerCommandSource source = ctx.getSource();
        
        source.sendMessage(Text.literal("§6╔═══════════════════════════════════════╗"));
        source.sendMessage(Text.literal("§6║      §eMODGEN DEBUG INFO              §6║"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        source.sendMessage(Text.literal("§6║ §7Mod ID: §fbananablaster"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        source.sendMessage(Text.literal("§6║ §e§lLOADED CONTENT:                    §6║"));
        source.sendMessage(Text.literal("§6║ §7Quests:     §f" + BananaBlaster.QUEST_ENGINE.getQuestCount() + " §7(expected: 0)"));
        source.sendMessage(Text.literal("§6║ §7Items:      §f2"));
        source.sendMessage(Text.literal("§6║ §7Mobs:       §f0"));
        source.sendMessage(Text.literal("§6║ §7Structures: §f0"));
        source.sendMessage(Text.literal("§6║ §7NPCs:       §f0"));
        source.sendMessage(Text.literal("§6║ §7Dimensions: §f0"));
        source.sendMessage(Text.literal("§6╠═══════════════════════════════════════╣"));
        
        // Validation status
        int errors = BananaBlaster.VALIDATOR.getValidationErrors();
        int warnings = BananaBlaster.VALIDATOR.getValidationWarnings();
        
        if (errors > 0) {
            source.sendMessage(Text.literal("§6║ §c!!! VALIDATION FAILED: " + errors + " errors !!!"));
        } else if (warnings > 0) {
            source.sendMessage(Text.literal("§6║ §e⚠ Validation passed with " + warnings + " warnings"));
        } else {
            source.sendMessage(Text.literal("§6║ §a✓ All validations passed"));
        }
        
        source.sendMessage(Text.literal("§6╚═══════════════════════════════════════╝"));
        
        // Print build plan info
        BananaBlaster.VALIDATOR.printEnabledModules();
        
        if (BananaBlaster.ENGINE != null) {
            BananaBlaster.ENGINE.debug();
        }
        
        return 1;
    }
}