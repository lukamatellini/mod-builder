package com.modgen.bananablaster.engine;

import java.util.List;

/**
 * Quest data structure - loaded from JSON
 */
public class QuestData {
    public String id;
    public String name;
    public String description;
    public String type;
    public List<String> prerequisites;
    public List<Objective> objectives;
    public List<Reward> rewards;
    public String startMessage;
    public String completeMessage;
    public boolean repeatable;
    public String giverNpcId;
    
    public static class Objective {
        public String id;
        public String type; // kill_mob, collect_item, break_block, talk_to_npc, reach_location
        public String description;
        public String targetId;
        public int count;
        public boolean optional;
    }
    
    public static class Reward {
        public String type; // xp, item, currency
        public String itemId;
        public int amount;
    }
}