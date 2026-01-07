package com.modgen.yokaiuprising.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.yokaiuprising.entity.ModEntities;
import com.modgen.yokaiuprising.client.ModModelLayers;
import com.modgen.yokaiuprising.client.model.MutatedZombieModel;
import com.modgen.yokaiuprising.client.renderer.MutatedZombieRenderer;
import com.modgen.yokaiuprising.client.model.CaveWormModel;
import com.modgen.yokaiuprising.client.renderer.CaveWormRenderer;
import com.modgen.yokaiuprising.client.model.SumoWrestlerModel;
import com.modgen.yokaiuprising.client.renderer.SumoWrestlerRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class YokaiUprisingClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("yokaiuprising/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Yokai Uprising client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Yokai Uprising client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.MUTATED_ZOMBIE, MutatedZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.CAVE_WORM, CaveWormRenderer::new);
        EntityRendererRegistry.register(ModEntities.SUMO_WRESTLER, SumoWrestlerRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MUTATED_ZOMBIE, MutatedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CAVE_WORM, CaveWormModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SUMO_WRESTLER, SumoWrestlerModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}