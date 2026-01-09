package com.modgen.twilightgemcraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.twilightgemcraft.entity.ModEntities;
import com.modgen.twilightgemcraft.client.ModModelLayers;
import com.modgen.twilightgemcraft.client.model.NightProwlerModel;
import com.modgen.twilightgemcraft.client.renderer.NightProwlerRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class TwilightGemcraftClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("twilightgemcraft/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Twilight Gemcraft client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Twilight Gemcraft client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.NIGHT_PROWLER, NightProwlerRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NIGHT_PROWLER, NightProwlerModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}