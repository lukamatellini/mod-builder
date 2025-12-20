package com.modgen.stormbringerwand.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modgen.stormbringerwand.StormbringerWand;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Quest Engine - Server-authoritative per-player quest state
 * Persistent storage across sessions with event-driven progression
 */
public class QuestEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormbringerwand/quests");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    // Quest definitions loaded from JSON
    private final Map<String, QuestData> questDefinitions = new ConcurrentHashMap<>();
    
    // Per-player quest state (UUID -> state)
    private final Map<UUID, PlayerQuestState> playerStates = new ConcurrentHashMap<>();
    
    public QuestEngine() {
        registerEventListeners();
    }
    
    private void registerEventListeners() {
        // Entity kill events
        ServerLivingEntityEvents.AFTER_DEATH.register((entity, source) -> {
            if (source.getAttacker() instanceof ServerPlayerEntity player) {
                onEntityKilled(player, entity);
            }
        });
        
        // Block break events
        PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, blockEntity) -> {
            if (player instanceof ServerPlayerEntity serverPlayer) {
                onBlockBroken(serverPlayer, state.getBlock().getTranslationKey());
            }
        });
    }
    
    public int loadQuestsFromResources(MinecraftServer server) {
        questDefinitions.clear();
        
        // Load quest JSON files from mod resources
        try {
            var resourceManager = server.getResourceManager();
            var questFiles = resourceManager.findResources("quests", id -> id.getPath().endsWith(".json"));
            
            for (var entry : questFiles.entrySet()) {
                Identifier id = entry.getKey();
                if (!id.getNamespace().equals("stormbringerwand")) continue;
                
                try (var stream = entry.getValue().getInputStream()) {
                    String json = new String(stream.readAllBytes());
                    QuestData quest = GSON.fromJson(json, QuestData.class);
                    if (quest != null && quest.id != null) {
                        questDefinitions.put(quest.id, quest);
                        LOGGER.info("Loaded quest: " + quest.id + " - " + quest.name);
                    }
                } catch (Exception e) {
                    LOGGER.error("Failed to load quest: " + id, e);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Failed to scan quest resources", e);
        }
        
        // Load saved player states
        loadAllPlayerStates(server);
        
        return questDefinitions.size();
    }
    
    public PlayerQuestState getPlayerState(UUID playerId) {
        return playerStates.computeIfAbsent(playerId, id -> new PlayerQuestState(id));
    }
    
    public boolean startQuest(ServerPlayerEntity player, String questId) {
        QuestData quest = questDefinitions.get(questId);
        if (quest == null) {
            player.sendMessage(Text.literal("§cQuest not found: " + questId), false);
            return false;
        }
        
        PlayerQuestState state = getPlayerState(player.getUuid());
        
        // Check prerequisites
        if (quest.prerequisites != null) {
            for (String prereq : quest.prerequisites) {
                if (!state.isQuestCompleted(prereq)) {
                    player.sendMessage(Text.literal("§cYou must complete '" + prereq + "' first!"), false);
                    return false;
                }
            }
        }
        
        // Check if already active or completed
        if (state.isQuestActive(questId)) {
            player.sendMessage(Text.literal("§eQuest already in progress!"), false);
            return false;
        }
        
        if (state.isQuestCompleted(questId) && !quest.repeatable) {
            player.sendMessage(Text.literal("§eQuest already completed!"), false);
            return false;
        }
        
        // Start the quest
        state.startQuest(questId, quest);
        player.sendMessage(Text.literal("§a✦ Quest Started: " + quest.name), false);
        if (quest.startMessage != null) {
            player.sendMessage(Text.literal("§7" + quest.startMessage), false);
        }
        
        return true;
    }
    
    public void onEntityKilled(ServerPlayerEntity player, LivingEntity entity) {
        PlayerQuestState state = getPlayerState(player.getUuid());
        String entityType = entity.getType().getTranslationKey();
        
        for (String questId : state.getActiveQuests()) {
            QuestData quest = questDefinitions.get(questId);
            if (quest == null) continue;
            
            for (QuestData.Objective obj : quest.objectives) {
                if ("kill_mob".equals(obj.type) && entityType.contains(obj.targetId)) {
                    int progress = state.incrementObjective(questId, obj.id);
                    if (progress >= obj.count) {
                        player.sendMessage(Text.literal("§a✓ " + obj.description + " (Complete)"), true);
                    } else {
                        player.sendMessage(Text.literal("§e" + obj.description + " (" + progress + "/" + obj.count + ")"), true);
                    }
                    checkQuestCompletion(player, questId);
                }
            }
        }
    }
    
    public void onBlockBroken(ServerPlayerEntity player, String blockType) {
        PlayerQuestState state = getPlayerState(player.getUuid());
        
        for (String questId : state.getActiveQuests()) {
            QuestData quest = questDefinitions.get(questId);
            if (quest == null) continue;
            
            for (QuestData.Objective obj : quest.objectives) {
                if ("break_block".equals(obj.type) && blockType.contains(obj.targetId)) {
                    state.incrementObjective(questId, obj.id);
                    checkQuestCompletion(player, questId);
                }
            }
        }
    }
    
    public void onItemCollected(ServerPlayerEntity player, ItemStack stack) {
        PlayerQuestState state = getPlayerState(player.getUuid());
        String itemId = stack.getItem().getTranslationKey();
        
        for (String questId : state.getActiveQuests()) {
            QuestData quest = questDefinitions.get(questId);
            if (quest == null) continue;
            
            for (QuestData.Objective obj : quest.objectives) {
                if ("collect_item".equals(obj.type) && itemId.contains(obj.targetId)) {
                    // Count items in inventory
                    int count = 0;
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        ItemStack invStack = player.getInventory().getStack(i);
                        if (invStack.getItem().getTranslationKey().contains(obj.targetId)) {
                            count += invStack.getCount();
                        }
                    }
                    state.setObjectiveProgress(questId, obj.id, count);
                    checkQuestCompletion(player, questId);
                }
            }
        }
    }
    
    private void checkQuestCompletion(ServerPlayerEntity player, String questId) {
        PlayerQuestState state = getPlayerState(player.getUuid());
        QuestData quest = questDefinitions.get(questId);
        if (quest == null) return;
        
        boolean allComplete = true;
        for (QuestData.Objective obj : quest.objectives) {
            if (state.getObjectiveProgress(questId, obj.id) < obj.count) {
                allComplete = false;
                break;
            }
        }
        
        if (allComplete) {
            completeQuest(player, questId);
        }
    }
    
    public void completeQuest(ServerPlayerEntity player, String questId) {
        QuestData quest = questDefinitions.get(questId);
        if (quest == null) return;
        
        PlayerQuestState state = getPlayerState(player.getUuid());
        state.completeQuest(questId);
        
        player.sendMessage(Text.literal("§a§l✦ Quest Complete: " + quest.name + " ✦"), false);
        
        // Grant rewards
        if (quest.rewards != null) {
            for (QuestData.Reward reward : quest.rewards) {
                grantReward(player, reward);
            }
        }
        
        if (quest.completeMessage != null) {
            player.sendMessage(Text.literal("§7" + quest.completeMessage), false);
        }
    }
    
    private void grantReward(ServerPlayerEntity player, QuestData.Reward reward) {
        switch (reward.type) {
            case "xp":
                player.addExperience(reward.amount);
                player.sendMessage(Text.literal("§a+ " + reward.amount + " XP"), true);
                break;
            case "item":
                // Actually give the item
                try {
                    net.minecraft.item.Item item = net.minecraft.registry.Registries.ITEM.get(
                        net.minecraft.util.Identifier.of(reward.itemId));
                    if (item != net.minecraft.item.Items.AIR) {
                        net.minecraft.item.ItemStack stack = new net.minecraft.item.ItemStack(item, reward.amount);
                        if (!player.getInventory().insertStack(stack)) {
                            // Drop if inventory full
                            player.dropItem(stack, false);
                        }
                        player.sendMessage(Text.literal("§a+ " + reward.amount + "x " + item.getName().getString()), true);
                    } else {
                        // Try mod items
                        player.sendMessage(Text.literal("§a+ " + reward.amount + "x " + reward.itemId), true);
                    }
                } catch (Exception e) {
                    player.sendMessage(Text.literal("§a+ " + reward.amount + "x " + reward.itemId), true);
                }
                break;
            case "currency":
                // Currency is tracked separately
                player.sendMessage(Text.literal("§a+ " + reward.amount + " coins"), true);
                break;
        }
    }
    
    public List<QuestData> getAvailableQuests(ServerPlayerEntity player) {
        PlayerQuestState state = getPlayerState(player.getUuid());
        List<QuestData> available = new ArrayList<>();
        
        for (QuestData quest : questDefinitions.values()) {
            if (!state.isQuestActive(quest.id) && !state.isQuestCompleted(quest.id)) {
                // Check prerequisites
                boolean canStart = true;
                if (quest.prerequisites != null) {
                    for (String prereq : quest.prerequisites) {
                        if (!state.isQuestCompleted(prereq)) {
                            canStart = false;
                            break;
                        }
                    }
                }
                if (canStart) {
                    available.add(quest);
                }
            }
        }
        
        return available;
    }
    
    public List<QuestData> getActiveQuests(ServerPlayerEntity player) {
        PlayerQuestState state = getPlayerState(player.getUuid());
        List<QuestData> active = new ArrayList<>();
        
        for (String questId : state.getActiveQuests()) {
            QuestData quest = questDefinitions.get(questId);
            if (quest != null) {
                active.add(quest);
            }
        }
        
        return active;
    }
    
    public Map<String, Integer> getQuestProgress(ServerPlayerEntity player, String questId) {
        return getPlayerState(player.getUuid()).getAllObjectiveProgress(questId);
    }
    
    // === PERSISTENCE ===
    
    private Path getSaveDirectory(MinecraftServer server) {
        return server.getSavePath(WorldSavePath.ROOT).resolve("stormbringerwand_quests");
    }
    
    public void loadAllPlayerStates(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        if (!Files.exists(saveDir)) return;
        
        try (var stream = Files.list(saveDir)) {
            stream.filter(p -> p.toString().endsWith(".json"))
                  .forEach(this::loadPlayerState);
        } catch (IOException e) {
            LOGGER.error("Failed to load player states", e);
        }
    }
    
    private void loadPlayerState(Path file) {
        try {
            String json = Files.readString(file);
            PlayerQuestState state = GSON.fromJson(json, PlayerQuestState.class);
            if (state != null && state.getPlayerId() != null) {
                playerStates.put(state.getPlayerId(), state);
            }
        } catch (IOException e) {
            LOGGER.error("Failed to load player state: " + file, e);
        }
    }
    
    public void saveAllPlayerStates(MinecraftServer server) {
        Path saveDir = getSaveDirectory(server);
        try {
            Files.createDirectories(saveDir);
            
            for (var entry : playerStates.entrySet()) {
                Path file = saveDir.resolve(entry.getKey().toString() + ".json");
                String json = GSON.toJson(entry.getValue());
                Files.writeString(file, json);
            }
        } catch (IOException e) {
            LOGGER.error("Failed to save player states", e);
        }
    }
    
    public void savePlayerState(MinecraftServer server, UUID playerId) {
        PlayerQuestState state = playerStates.get(playerId);
        if (state == null) return;
        
        Path saveDir = getSaveDirectory(server);
        try {
            Files.createDirectories(saveDir);
            Path file = saveDir.resolve(playerId.toString() + ".json");
            String json = GSON.toJson(state);
            Files.writeString(file, json);
        } catch (IOException e) {
            LOGGER.error("Failed to save player state: " + playerId, e);
        }
    }
    
    public int getQuestCount() {
        return questDefinitions.size();
    }
    
    public Collection<QuestData> getAllQuests() {
        return questDefinitions.values();
    }
}