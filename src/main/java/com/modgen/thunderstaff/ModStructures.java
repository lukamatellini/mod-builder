package com.modgen.thunderstaff;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("thunderstaff/structures");
    
    public static void registerStructures() {
        ThunderStaff.LOGGER.info("Registering 1 structures");
        LOGGER.info("  - Wizard Tower (surface)");
    }
}