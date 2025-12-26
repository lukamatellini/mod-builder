package com.modgen.strideenchant.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Minimal client entrypoint
 */
@Environment(EnvType.CLIENT)
public class StrideEnchantClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("strideenchant/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Stride Enchant client initialized");
    }
}