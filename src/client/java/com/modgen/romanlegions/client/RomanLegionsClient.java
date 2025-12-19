package com.modgen.romanlegions.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class RomanLegionsClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("romanlegions/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Roman Legions client...");
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Roman Legions client initialized");
    }
}