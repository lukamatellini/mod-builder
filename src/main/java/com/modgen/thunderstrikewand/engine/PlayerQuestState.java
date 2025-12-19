package com.modgen.thunderstrikewand.engine;

import java.util.*;

/**
 * Per-player quest state - persisted to disk
 */
public class PlayerQuestState {
    private UUID playerId;
    private Set<String> activeQuests = new HashSet<>();
    private Set<String> completedQuests = new HashSet<>();
    private Map<String, Map<String, Integer>> objectiveProgress = new HashMap<>();
    
    public PlayerQuestState() {}
    
    public PlayerQuestState(UUID playerId) {
        this.playerId = playerId;
    }
    
    public UUID getPlayerId() {
        return playerId;
    }
    
    public boolean isQuestActive(String questId) {
        return activeQuests.contains(questId);
    }
    
    public boolean isQuestCompleted(String questId) {
        return completedQuests.contains(questId);
    }
    
    public Set<String> getActiveQuests() {
        return new HashSet<>(activeQuests);
    }
    
    public Set<String> getCompletedQuests() {
        return new HashSet<>(completedQuests);
    }
    
    public void startQuest(String questId, QuestData quest) {
        activeQuests.add(questId);
        objectiveProgress.put(questId, new HashMap<>());
        for (QuestData.Objective obj : quest.objectives) {
            objectiveProgress.get(questId).put(obj.id, 0);
        }
    }
    
    public void completeQuest(String questId) {
        activeQuests.remove(questId);
        completedQuests.add(questId);
        objectiveProgress.remove(questId);
    }
    
    public int incrementObjective(String questId, String objectiveId) {
        Map<String, Integer> questProgress = objectiveProgress.get(questId);
        if (questProgress == null) return 0;
        
        int current = questProgress.getOrDefault(objectiveId, 0);
        questProgress.put(objectiveId, current + 1);
        return current + 1;
    }
    
    public void setObjectiveProgress(String questId, String objectiveId, int progress) {
        Map<String, Integer> questProgress = objectiveProgress.computeIfAbsent(questId, k -> new HashMap<>());
        questProgress.put(objectiveId, progress);
    }
    
    public int getObjectiveProgress(String questId, String objectiveId) {
        Map<String, Integer> questProgress = objectiveProgress.get(questId);
        if (questProgress == null) return 0;
        return questProgress.getOrDefault(objectiveId, 0);
    }
    
    public Map<String, Integer> getAllObjectiveProgress(String questId) {
        return objectiveProgress.getOrDefault(questId, new HashMap<>());
    }
}