package com.modgen.luckylootboxes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.luckylootboxes.entity.ModEntities;
import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.LuckyGoblinModel;
import com.modgen.luckylootboxes.client.renderer.LuckyGoblinRenderer;
import com.modgen.luckylootboxes.client.model.CursedSpiritModel;
import com.modgen.luckylootboxes.client.renderer.CursedSpiritRenderer;
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
        EntityRendererRegistry.register(ModEntities.LUCKY_GOBLIN, LuckyGoblinRenderer::new);
        EntityRendererRegistry.register(ModEntities.CURSED_SPIRIT, CursedSpiritRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LUCKY_GOBLIN, LuckyGoblinModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CURSED_SPIRIT, CursedSpiritModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}