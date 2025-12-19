package com.modgen.romanlegions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("romanlegions/structures");
    
    public static void registerStructures() {
        RomanLegions.LOGGER.info("Registering 3 structures");
        LOGGER.info("  - Castrum (surface)");
        LOGGER.info("  - Roman Outpost (surface)");
        LOGGER.info("  - Barbarian Camp (surface)");
    }
}