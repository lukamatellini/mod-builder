package com.modgen.voidconquest.client;

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
public class VoidConquestClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("voidconquest/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Void Conquest client...");
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Void Conquest client initialized");
    }
}