package com.modgen.romanlegions.client;

import com.modgen.romanlegions.network.ModPackets;
import com.modgen.romanlegions.client.screen.DialogueScreen;
import com.modgen.romanlegions.client.screen.QuestJournalScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;

/**
 * Client-side networking handlers
 * MUST be in src/client/java - contains net.minecraft.client imports
 */
@Environment(EnvType.CLIENT)
public class ModClientNetworking {
    
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
    }
    
    public static void sendDialogueChoice(int index) {
        ClientPlayNetworking.send(new ModPackets.DialogueChoicePayload(index));
    }
}