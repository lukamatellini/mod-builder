package com.modgen.luckybreaks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.luckybreaks.ModEntities;
import com.modgen.luckybreaks.client.ModModelLayers;
import com.modgen.luckybreaks.client.model.ZombieIronArmorModel;
import com.modgen.luckybreaks.client.renderer.ZombieIronArmorRenderer;
import com.modgen.luckybreaks.client.model.SkeletonEnchantedBowModel;
import com.modgen.luckybreaks.client.renderer.SkeletonEnchantedBowRenderer;
import com.modgen.luckybreaks.client.model.SpiderSkeletonRiderModel;
import com.modgen.luckybreaks.client.renderer.SpiderSkeletonRiderRenderer;
import com.modgen.luckybreaks.client.model.SpiderWitherSkeletonRiderModel;
import com.modgen.luckybreaks.client.renderer.SpiderWitherSkeletonRiderRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class LuckyBreaksClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("luckybreaks/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Lucky Breaks client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Lucky Breaks client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.ZOMBIE_IRON_ARMOR, ZombieIronArmorRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKELETON_ENCHANTED_BOW, SkeletonEnchantedBowRenderer::new);
        EntityRendererRegistry.register(ModEntities.SPIDER_SKELETON_RIDER, SpiderSkeletonRiderRenderer::new);
        EntityRendererRegistry.register(ModEntities.SPIDER_WITHER_SKELETON_RIDER, SpiderWitherSkeletonRiderRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ZOMBIE_IRON_ARMOR, ZombieIronArmorModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SKELETON_ENCHANTED_BOW, SkeletonEnchantedBowModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPIDER_SKELETON_RIDER, SpiderSkeletonRiderModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SPIDER_WITHER_SKELETON_RIDER, SpiderWitherSkeletonRiderModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}