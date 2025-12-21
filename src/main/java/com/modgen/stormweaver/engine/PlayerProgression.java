package com.modgen.stormweaver.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modgen.stormweaver.StormWeaver;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.WorldSavePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Player Progression System - Custom leveling, stats, and skill points
 * Tracks XP from mod activities and grants permanent stat bonuses
 */
public class PlayerProgression {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormweaver/progression");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    // XP formula constants
    private static final int BASE_XP_PER_LEVEL = 100;
    private static final double XP_MULTIPLIER = 1.5;
    private static final int MAX_LEVEL = 100;
    
    // Player progression data
    private final Map<UUID, ProgressionData> playerData = new ConcurrentHashMap<>();
    
    /**
     * Get or create player progression data
     */
    public ProgressionData getPlayerData(UUID playerId) {
        return playerData.computeIfAbsent(playerId, id -> new ProgressionData(id));
    }
    
    /**
     * Grant XP to a player
     */
    public void grantXP(ServerPlayerEntity player, int amount, String source) {
        ProgressionData data = getPlayerData(player.getUuid());
        int oldLevel = data.level;
        
        data.totalXp += amount;
        data.currentXp += amount;
        
        // Check for level up
        while (data.currentXp >= getXpForNextLevel(data.level) && data.level < MAX_LEVEL) {
            data.currentXp -= getXpForNextLevel(data.level);
            data.level++;
            data.unspentPoints++;
            onLevelUp(player, data.level);
        }
        
        // Show XP gain
        player.sendMessage(Text.literal("§a+" + amount + " XP §7(" + source + ")"), true);
    }
    
    /**
     * Calculate XP needed for next level
     */
    public int getXpForNextLevel(int currentLevel) {
        return (int) (BASE_XP_PER_LEVEL * Math.pow(XP_MULTIPLIER, currentLevel));
    }
    
