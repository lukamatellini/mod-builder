package com.modgen.thunderclaprod.client;

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
public class ThunderclapRodClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("thunderclaprod/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Thunderclap Rod client...");
        
        // Register entity renderers
        // No entity renderers to register
        
        // Register model layers
        // No model layers to register
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        // No keybinds to register
        
        // Register HUD overlay (quest progress, mana bar, status effects)
        ModHudOverlay.register();
        
        LOGGER.info("Thunderclap Rod client initialized");
    }

}