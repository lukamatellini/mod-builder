package com.modgen.blockfortune.client;

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
public class BlockFortuneClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("blockfortune/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Block Fortune client...");
        
        // No entity renderers to register
        
        LOGGER.info("Block Fortune client initialized");
    }

}