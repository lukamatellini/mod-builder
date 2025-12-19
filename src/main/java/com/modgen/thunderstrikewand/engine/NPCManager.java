package com.modgen.thunderstrikewand.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modgen.thunderstrikewand.ThunderstrikeWand;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * NPC Manager - ID-DRIVEN with STRICT VALIDATION
 * 
 * RULES:
 * - Every NPC ID must map to a registered definition
 * - Spawning unknown IDs FAILS LOUDLY
 * - No fallback to "default" NPC
 */
public class NPCManager {
    private static final Logger LOGGER = LoggerFactory.getLogger("thunderstrikewand/npcs");
    private static final Gson GSON = new GsonBuilder().create();
    
    // NPC definitions loaded at startup - ID-addressable
    private final Map<String, NPCDefinition> npcDefinitions = new ConcurrentHashMap<>();
    private final DialogueEngine dialogueEngine = new DialogueEngine();
    
    public NPCManager() {
        // Register NPC definitions from build-time spec
        registerNPCDefinitions();
    }
    
    private void registerNPCDefinitions() {
        LOGGER.info("Registered {} NPC definitions", npcDefinitions.size());
    }
    
    public int loadNPCsFromResources(MinecraftServer server) {
        // Load dialogue trees
        int dialogueCount = dialogueEngine.loadDialoguesFromResources(server);
        
        // Validate: every NPC definition must have corresponding dialogue
        int validatedCount = 0;
        for (String npcId : npcDefinitions.keySet()) {
            if (dialogueEngine.hasDialogueFor(npcId)) {
                validatedCount++;
            } else {
                LOGGER.error("!!! ORPHAN NPC: {} has no dialogue data !!!", npcId);
            }
        }
        
        return validatedCount;
    }
    
    /**
     * STRICT NPC ID validation - returns null if ID not found
     * Callers MUST handle null and report error
     */
    public NPCDefinition getNPCDefinition(String npcId) {
        return npcDefinitions.get(npcId);
    }
    
    /**
     * Check if NPC ID is registered
     */
    public boolean isValidNPCId(String npcId) {
        return npcDefinitions.containsKey(npcId);
    }
    
    /**
     * Get all valid NPC IDs for command suggestions
     */
    public Set<String> getValidNPCIds() {
        return new HashSet<>(npcDefinitions.keySet());
    }
    
    public DialogueEngine getDialogueEngine() {
        return dialogueEngine;
    }
    
    public void onNPCInteract(ServerPlayerEntity player, String npcId) {
        if (!isValidNPCId(npcId)) {
            LOGGER.warn("Player {} tried to interact with invalid NPC: {}", player.getName().getString(), npcId);
            player.sendMessage(Text.literal("§cThis NPC has no dialogue"), false);
            return;
        }
        dialogueEngine.startDialogue(player, npcId);
    }
    
    public static class NPCDefinition {
        public final String id;
        public final String name;
        public final String title;
        public final String profession;
        
        public NPCDefinition(String id, String name, String title, String profession) {
            this.id = id;
            this.name = name;
            this.title = title;
            this.profession = profession;
        }
    }
}