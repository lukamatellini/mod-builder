package com.modgen.stormcaller.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.modgen.stormcaller.StormCaller;
import com.modgen.stormcaller.network.ModNetworking;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Dialogue Engine - Handles NPC conversations with branching choices
 * ID-DRIVEN: Every dialogue must be addressable by NPC ID
 */
public class DialogueEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormcaller/dialogue");
    private static final Gson GSON = new GsonBuilder().create();
    
    // Dialogue trees loaded from JSON (npcId -> dialogue tree)
    private final Map<String, DialogueTree> dialogueTrees = new ConcurrentHashMap<>();
    
    // Active conversations (playerId -> conversation state)
    private final Map<UUID, ConversationState> activeConversations = new ConcurrentHashMap<>();
    
    public int loadDialoguesFromResources(MinecraftServer server) {
        dialogueTrees.clear();
        
        try {
            var resourceManager = server.getResourceManager();
            var dialogueFiles = resourceManager.findResources("dialogue", id -> id.getPath().endsWith(".json"));
            
            for (var entry : dialogueFiles.entrySet()) {
                Identifier id = entry.getKey();
                if (!id.getNamespace().equals("stormcaller")) continue;
                
                try (var stream = entry.getValue().getInputStream()) {
                    String json = new String(stream.readAllBytes());
                    DialogueTree tree = GSON.fromJson(json, DialogueTree.class);
                    if (tree != null && tree.npcId != null) {
                        // Validate dialogue has actual content
                        if (tree.nodes == null || tree.nodes.isEmpty()) {
                            LOGGER.error("!!! EMPTY DIALOGUE: {} has no nodes !!!", tree.npcId);
                            continue;
                        }
                        if (tree.startNode == null || !tree.nodes.containsKey(tree.startNode)) {
                            LOGGER.error("!!! INVALID DIALOGUE: {} has missing startNode !!!", tree.npcId);
                            continue;
                        }
                        dialogueTrees.put(tree.npcId, tree);
                        LOGGER.info("Loaded dialogue for NPC: {} ({} nodes)", tree.npcId, tree.nodes.size());
                    }
                } catch (Exception e) {
                    LOGGER.error("Failed to load dialogue: " + id, e);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Failed to scan dialogue resources", e);
        }
        
        return dialogueTrees.size();
    }
    
    /**
     * Check if dialogue exists for an NPC ID
     */
    public boolean hasDialogueFor(String npcId) {
        return dialogueTrees.containsKey(npcId);
    }
    
    public void startDialogue(ServerPlayerEntity player, String npcId) {
        DialogueTree tree = dialogueTrees.get(npcId);
        if (tree == null) {
            player.sendMessage(Text.literal("§7..."), false);
            return;
        }
        
        ConversationState state = new ConversationState(npcId, tree.startNode);
        activeConversations.put(player.getUuid(), state);
        
        sendDialogueNode(player, tree, tree.startNode);
    }
    
    public void selectChoice(ServerPlayerEntity player, int choiceIndex) {
        ConversationState state = activeConversations.get(player.getUuid());
        if (state == null) return;
        
        DialogueTree tree = dialogueTrees.get(state.npcId);
        if (tree == null) return;
        
        DialogueNode currentNode = tree.nodes.get(state.currentNodeId);
        if (currentNode == null || currentNode.choices == null) return;
        
        if (choiceIndex < 0 || choiceIndex >= currentNode.choices.size()) return;
        
        DialogueChoice choice = currentNode.choices.get(choiceIndex);
        
        // Execute action
        if (choice.action != null) {
            executeAction(player, choice.action);
        }
        
        // Move to next node or end conversation
        if (choice.nextNode != null) {
            state.currentNodeId = choice.nextNode;
            sendDialogueNode(player, tree, choice.nextNode);
        } else {
            endDialogue(player);
        }
    }
    
    private void sendDialogueNode(ServerPlayerEntity player, DialogueTree tree, String nodeId) {
        DialogueNode node = tree.nodes.get(nodeId);
        if (node == null) {
            endDialogue(player);
            return;
        }
        
        // Send dialogue data to client
        ModNetworking.sendDialogueToClient(player, tree.npcName, node);
    }
    
    private void executeAction(ServerPlayerEntity player, DialogueAction action) {
        switch (action.type) {
            case "start_quest":
                StormCaller.QUEST_ENGINE.startQuest(player, action.questId);
                break;
            case "complete_quest":
                StormCaller.QUEST_ENGINE.completeQuest(player, action.questId);
                break;
            case "open_trade":
                // TODO: Open trading UI
                break;
            case "give_item":
                // TODO: Give item to player
                break;
        }
    }
    
    public void endDialogue(ServerPlayerEntity player) {
        activeConversations.remove(player.getUuid());
        ModNetworking.sendCloseDialogue(player);
    }
    
    public boolean isInDialogue(ServerPlayerEntity player) {
        return activeConversations.containsKey(player.getUuid());
    }
    
    // Data classes
    public static class DialogueTree {
        public String npcId;
        public String npcName;
        public String startNode;
        public Map<String, DialogueNode> nodes;
    }
    
    public static class DialogueNode {
        public String id;
        public List<String> lines;
        public List<DialogueChoice> choices;
    }
    
    public static class DialogueChoice {
        public String text;
        public String nextNode;
        public DialogueAction action;
    }
    
    public static class DialogueAction {
        public String type;
        public String questId;
        public String itemId;
        public int amount;
    }
    
    private static class ConversationState {
        String npcId;
        String currentNodeId;
        
        ConversationState(String npcId, String startNode) {
            this.npcId = npcId;
            this.currentNodeId = startNode;
        }
    }
}