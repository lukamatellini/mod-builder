package com.modgen.shatteredconquest.client;

import com.modgen.shatteredconquest.network.ModPackets;
import com.modgen.shatteredconquest.client.screen.ProgressBarHud;
import com.modgen.shatteredconquest.client.screen.DialogueScreen;
import com.modgen.shatteredconquest.client.screen.QuestJournalScreen;
import com.modgen.shatteredconquest.client.screen.TradingScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

import java.util.stream.Collectors;

/**
 * Client-side networking handlers
 * MUST be in src/client/java - contains net.minecraft.client imports
 */
@Environment(EnvType.CLIENT)
public class ModClientNetworking {

    // Current merchant ID for trade execution
    private static String currentMerchantId = null;
    
    public static void registerClientPackets() {

        // Handle open journal
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.OpenJournalPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                MinecraftClient.getInstance().setScreen(new QuestJournalScreen());
            });
        });

        // Handle dialogue
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.DialoguePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                MinecraftClient.getInstance().setScreen(new DialogueScreen(
                    payload.npcName(), payload.lines(), payload.choices()
                ));
            });
        });
        
        // Handle close dialogue
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.CloseDialoguePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                if (MinecraftClient.getInstance().currentScreen instanceof DialogueScreen) {
                    MinecraftClient.getInstance().setScreen(null);
                }
            });
        });

        // Handle open trading screen
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.OpenTradingPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                currentMerchantId = payload.merchantId();
                
                var trades = payload.trades().stream()
                    .map(t -> new TradingScreen.TradeDisplayData(
                        t.tradeId(),
                        t.outputName(),
                        t.outputCount(),
                        t.inputNames(),
                        t.inputCounts(),
                        t.stock(),
                        t.canAfford(),
                        t.requiredReputation()
                    ))
                    .collect(Collectors.toList());
                
                MinecraftClient.getInstance().setScreen(new TradingScreen(payload.merchantName(), trades));
            });
        });

        // Handle progress bar updates
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.ProgressBarUpdatePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ProgressBarHud.addProgressBar(
                    payload.barId(),
                    payload.label(),
                    payload.progress(),
                    payload.color(),
                    payload.durationTicks()
                );
            });
        });
    }
    
    // === SEND METHODS (Client -> Server) ===

    public static void sendDialogueChoice(int index) {
        ClientPlayNetworking.send(new ModPackets.DialogueChoicePayload(index));
    }

    /**
     * Send trade execution request to server
     */
    public static void sendExecuteTrade(int tradeIndex) {
        if (currentMerchantId != null) {
            ClientPlayNetworking.send(new ModPackets.ExecuteTradePayload(currentMerchantId, tradeIndex));
        }
    }
}