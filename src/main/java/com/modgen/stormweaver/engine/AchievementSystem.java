package com.modgen.stormweaver.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modgen.stormweaver.StormWeaver;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
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
 * Achievement System - Track player accomplishments
 * Supports multiple achievement types with XP rewards
 */
public class AchievementSystem {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormweaver/achievements");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    // Achievement definitions
    private final Map<String, Achievement> achievements = new ConcurrentHashMap<>();
    
    // Player achievement progress (playerId -> (achievementId -> progress))
    private final Map<UUID, Map<String, Integer>> playerProgress = new ConcurrentHashMap<>();
    
    // Player unlocked achievements (playerId -> set of achievementIds)
    private final Map<UUID, Set<String>> playerUnlocked = new ConcurrentHashMap<>();
    
    public AchievementSystem() {
        registerAchievements();
        registerEventListeners();
    }
    
    private void registerAchievements() {
        registerAchievement(new Achievement("craft_storm_caster_wand", "Craft Storm Caster Wand", "Craft a Storm Caster Wand", AchievementType.CRAFT_ITEM, "stormweaver:storm_caster_wand", 1, 15));
        LOGGER.info("Registered {} achievements", achievements.size());
    }
    
    private void registerAchievement(Achievement achievement) {
        achievements.put(achievement.id, achievement);
    }
    
