package com.modgen.stormcaller.network;

import com.modgen.stormcaller.StormCaller;
import com.modgen.stormcaller.engine.DialogueEngine;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.List;

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
        
        // Register C2S packet types (client sends to server)
        PayloadTypeRegistry.playC2S().register(ModPackets.DialogueChoicePayload.ID, ModPackets.DialogueChoicePayload.CODEC);
        
        // Handle incoming packets from client
        ServerPlayNetworking.registerGlobalReceiver(ModPackets.DialogueChoicePayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                StormCaller.NPC_MANAGER.getDialogueEngine().selectChoice(context.player(), payload.choiceIndex());
            });
        });
        
        StormCaller.LOGGER.info("Registered server networking");
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
}