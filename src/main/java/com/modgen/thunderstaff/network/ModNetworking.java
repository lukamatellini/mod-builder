package com.modgen.thunderstaff.network;

import com.modgen.thunderstaff.ThunderStaff;
import com.modgen.thunderstaff.client.screen.DialogueScreen;
import com.modgen.thunderstaff.client.screen.QuestJournalScreen;
import com.modgen.thunderstaff.engine.DialogueEngine;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ModNetworking {
    
    // Packet IDs
    public static final Identifier OPEN_JOURNAL_ID = Identifier.of("thunderstaff", "open_journal");
    public static final Identifier DIALOGUE_ID = Identifier.of("thunderstaff", "dialogue");
    public static final Identifier CLOSE_DIALOGUE_ID = Identifier.of("thunderstaff", "close_dialogue");
    public static final Identifier DIALOGUE_CHOICE_ID = Identifier.of("thunderstaff", "dialogue_choice");
    
    // === SERVER-SIDE REGISTRATION ===
    public static void registerServerPackets() {
        // Register packet types
        PayloadTypeRegistry.playS2C().register(OpenJournalPayload.ID, OpenJournalPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(DialoguePayload.ID, DialoguePayload.CODEC);
        PayloadTypeRegistry.playS2C().register(CloseDialoguePayload.ID, CloseDialoguePayload.CODEC);
        PayloadTypeRegistry.playC2S().register(DialogueChoicePayload.ID, DialogueChoicePayload.CODEC);
        
        // Handle incoming packets from client
        ServerPlayNetworking.registerGlobalReceiver(DialogueChoicePayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                ThunderStaff.NPC_MANAGER.getDialogueEngine().selectChoice(context.player(), payload.choiceIndex);
            });
        });
    }
    
    // === CLIENT-SIDE REGISTRATION ===
    @Environment(EnvType.CLIENT)
    public static void registerClientPackets() {
        // Handle open journal
        ClientPlayNetworking.registerGlobalReceiver(OpenJournalPayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                MinecraftClient.getInstance().setScreen(new QuestJournalScreen());
            });
        });
        
        // Handle dialogue
        ClientPlayNetworking.registerGlobalReceiver(DialoguePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                MinecraftClient.getInstance().setScreen(new DialogueScreen(
                    payload.npcName, payload.lines, payload.choices
                ));
            });
        });
        
        // Handle close dialogue
        ClientPlayNetworking.registerGlobalReceiver(CloseDialoguePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                if (MinecraftClient.getInstance().currentScreen instanceof DialogueScreen) {
                    MinecraftClient.getInstance().setScreen(null);
                }
            });
        });
    }
    
    // === SEND METHODS ===
    public static void sendOpenJournal(ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, new OpenJournalPayload());
    }
    
    public static void sendDialogueToClient(ServerPlayerEntity player, String npcName, DialogueEngine.DialogueNode node) {
        List<String> choiceTexts = new ArrayList<>();
        if (node.choices != null) {
            for (var choice : node.choices) {
                choiceTexts.add(choice.text);
            }
        }
        ServerPlayNetworking.send(player, new DialoguePayload(npcName, node.lines, choiceTexts));
    }
    
    public static void sendCloseDialogue(ServerPlayerEntity player) {
        ServerPlayNetworking.send(player, new CloseDialoguePayload());
    }
    
    @Environment(EnvType.CLIENT)
    public static void sendDialogueChoice(int index) {
        ClientPlayNetworking.send(new DialogueChoicePayload(index));
    }
    
    // === PAYLOAD CLASSES ===
    public record OpenJournalPayload() implements CustomPayload {
        public static final CustomPayload.Id<OpenJournalPayload> ID = new CustomPayload.Id<>(OPEN_JOURNAL_ID);
        public static final PacketCodec<RegistryByteBuf, OpenJournalPayload> CODEC = 
            PacketCodec.unit(new OpenJournalPayload());
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
    
    public record DialoguePayload(String npcName, List<String> lines, List<String> choices) implements CustomPayload {
        public static final CustomPayload.Id<DialoguePayload> ID = new CustomPayload.Id<>(DIALOGUE_ID);
        public static final PacketCodec<RegistryByteBuf, DialoguePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, DialoguePayload::npcName,
            PacketCodecs.STRING.collect(PacketCodecs.toList()), DialoguePayload::lines,
            PacketCodecs.STRING.collect(PacketCodecs.toList()), DialoguePayload::choices,
            DialoguePayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
    
    public record CloseDialoguePayload() implements CustomPayload {
        public static final CustomPayload.Id<CloseDialoguePayload> ID = new CustomPayload.Id<>(CLOSE_DIALOGUE_ID);
        public static final PacketCodec<RegistryByteBuf, CloseDialoguePayload> CODEC = 
            PacketCodec.unit(new CloseDialoguePayload());
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
    
    public record DialogueChoicePayload(int choiceIndex) implements CustomPayload {
        public static final CustomPayload.Id<DialogueChoicePayload> ID = new CustomPayload.Id<>(DIALOGUE_CHOICE_ID);
        public static final PacketCodec<RegistryByteBuf, DialogueChoicePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER, DialogueChoicePayload::choiceIndex,
            DialogueChoicePayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
}