    private void registerEventListeners() {
        // Entity kill tracking
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (source.getAttacker() instanceof ServerPlayerEntity player) {
                onMobKilled(player, entity);
            }
        });
    }
    
    /**
     * Track mob kills for achievements
     */
    private void onMobKilled(ServerPlayerEntity player, LivingEntity entity) {
        String entityType = entity.getType().getTranslationKey();
        
        for (Achievement achievement : achievements.values()) {
            if (achievement.type == AchievementType.KILL_MOB && entityType.contains(achievement.targetId)) {
                incrementProgress(player, achievement.id);
            }
        }
    }
    
    /**
     * Track quest completion for achievements
     */
    public void onQuestCompleted(ServerPlayerEntity player, String questId) {
        for (Achievement achievement : achievements.values()) {
            if (achievement.type == AchievementType.COMPLETE_QUEST && achievement.targetId.equals(questId)) {
                incrementProgress(player, achievement.id);
            }
        }
    }
    
    /**
     * Track item crafting for achievements
     */
    public void onItemCrafted(ServerPlayerEntity player, String itemId) {
        for (Achievement achievement : achievements.values()) {
            if (achievement.type == AchievementType.CRAFT_ITEM && achievement.targetId.equals(itemId)) {
                incrementProgress(player, achievement.id);
            }
        }
    }
    
    /**
     * Track structure discovery for achievements
     */
    public void onStructureDiscovered(ServerPlayerEntity player, String structureId) {
        for (Achievement achievement : achievements.values()) {
            if (achievement.type == AchievementType.DISCOVER_STRUCTURE && achievement.targetId.equals(structureId)) {
                incrementProgress(player, achievement.id);
            }
        }
    }
    
    /**
     * Increment progress and check for completion
     */
    private void incrementProgress(ServerPlayerEntity player, String achievementId) {
        Achievement achievement = achievements.get(achievementId);
        if (achievement == null) return;
        
        // Check if already unlocked
        if (isUnlocked(player.getUuid(), achievementId)) return;
        
        // Increment progress
        Map<String, Integer> progress = playerProgress.computeIfAbsent(player.getUuid(), k -> new ConcurrentHashMap<>());
        int current = progress.getOrDefault(achievementId, 0) + 1;
        progress.put(achievementId, current);
        
        // Check completion
        if (current >= achievement.requiredCount) {
            unlockAchievement(player, achievement);
        }
    }
    
    /**
     * Manually grant achievement progress
     */
    public void grantProgress(ServerPlayerEntity player, String achievementId, int amount) {
        Achievement achievement = achievements.get(achievementId);
        if (achievement == null) return;
        
        if (isUnlocked(player.getUuid(), achievementId)) return;
        
        Map<String, Integer> progress = playerProgress.computeIfAbsent(player.getUuid(), k -> new ConcurrentHashMap<>());
        int current = progress.getOrDefault(achievementId, 0) + amount;
        progress.put(achievementId, current);
        
        if (current >= achievement.requiredCount) {
            unlockAchievement(player, achievement);
        }
    }
    
    /**
     * Unlock achievement and grant rewards
     */
    private void unlockAchievement(ServerPlayerEntity player, Achievement achievement) {
        playerUnlocked.computeIfAbsent(player.getUuid(), k -> ConcurrentHashMap.newKeySet())
            .add(achievement.id);
        
        // Remove from progress (no longer needed)
        Map<String, Integer> progress = playerProgress.get(player.getUuid());
        if (progress != null) {
            progress.remove(achievement.id);
        }
        
        // Grant XP reward
        if (achievement.xpReward > 0) {
            player.addExperience(achievement.xpReward);
        }
        
        // Announce
        player.sendMessage(Text.literal(""), false);
        player.sendMessage(Text.literal("§6§l★ ACHIEVEMENT UNLOCKED ★"), false);
        player.sendMessage(Text.literal("§e" + achievement.name), false);
        player.sendMessage(Text.literal("§7" + achievement.description), false);
        if (achievement.xpReward > 0) {
            player.sendMessage(Text.literal("§a+" + achievement.xpReward + " XP"), false);
        }
        player.sendMessage(Text.literal(""), false);
        
        // Sound
        player.getWorld().playSound(null, player.getBlockPos(), 
            SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        LOGGER.info("Player {} unlocked achievement: {}", player.getName().getString(), achievement.id);
    }
    
    /**
     * Check if achievement is unlocked
     */
    public boolean isUnlocked(UUID playerId, String achievementId) {
        return playerUnlocked.getOrDefault(playerId, Collections.emptySet()).contains(achievementId);
    }
    
    /**
     * Get current progress
     */
    public int getProgress(UUID playerId, String achievementId) {
        return playerProgress.getOrDefault(playerId, Collections.emptyMap()).getOrDefault(achievementId, 0);
    }
    
    /**
     * Get all achievements with player status
     */
    public List<AchievementStatus> getAchievementsForPlayer(UUID playerId) {
        List<AchievementStatus> result = new ArrayList<>();
        for (Achievement achievement : achievements.values()) {
            boolean unlocked = isUnlocked(playerId, achievement.id);
            int progress = unlocked ? achievement.requiredCount : getProgress(playerId, achievement.id);
            result.add(new AchievementStatus(achievement, progress, unlocked));
        }
        return result;
    }
    
    /**
     * Show achievements to player
     */
    public void showAchievements(ServerPlayerEntity player) {
        List<AchievementStatus> statuses = getAchievementsForPlayer(player.getUuid());
        
        player.sendMessage(Text.literal("§6╔═══════════════════════════════╗"), false);
        player.sendMessage(Text.literal("§6║       §e★ ACHIEVEMENTS ★       §6║"), false);
        player.sendMessage(Text.literal("§6╠═══════════════════════════════╣"), false);
        
        int unlocked = 0;
        for (AchievementStatus status : statuses) {
            if (status.unlocked) {
                unlocked++;
                player.sendMessage(Text.literal("§6║ §a✓ §f" + status.achievement.name), false);
            } else {
                String progressStr = status.progress + "/" + status.achievement.requiredCount;
                player.sendMessage(Text.literal("§6║ §7○ §f" + status.achievement.name + " §8(" + progressStr + ")"), false);
            }
        }
        
        player.sendMessage(Text.literal("§6╠═══════════════════════════════╣"), false);
        player.sendMessage(Text.literal("§6║ §7Progress: §f" + unlocked + "/" + statuses.size() + " unlocked"), false);
        player.sendMessage(Text.literal("§6╚═══════════════════════════════╝"), false);
    }
    
    // === PERSISTENCE ===
    
    private Path getSaveDirectory(MinecraftServer server) {
        return server.getSavePath(WorldSavePath.ROOT).resolve("stormweaver_achievements");
    }
    
    public void loadAllPlayerAchievements(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        if (!Files.exists(saveDir)) return;
        
        try (var stream = Files.list(saveDir)) {
            stream.filter(p -> p.toString().endsWith(".json"))
                  .forEach(this::loadPlayerAchievements);
        } catch (IOException e) {
            LOGGER.error("Failed to load achievements", e);
        }
    }
    
    private void loadPlayerAchievements(Path file) {
        try {
            String json = Files.readString(file);
            AchievementData data = GSON.fromJson(json, AchievementData.class);
            if (data != null && data.playerId != null) {
                UUID playerId = UUID.fromString(data.playerId);
                playerProgress.put(playerId, new ConcurrentHashMap<>(data.progress));
                playerUnlocked.put(playerId, ConcurrentHashMap.newKeySet());
                playerUnlocked.get(playerId).addAll(data.unlocked);
            }
        } catch (Exception e) {
            LOGGER.error("Failed to load achievements: " + file, e);
        }
    }
    
    public void saveAllPlayerAchievements(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        try {
            Files.createDirectories(saveDir);
            
            Set<UUID> allPlayers = new HashSet<>(playerProgress.keySet());
            allPlayers.addAll(playerUnlocked.keySet());
            
            for (UUID playerId : allPlayers) {
                Path file = saveDir.resolve(playerId.toString() + ".json");
                AchievementData data = new AchievementData(
                    playerId.toString(),
                    playerProgress.getOrDefault(playerId, Collections.emptyMap()),
                    playerUnlocked.getOrDefault(playerId, Collections.emptySet())
                );
                Files.writeString(file, GSON.toJson(data));
            }
        } catch (IOException e) {
            LOGGER.error("Failed to save achievements", e);
        }
    }
    
    public int getAchievementCount() {
        return achievements.size();
    }
    
    // Enums and data classes
    public enum AchievementType {
        KILL_MOB,
        COMPLETE_QUEST,
        CRAFT_ITEM,
        DISCOVER_STRUCTURE,
        REACH_LEVEL,
        COLLECT_ITEM,
        TRADE,
        REPUTATION
    }
    
    public static class Achievement {
        public final String id;
        public final String name;
        public final String description;
        public final AchievementType type;
        public final String targetId;
        public final int requiredCount;
        public final int xpReward;
        
        public Achievement(String id, String name, String description, AchievementType type, 
                          String targetId, int requiredCount, int xpReward) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.type = type;
            this.targetId = targetId;
            this.requiredCount = requiredCount;
            this.xpReward = xpReward;
        }
    }
    
    public static class AchievementStatus {
        public final Achievement achievement;
        public final int progress;
        public final boolean unlocked;
        
        public AchievementStatus(Achievement achievement, int progress, boolean unlocked) {
            this.achievement = achievement;
            this.progress = progress;
            this.unlocked = unlocked;
        }
    }
    
    private static class AchievementData {
        String playerId;
        Map<String, Integer> progress;
        Set<String> unlocked;
        
        AchievementData(String playerId, Map<String, Integer> progress, Set<String> unlocked) {
            this.playerId = playerId;
            this.progress = progress;
            this.unlocked = unlocked;
        }
    }
}