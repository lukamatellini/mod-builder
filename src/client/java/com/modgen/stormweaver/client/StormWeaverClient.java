package com.modgen.stormweaver.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal client entrypoint
 */
@Environment(EnvType.CLIENT)
public class StormWeaverClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormweaver/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Storm Weaver client initialized");
    }
}