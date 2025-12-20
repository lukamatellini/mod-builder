package com.modgen.festivechests.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal client entrypoint
 */
@Environment(EnvType.CLIENT)
public class FestiveChestsClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("festivechests/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Festive Chests client initialized");
    }
}