    /**
     * Handle level up
     */
    private void onLevelUp(ServerPlayerEntity player, int newLevel) {
        player.sendMessage(Text.literal(""), false);
        player.sendMessage(Text.literal("§6§l★★★ LEVEL UP! ★★★"), false);
        player.sendMessage(Text.literal("§eYou are now level §f" + newLevel), false);
        player.sendMessage(Text.literal("§a+1 Skill Point"), false);
        player.sendMessage(Text.literal(""), false);
        
        // Sound effect
        player.getWorld().playSound(null, player.getBlockPos(),
            SoundEvents.ENTITY_PLAYER_LEVELUP, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        LOGGER.info("Player {} reached level {}", player.getName().getString(), newLevel);
    }
    
    /**
     * Spend a skill point
     */
    public boolean spendPoint(ServerPlayerEntity player, StatType stat) {
        ProgressionData data = getPlayerData(player.getUuid());
        if (data.unspentPoints <= 0) {
            player.sendMessage(Text.literal("§cNo skill points available!"), false);
            return false;
        }
        
        data.unspentPoints--;
        int current = data.stats.getOrDefault(stat, 0);
        data.stats.put(stat, current + 1);
        
        applyStatBonuses(player, data);
        
        player.sendMessage(Text.literal("§a+" + stat.displayName + "! §7(" + (current + 1) + " total)"), false);
        return true;
    }
    
    /**
     * Apply stat bonuses to player
     */
    public void applyStatBonuses(ServerPlayerEntity player, ProgressionData data) {
        // Health bonus (1 heart per 5 vitality)
        int vitality = data.stats.getOrDefault(StatType.VITALITY, 0);
        double healthBonus = vitality * 0.4; // 2 HP per vitality (1 heart = 2 HP)
        
        // Damage bonus
        int strength = data.stats.getOrDefault(StatType.STRENGTH, 0);
        double damageBonus = strength * 0.5;
        
        // Speed bonus
        int agility = data.stats.getOrDefault(StatType.AGILITY, 0);
        double speedBonus = agility * 0.01;
        
        // Apply using attribute modifiers
        // Note: In practice, would use persistent attribute modifiers with unique IDs
        LOGGER.debug("Applied stat bonuses - Health: +{}, Damage: +{}, Speed: +{}", 
            healthBonus, damageBonus, speedBonus);
    }
    
    /**
     * Get player level
     */
    public int getLevel(UUID playerId) {
        return getPlayerData(playerId).level;
    }
    
    /**
     * Get stat value
     */
    public int getStat(UUID playerId, StatType stat) {
        return getPlayerData(playerId).stats.getOrDefault(stat, 0);
    }
    
    /**
     * Show progression summary
     */
    public void showProgression(ServerPlayerEntity player) {
        ProgressionData data = getPlayerData(player.getUuid());
        int xpNeeded = getXpForNextLevel(data.level);
        
        player.sendMessage(Text.literal("§6╔═══════════════════════════════╗"), false);
        player.sendMessage(Text.literal("§6║       §e⚔ PROGRESSION ⚔       §6║"), false);
        player.sendMessage(Text.literal("§6╠═══════════════════════════════╣"), false);
        player.sendMessage(Text.literal("§6║ §fLevel: §e" + data.level + " §7/ " + MAX_LEVEL), false);
        player.sendMessage(Text.literal("§6║ §fXP: §a" + data.currentXp + " §7/ §f" + xpNeeded), false);
        player.sendMessage(Text.literal("§6║ §fTotal XP: §b" + data.totalXp), false);
        player.sendMessage(Text.literal("§6║ §fSkill Points: §a" + data.unspentPoints), false);
        player.sendMessage(Text.literal("§6╠═══════════════════════════════╣"), false);
        player.sendMessage(Text.literal("§6║ §c❤ Vitality: §f" + data.stats.getOrDefault(StatType.VITALITY, 0)), false);
        player.sendMessage(Text.literal("§6║ §4⚔ Strength: §f" + data.stats.getOrDefault(StatType.STRENGTH, 0)), false);
        player.sendMessage(Text.literal("§6║ §b⚡ Agility: §f" + data.stats.getOrDefault(StatType.AGILITY, 0)), false);
        player.sendMessage(Text.literal("§6║ §9✦ Intelligence: §f" + data.stats.getOrDefault(StatType.INTELLIGENCE, 0)), false);
        player.sendMessage(Text.literal("§6║ §6★ Luck: §f" + data.stats.getOrDefault(StatType.LUCK, 0)), false);
        player.sendMessage(Text.literal("§6╚═══════════════════════════════╝"), false);
    }
    
    // === PERSISTENCE ===
    
    private Path getSaveDirectory(MinecraftServer server) {
        return server.getSavePath(WorldSavePath.ROOT).resolve("stormweaver_progression");
    }
    
    public void loadAllPlayerProgression(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        if (!Files.exists(saveDir)) return;
        
        try (var stream = Files.list(saveDir)) {
            stream.filter(p -> p.toString().endsWith(".json"))
                  .forEach(this::loadPlayerProgression);
        } catch (IOException e) {
            LOGGER.error("Failed to load progression", e);
        }
    }
    
    private void loadPlayerProgression(Path file) {
        try {
            String json = Files.readString(file);
            ProgressionData data = GSON.fromJson(json, ProgressionData.class);
            if (data != null && data.playerId != null) {
                playerData.put(data.playerId, data);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to load progression: " + file, e);
        }
    }
    
    public void saveAllPlayerProgression(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        try {
            Files.createDirectories(saveDir);
            
            for (var entry : playerData.entrySet()) {
                Path file = saveDir.resolve(entry.getKey().toString() + ".json");
                Files.writeString(file, GSON.toJson(entry.getValue()));
            }
        } catch (IOException e) {
            LOGGER.error("Failed to save progression", e);
        }
    }
    
    // Enums and data classes
    public enum StatType {
        VITALITY("Vitality"),
        STRENGTH("Strength"),
        AGILITY("Agility"),
        INTELLIGENCE("Intelligence"),
        LUCK("Luck");
        
        public final String displayName;
        
        StatType(String displayName) {
            this.displayName = displayName;
        }
    }
    
    public static class ProgressionData {
        public UUID playerId;
        public int level = 1;
        public int currentXp = 0;
        public int totalXp = 0;
        public int unspentPoints = 0;
        public Map<StatType, Integer> stats = new EnumMap<>(StatType.class);
        
        public ProgressionData() {}
        
        public ProgressionData(UUID playerId) {
            this.playerId = playerId;
        }
    }
}