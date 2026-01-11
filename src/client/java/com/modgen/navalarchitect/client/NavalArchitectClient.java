package com.modgen.navalarchitect.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class NavalArchitectClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("navalarchitect/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Naval Architect client...");
        
        // No entity renderers to register
        
        LOGGER.info("Naval Architect client initialized");
    }

}