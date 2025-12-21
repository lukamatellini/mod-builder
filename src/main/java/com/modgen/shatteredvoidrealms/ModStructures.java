package com.modgen.shatteredvoidrealms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("shatteredvoidrealms/structures");
    
    public static void registerStructures() {
        ShatteredVoidRealms.LOGGER.info("Registering 3 structures");
        LOGGER.info("  - Void Citadel (floating)");
        LOGGER.info("  - Crystal Cave (underground)");
        LOGGER.info("  - Abandoned Outpost (surface)");
    }
}