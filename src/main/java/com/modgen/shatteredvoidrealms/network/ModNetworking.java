package com.modgen.shatteredvoidrealms.network;

import com.modgen.shatteredvoidrealms.ShatteredVoidRealms;
import com.modgen.shatteredvoidrealms.engine.DialogueEngine;
import com.modgen.shatteredvoidrealms.engine.TradingSystem;
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
        PayloadTypeRegistry.playS2C().register(ModPackets.ProgressBarUpdatePayload.ID, ModPackets.ProgressBarUpdatePayload.CODEC);
        
        // Register C2S packet types (client sends to server)
        PayloadTypeRegistry.playC2S().register(ModPackets.DialogueChoicePayload.ID, ModPackets.DialogueChoicePayload.CODEC);
        PayloadTypeRegistry.playC2S().register(ModPackets.ExecuteTradePayload.ID, ModPackets.ExecuteTradePayload.CODEC);

        // Handle dialogue choice from client
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.DialogueChoicePayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            player.getServer().execute(() -> {
                ShatteredVoidRealms.NPC_MANAGER.getDialogueEngine().selectChoice(player, payload.choiceIndex());
            });
        });

        // Handle trade execution
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.ExecuteTradePayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            player.getServer().execute(() -> {
                ShatteredVoidRealms.TRADING_SYSTEM.executeTradeById(player, payload.merchantId(), payload.tradeIndex());
            });
        });
        
        ShatteredVoidRealms.LOGGER.info("Registered server networking");
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
     * NOTE: Uses string-based TradeOffer fields (inputItemId, outputItemId)
     */
    public static void sendOpenTrading(ServerPlayerEntity player, String merchantId, String merchantName, 
                                       List<TradingSystem.TradeOffer> trades) {
        List<ModPackets.TradeData> tradeDataList = new ArrayList<>();
        for (int i = 0; i < trades.size(); i++) {
            TradingSystem.TradeOffer trade = trades.get(i);
            
            // Use string-based item IDs from TradeOffer (not ItemStack)
            List<String> inputNames = new ArrayList<>();
            List<Integer> inputCounts = new ArrayList<>();
            inputNames.add(trade.inputItemId);
            inputCounts.add(trade.inputCount);
            if (trade.inputSecondaryId != null) {
                inputNames.add(trade.inputSecondaryId);
                inputCounts.add(trade.inputSecondaryCount);
            }
            
            String outputName = trade.outputItemId;
            int outputCount = trade.outputCount;
            
            boolean canAfford = ShatteredVoidRealms.TRADING_SYSTEM.canAfford(player, trade);
            int stock = trade.maxUses - ShatteredVoidRealms.TRADING_SYSTEM.getTradeUsage(player.getUuid(), merchantId, i);
            
            tradeDataList.add(new ModPackets.TradeData(
                String.valueOf(i),
                outputName,
                outputCount,
                inputNames,
                inputCounts,
                trade.maxUses > 0 ? stock : -1,
                canAfford,
                trade.requiredReputation
            ));
        }
        
        ServerPlayNetworking.send(player, new ModPackets.OpenTradingPayload(merchantId, merchantName, tradeDataList));
    }

    /**
     * Send progress bar update
     */
    public static void sendProgressBarUpdate(ServerPlayerEntity player, String barId, String label, 
                                             float progress, int color, int durationTicks) {
        ServerPlayNetworking.send(player, new ModPackets.ProgressBarUpdatePayload(barId, label, progress, color, durationTicks));
    }
}