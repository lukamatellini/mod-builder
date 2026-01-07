package com.modgen.sumoundeadworms.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.sumoundeadworms.entity.ModEntities;
import com.modgen.sumoundeadworms.client.ModModelLayers;
import com.modgen.sumoundeadworms.client.model.YokaiZombieModel;
import com.modgen.sumoundeadworms.client.renderer.YokaiZombieRenderer;
import com.modgen.sumoundeadworms.client.model.BurrowingWormModel;
import com.modgen.sumoundeadworms.client.renderer.BurrowingWormRenderer;
import com.modgen.sumoundeadworms.client.model.JapaneseSumoWrestlerModel;
import com.modgen.sumoundeadworms.client.renderer.JapaneseSumoWrestlerRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class SumoUndeadWormsClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("sumoundeadworms/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Sumo Undead Worms client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Sumo Undead Worms client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.YOKAI_ZOMBIE, YokaiZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.BURROWING_WORM, BurrowingWormRenderer::new);
        EntityRendererRegistry.register(ModEntities.JAPANESE_SUMO_WRESTLER, JapaneseSumoWrestlerRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.YOKAI_ZOMBIE, YokaiZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BURROWING_WORM, BurrowingWormModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.JAPANESE_SUMO_WRESTLER, JapaneseSumoWrestlerModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}