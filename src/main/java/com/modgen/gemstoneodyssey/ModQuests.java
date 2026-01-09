package com.modgen.gemstoneodyssey;

import java.util.*;

public class ModQuests {
    private static final Map<String, Quest> QUESTS = new HashMap<>();
    
    public static void registerQuests() {
        GemstoneOdyssey.LOGGER.info("Registering 3 quests");
        QUESTS.put("dragon_slayer_quest", new Quest("dragon_slayer_quest", "The Ancient Dragon's Demise", "undefined"));
        QUESTS.put("crystal_collector_quest", new Quest("crystal_collector_quest", "Crystal Collection", "undefined"));
        QUESTS.put("void_explorer_quest", new Quest("void_explorer_quest", "Journey into the Void", "undefined"));
    }
    
    public static class Quest {
        public final String id;
        public final String name;
        public final String type;
        
        public Quest(String id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
        }
    }
}