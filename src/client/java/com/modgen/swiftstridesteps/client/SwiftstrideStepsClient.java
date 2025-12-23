package com.modgen.swiftstridesteps.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal client entrypoint
 */
@Environment(EnvType.CLIENT)
public class SwiftstrideStepsClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("swiftstridesteps/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Swiftstride Steps client initialized");
    }
}