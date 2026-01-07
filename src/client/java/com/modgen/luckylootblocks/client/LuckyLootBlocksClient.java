package com.modgen.luckylootblocks.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.luckylootblocks.ModEntities;
import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.LuckyZombieModel;
import com.modgen.luckylootblocks.client.renderer.LuckyZombieRenderer;
import com.modgen.luckylootblocks.client.model.LuckySpiderModel;
import com.modgen.luckylootblocks.client.renderer.LuckySpiderRenderer;
import com.modgen.luckylootblocks.client.model.LuckyCreeperModel;
import com.modgen.luckylootblocks.client.renderer.LuckyCreeperRenderer;
import com.modgen.luckylootblocks.client.model.LuckyCaveSpiderModel;
import com.modgen.luckylootblocks.client.renderer.LuckyCaveSpiderRenderer;
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
        EntityRendererRegistry.register(ModEntities.LUCKY_ZOMBIE, LuckyZombieRenderer::new);
        EntityRendererRegistry.register(ModEntities.LUCKY_SPIDER, LuckySpiderRenderer::new);
        EntityRendererRegistry.register(ModEntities.LUCKY_CREEPER, LuckyCreeperRenderer::new);
        EntityRendererRegistry.register(ModEntities.LUCKY_CAVE_SPIDER, LuckyCaveSpiderRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LUCKY_ZOMBIE, LuckyZombieModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LUCKY_SPIDER, LuckySpiderModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LUCKY_CREEPER, LuckyCreeperModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LUCKY_CAVE_SPIDER, LuckyCaveSpiderModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}