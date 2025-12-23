package com.modgen.swiftstriders.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal client entrypoint
 */
@Environment(EnvType.CLIENT)
public class SwiftStridersClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("swiftstriders/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Swift Striders client initialized");
    }
}