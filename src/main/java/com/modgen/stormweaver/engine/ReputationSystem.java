package com.modgen.stormweaver.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modgen.stormweaver.StormWeaver;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
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
 * Reputation System - Track player standing with NPCs and factions
 * Affects trading options, dialogue, quest availability, and NPC behavior
 */
public class ReputationSystem {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormweaver/reputation");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    // Reputation thresholds
    public static final int REP_HOSTILE = -100;
    public static final int REP_UNFRIENDLY = -50;
    public static final int REP_NEUTRAL = 0;
    public static final int REP_FRIENDLY = 50;
    public static final int REP_HONORED = 100;
    public static final int REP_REVERED = 200;
    public static final int REP_EXALTED = 500;
    
    // Max reputation bounds
    public static final int REP_MIN = -500;
    public static final int REP_MAX = 1000;
    
    // Faction definitions
    private final Map<String, FactionDefinition> factionDefinitions = new ConcurrentHashMap<>();
    
    // Player reputation data (playerId -> (factionId -> reputation))
    private final Map<UUID, Map<String, Integer>> playerReputations = new ConcurrentHashMap<>();
    
    public ReputationSystem() {
        registerFactions();
    }
    
    private void registerFactions() {
        LOGGER.info("Registered {} factions", factionDefinitions.size());
    }
    
    /**
     * Get player's reputation with a faction/NPC
     */
    public int getReputation(UUID playerId, String factionId) {
        return playerReputations
            .getOrDefault(playerId, Collections.emptyMap())
            .getOrDefault(factionId, REP_NEUTRAL);
    }
    
    /**
     * Get reputation standing name
     */
    public String getStandingName(int reputation) {
        if (reputation >= REP_EXALTED) return "§5Exalted";
        if (reputation >= REP_REVERED) return "§dRevered";
        if (reputation >= REP_HONORED) return "§6Honored";
        if (reputation >= REP_FRIENDLY) return "§aFriendly";
        if (reputation > REP_UNFRIENDLY) return "§7Neutral";
        if (reputation > REP_HOSTILE) return "§cUnfriendly";
        return "§4Hostile";
    }
    
    /**
     * Modify reputation (can be positive or negative)
     */
    public void modifyReputation(UUID playerId, String factionId, int amount) {
        Map<String, Integer> playerReps = playerReputations.computeIfAbsent(playerId, k -> new ConcurrentHashMap<>());
        int current = playerReps.getOrDefault(factionId, REP_NEUTRAL);
        int newRep = Math.max(REP_MIN, Math.min(REP_MAX, current + amount));
        playerReps.put(factionId, newRep);
        
        // Check for tier changes
        String oldStanding = getStandingName(current);
        String newStanding = getStandingName(newRep);
        if (!oldStanding.equals(newStanding)) {
            LOGGER.info("Player {} reputation with {} changed from {} to {}", 
                playerId, factionId, oldStanding, newStanding);
        }
    }
    
    /**
     * Set reputation to a specific value
     */
    public void setReputation(UUID playerId, String factionId, int value) {
        int clamped = Math.max(REP_MIN, Math.min(REP_MAX, value));
        playerReputations.computeIfAbsent(playerId, k -> new ConcurrentHashMap<>())
            .put(factionId, clamped);
    }
    
    /**
     * Grant reputation for quest completion
     */
    public void onQuestComplete(ServerPlayerEntity player, String questId, String factionId) {
        modifyReputation(player.getUuid(), factionId, 25);
        player.sendMessage(Text.literal("§a+25 reputation with " + getFactionDisplayName(factionId)), true);
    }
    
    /**
     * Grant reputation for trading
     */
    public void onTrade(ServerPlayerEntity player, String factionId) {
        modifyReputation(player.getUuid(), factionId, 1);
    }
    
    /**
     * Penalty for attacking NPCs
     */
    public void onNPCAttacked(ServerPlayerEntity player, String factionId) {
        modifyReputation(player.getUuid(), factionId, -50);
        player.sendMessage(Text.literal("§c-50 reputation with " + getFactionDisplayName(factionId)), true);
    }
    
