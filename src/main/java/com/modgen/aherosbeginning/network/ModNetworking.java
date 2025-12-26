package com.modgen.aherosbeginning.network;

import com.modgen.aherosbeginning.AHerosBeginning;
import com.modgen.aherosbeginning.engine.DialogueEngine;
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
        PayloadTypeRegistry.playS2C().register(ModPackets.ProgressBarUpdatePayload.ID, ModPackets.ProgressBarUpdatePayload.CODEC);
        
        // Register C2S packet types (client sends to server)
        PayloadTypeRegistry.playC2S().register(ModPackets.DialogueChoicePayload.ID, ModPackets.DialogueChoicePayload.CODEC);

        // Handle dialogue choice from client
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.DialogueChoicePayload.ID, (payload, context) -> {
            ServerPlayerEntity player = context.player();
            player.getServer().execute(() -> {
                AHerosBeginning.NPC_MANAGER.getDialogueEngine().selectChoice(player, payload.choiceIndex());
            });
        });
        
        AHerosBeginning.LOGGER.info("Registered server networking");
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
     * Send progress bar update
     */
    public static void sendProgressBarUpdate(ServerPlayerEntity player, String barId, String label, 
                                             float progress, int color, int durationTicks) {
        ServerPlayNetworking.send(player, new ModPackets.ProgressBarUpdatePayload(barId, label, progress, color, durationTicks));
    }
}