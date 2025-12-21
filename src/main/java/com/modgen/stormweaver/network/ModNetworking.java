package com.modgen.stormweaver.network;

import com.modgen.stormweaver.StormWeaver;
import com.modgen.stormweaver.engine.DialogueEngine;
import com.modgen.stormweaver.engine.TradingSystem;
import com.modgen.stormweaver.engine.AchievementSystem;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Server-side networking - NO CLIENT IMPORTS
 * All client handling is in src/client/java
 */
public class ModNetworking {
    
    // === SERVER-SIDE REGISTRATION ===
    public static void registerServerPackets() {
        // Register S2C packet types (server sends to client)
        PayloadTypeRegistry.playS2C().register(ModPackets.OpenJournalPayload.ID, ModPackets.OpenJournalPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModPackets.DialoguePayload.ID, ModPackets.DialoguePayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModPackets.CloseDialoguePayload.ID, ModPackets.CloseDialoguePayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModPackets.OpenTradingPayload.ID, ModPackets.OpenTradingPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModPackets.OpenAchievementsPayload.ID, ModPackets.OpenAchievementsPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModPackets.AchievementUnlockedPayload.ID, ModPackets.AchievementUnlockedPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ModPackets.ProgressBarUpdatePayload.ID, ModPackets.ProgressBarUpdatePayload.CODEC);
        
        // Register C2S packet types (client sends to server)
        PayloadTypeRegistry.playC2S().register(ModPackets.DialogueChoicePayload.ID, ModPackets.DialogueChoicePayload.CODEC);
        PayloadTypeRegistry.playC2S().register(ModPackets.ExecuteTradePayload.ID, ModPackets.ExecuteTradePayload.CODEC);
        
        // Handle incoming packets from client
        // NOTE: Fabric 1.21.x Context has no server() method - use player().getServer()
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.DialogueChoicePayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            player.getServer().execute(() -> {
                StormWeaver.NPC_MANAGER.getDialogueEngine().selectChoice(player, payload.choiceIndex());
            });
        });
        
        // Handle trade execution
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.ExecuteTradePayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            player.getServer().execute(() -> {
                StormWeaver.TRADING_SYSTEM.executeTradeById(player, payload.merchantId(), payload.tradeIndex());
            });
        });
        
        StormWeaver.LOGGER.info("Registered server networking");
    }
    
    // === SEND METHODS (Server -> Client) ===
    public static void sendOpenJournal(ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, new ModPackets.OpenJournalPayload());
    }
    
    public static void sendDialogueToClient(ServerPlayerEntity player, String npcName, DialogueEngine.DialogueNode node) {
        List<String> choiceTexts = new ArrayList<>();
        if (node.choices != null) {
            for (var choice : node.choices) {
                choiceTexts.add(choice.text);
            }
        }
        ServerPlayNetworking.send(player, new ModPackets.DialoguePayload(npcName, node.lines, choiceTexts));
    }
    
    public static void sendCloseDialogue(ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, new ModPackets.CloseDialoguePayload());
    }
    
    /**
     * Send trading UI data to client
     */
    public static void sendOpenTrading(ServerPlayerEntity player, String merchantId, String merchantName, 
                                       List<TradingSystem.TradeOffer> trades) {
        List<ModPackets.TradeData> tradeDataList = new ArrayList<>();
        for (int i = 0; i < trades.size(); i++) {
            TradingSystem.TradeOffer trade = trades.get(i);
            List<String> inputNames = trade.inputItems.stream()
                .map(item -> item.getItem().getName().getString())
                .collect(Collectors.toList());
            List<Integer> inputCounts = trade.inputItems.stream()
                .map(item -> item.getCount())
                .collect(Collectors.toList());
            
            String outputName = trade.outputItem.getItem().getName().getString();
            int outputCount = trade.outputItem.getCount();
            
            boolean canAfford = StormWeaver.TRADING_SYSTEM.canAfford(player, trade);
            int stock = trade.maxStock - StormWeaver.TRADING_SYSTEM.getTradeUsage(player.getUuid(), merchantId, i);
            
            tradeDataList.add(new ModPackets.TradeData(
                String.valueOf(i),
                outputName,
                outputCount,
                inputNames,
                inputCounts,
                trade.maxStock > 0 ? stock : -1,
                canAfford,
                trade.requiredReputation
            ));
        }
        
        ServerPlayNetworking.send(player, new ModPackets.OpenTradingPayload(merchantId, merchantName, tradeDataList));
    }
    
    /**
     * Send achievements UI data to client
     */
    public static void sendOpenAchievements(ServerPlayerEntity player) {
        List<AchievementSystem.AchievementStatus> statuses = 
            StormWeaver.ACHIEVEMENT_SYSTEM.getAchievementsForPlayer(player.getUuid());
        
        List<ModPackets.AchievementData> achievementDataList = statuses.stream()
            .map(status -> new ModPackets.AchievementData(
                status.achievement.id,
                status.achievement.name,
                status.achievement.description,
                status.unlocked,
                status.progress,
                status.achievement.requiredCount,
                status.achievement.xpReward
            ))
            .collect(Collectors.toList());
        
        ServerPlayNetworking.send(player, new ModPackets.OpenAchievementsPayload(achievementDataList));
    }
    
    /**
     * Send achievement unlocked notification
     */
    public static void sendAchievementUnlocked(ServerPlayerEntity player, String achievementName, int xpReward) {
        ServerPlayNetworking.send(player, new ModPackets.AchievementUnlockedPayload(achievementName, xpReward));
    }
    
    /**
     * Send progress bar update
     */
    public static void sendProgressBarUpdate(ServerPlayerEntity player, String barId, String label, 
                                             float progress, int color, int durationTicks) {
        ServerPlayNetworking.send(player, new ModPackets.ProgressBarUpdatePayload(barId, label, progress, color, durationTicks));
    }
}