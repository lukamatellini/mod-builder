package com.modgen.voidconquest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("voidconquest/structures");
    
    public static void registerStructures() {
        VoidConquest.LOGGER.info("Registering 3 structures");
        LOGGER.info("  - Void Citadel (floating)");
        LOGGER.info("  - Crystal Cave (underground)");
        LOGGER.info("  - Abandoned Outpost (surface)");
    }
}