package com.modgen.gemstoneodyssey;

import java.util.*;

public class ModQuests {
    private static final Map<String, Quest> QUESTS = new HashMap<>();
    
    public static void registerQuests() {
        GemstoneOdyssey.LOGGER.info("Registering 4 quests");
        QUESTS.put("the_sunken_treasure", new Quest("the_sunken_treasure", "The Sunken Treasure", "undefined"));
        QUESTS.put("ghost_fleet", new Quest("ghost_fleet", "The Ghost Fleet", "undefined"));
        QUESTS.put("the_elemental_calling", new Quest("the_elemental_calling", "The Elemental Calling", "undefined"));
        QUESTS.put("shadows_overworld", new Quest("shadows_overworld", "Shadows Over the Overworld", "undefined"));
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