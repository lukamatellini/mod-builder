package com.modgen.fortuneblocks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal client entrypoint
 */
@Environment(EnvType.CLIENT)
public class FortuneBlocksClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("fortuneblocks/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Fortune Blocks client initialized");
    }
}