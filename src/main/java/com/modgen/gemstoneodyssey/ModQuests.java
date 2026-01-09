package com.modgen.gemstoneodyssey;

import java.util.*;

public class ModQuests {
    private static final Map<String, Quest> QUESTS = new HashMap<>();
    
    public static void registerQuests() {
        GemstoneOdyssey.LOGGER.info("Registering 3 quests");
        QUESTS.put("dragon_slayer", new Quest("dragon_slayer", "Dragon Slayer", "undefined"));
        QUESTS.put("crystal_collector", new Quest("crystal_collector", "Crystal Collector", "undefined"));
        QUESTS.put("void_explorer", new Quest("void_explorer", "Void Explorer", "undefined"));
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