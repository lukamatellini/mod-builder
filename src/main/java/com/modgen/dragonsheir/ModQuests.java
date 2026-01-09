package com.modgen.dragonsheir;

import java.util.*;

public class ModQuests {
    private static final Map<String, Quest> QUESTS = new HashMap<>();
    
    public static void registerQuests() {
        DragonsHeir.LOGGER.info("Registering 3 quests");
        QUESTS.put("dragon_slayer", new Quest("dragon_slayer", "The Dragon Slayer's Oath", "undefined"));
        QUESTS.put("crystal_collector", new Quest("crystal_collector", "The Shard Hunt", "undefined"));
        QUESTS.put("void_explorer", new Quest("void_explorer", "Into the Abyss", "undefined"));
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