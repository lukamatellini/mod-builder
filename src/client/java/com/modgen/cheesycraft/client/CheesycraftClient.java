package com.modgen.cheesycraft.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.cheesycraft.entity.ModEntities;
import com.modgen.cheesycraft.client.ModModelLayers;
import com.modgen.cheesycraft.client.model.MouseModel;
import com.modgen.cheesycraft.client.renderer.MouseRenderer;
import com.modgen.cheesycraft.client.model.RatModel;
import com.modgen.cheesycraft.client.renderer.RatRenderer;
import com.modgen.cheesycraft.client.model.CheesyGolemModel;
import com.modgen.cheesycraft.client.renderer.CheesyGolemRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class CheesycraftClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("cheesycraft/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing CheesyCraft client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("CheesyCraft client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.MOUSE, MouseRenderer::new);
        EntityRendererRegistry.register(ModEntities.RAT, RatRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHEESY_GOLEM, CheesyGolemRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MOUSE, MouseModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CHEESY_GOLEM, CheesyGolemModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}