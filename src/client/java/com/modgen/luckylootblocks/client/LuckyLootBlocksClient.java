package com.modgen.luckylootblocks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.luckylootblocks.entity.ModEntities;
import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.ReinforcedZombieModel;
import com.modgen.luckylootblocks.client.renderer.ReinforcedZombieRenderer;
import com.modgen.luckylootblocks.client.model.ReinforcedSkeletonModel;
import com.modgen.luckylootblocks.client.renderer.ReinforcedSkeletonRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class LuckyLootBlocksClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("luckylootblocks/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Lucky Loot Blocks client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Lucky Loot Blocks client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.REINFORCED_ZOMBIE, ReinforcedZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.REINFORCED_SKELETON, ReinforcedSkeletonRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.REINFORCED_ZOMBIE, ReinforcedZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.REINFORCED_SKELETON, ReinforcedSkeletonModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}