package com.modgen.romanempire;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("romanempire/structures");
    
    public static void registerStructures() {
        RomanEmpire.LOGGER.info("Registering 3 structures");
        LOGGER.info("  - Roman Camp (surface)");
        LOGGER.info("  - Roman Fort (surface)");
        LOGGER.info("  - Imperial Palace (surface)");
    }
}