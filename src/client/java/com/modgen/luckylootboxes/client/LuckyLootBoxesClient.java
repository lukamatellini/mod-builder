package com.modgen.luckylootboxes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.luckylootboxes.entity.ModEntities;
import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.ZombieModel;
import com.modgen.luckylootboxes.client.renderer.ZombieRenderer;
import com.modgen.luckylootboxes.client.model.SkeletonModel;
import com.modgen.luckylootboxes.client.renderer.SkeletonRenderer;
import com.modgen.luckylootboxes.client.model.CreeperModel;
import com.modgen.luckylootboxes.client.renderer.CreeperRenderer;
import com.modgen.luckylootboxes.client.model.EndermanModel;
import com.modgen.luckylootboxes.client.renderer.EndermanRenderer;
import com.modgen.luckylootboxes.client.model.VexModel;
import com.modgen.luckylootboxes.client.renderer.VexRenderer;
import com.modgen.luckylootboxes.client.model.EvokerModel;
import com.modgen.luckylootboxes.client.renderer.EvokerRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class LuckyLootBoxesClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("luckylootboxes/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Lucky Loot Boxes client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Lucky Loot Boxes client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.ZOMBIE, ZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKELETON, SkeletonRenderer::new);
        EntityRendererRegistry.register(ModEntities.CREEPER, CreeperRenderer::new);
        EntityRendererRegistry.register(ModEntities.ENDERMAN, EndermanRenderer::new);
        EntityRendererRegistry.register(ModEntities.VEX, VexRenderer::new);
        EntityRendererRegistry.register(ModEntities.EVOKER, EvokerRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ZOMBIE, ZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SKELETON, SkeletonModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CREEPER, CreeperModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ENDERMAN, EndermanModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VEX, VexModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.EVOKER, EvokerModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}