package com.modgen.cheesyblade.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.cheesyblade.entity.ModEntities;
import com.modgen.cheesyblade.client.ModModelLayers;
import com.modgen.cheesyblade.client.model.CheeseGolemModel;
import com.modgen.cheesyblade.client.renderer.CheeseGolemRenderer;
import com.modgen.cheesyblade.client.model.HungryMouseModel;
import com.modgen.cheesyblade.client.renderer.HungryMouseRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class CheesyBladeClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("cheesyblade/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Cheesy Blade client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Cheesy Blade client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.CHEESE_GOLEM, CheeseGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.HUNGRY_MOUSE, HungryMouseRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CHEESE_GOLEM, CheeseGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.HUNGRY_MOUSE, HungryMouseModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}