    /**
     * Check if player is hostile to a faction
     */
    public boolean isHostile(UUID playerId, String factionId) {
        return getReputation(playerId, factionId) <= REP_HOSTILE;
    }
    
    /**
     * Check if player meets reputation requirement
     */
    public boolean meetsRequirement(UUID playerId, String factionId, int required) {
        return getReputation(playerId, factionId) >= required;
    }
    
    /**
     * Get all reputations for a player
     */
    public Map<String, Integer> getAllReputations(UUID playerId) {
        return new HashMap<>(playerReputations.getOrDefault(playerId, Collections.emptyMap()));
    }
    
    /**
     * Get faction display name
     */
    public String getFactionDisplayName(String factionId) {
        FactionDefinition def = factionDefinitions.get(factionId);
        return def != null ? def.displayName : factionId;
    }
    
    /**
     * Display reputation summary to player
     */
    public void showReputationSummary(ServerPlayerEntity player) {
        player.sendMessage(Text.literal("§6╔═══════════════════════════════╗"), false);
        player.sendMessage(Text.literal("§6║     §eFACTION STANDING         §6║"), false);
        player.sendMessage(Text.literal("§6╠═══════════════════════════════╣"), false);
        
        Map<String, Integer> reps = getAllReputations(player.getUuid());
        if (reps.isEmpty()) {
            player.sendMessage(Text.literal("§6║ §7No faction standing yet     §6║"), false);
        } else {
            for (var entry : reps.entrySet()) {
                String name = getFactionDisplayName(entry.getKey());
                String standing = getStandingName(entry.getValue());
                player.sendMessage(Text.literal("§6║ §f" + name + ": " + standing + " §7(" + entry.getValue() + ")"), false);
            }
        }
        
        player.sendMessage(Text.literal("§6╚═══════════════════════════════╝"), false);
    }
    
    // === PERSISTENCE ===
    
    private Path getSaveDirectory(MinecraftServer server) {
        return server.getSavePath(WorldSavePath.ROOT).resolve("stormweaver_reputation");
    }
    
    public void loadAllPlayerReputations(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        if (!Files.exists(saveDir)) return;
        
        try (var stream = Files.list(saveDir)) {
            stream.filter(p -> p.toString().endsWith(".json"))
                  .forEach(this::loadPlayerReputation);
        } catch (IOException e) {
            LOGGER.error("Failed to load reputations", e);
        }
    }
    
    private void loadPlayerReputation(Path file) {
        try {
            String json = Files.readString(file);
            ReputationData data = GSON.fromJson(json, ReputationData.class);
            if (data != null && data.playerId != null) {
                playerReputations.put(UUID.fromString(data.playerId), new ConcurrentHashMap<>(data.reputations));
            }
        } catch (Exception e) {
            LOGGER.error("Failed to load reputation: " + file, e);
        }
    }
    
    public void saveAllPlayerReputations(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        try {
            Files.createDirectories(saveDir);
            
            for (var entry : playerReputations.entrySet()) {
                Path file = saveDir.resolve(entry.getKey().toString() + ".json");
                ReputationData data = new ReputationData(entry.getKey().toString(), entry.getValue());
                Files.writeString(file, GSON.toJson(data));
            }
        } catch (IOException e) {
            LOGGER.error("Failed to save reputations", e);
        }
    }
    
    public int getFactionCount() {
        return factionDefinitions.size();
    }
    
    // Data classes
    public static class FactionDefinition {
        public final String id;
        public final String displayName;
        
        public FactionDefinition(String id, String displayName) {
            this.id = id;
            this.displayName = displayName;
        }
    }
    
    private static class ReputationData {
        String playerId;
        Map<String, Integer> reputations;
        
        ReputationData(String playerId, Map<String, Integer> reputations) {
            this.playerId = playerId;
            this.reputations = reputations;
        }
    }
}