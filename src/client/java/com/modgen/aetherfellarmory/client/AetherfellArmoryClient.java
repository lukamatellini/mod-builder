package com.modgen.aetherfellarmory.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.aetherfellarmory.entity.ModEntities;
import com.modgen.aetherfellarmory.client.ModModelLayers;
import com.modgen.aetherfellarmory.client.model.FrostElementalModel;
import com.modgen.aetherfellarmory.client.renderer.FrostElementalRenderer;
import com.modgen.aetherfellarmory.client.model.ShadowWolfModel;
import com.modgen.aetherfellarmory.client.renderer.ShadowWolfRenderer;
import com.modgen.aetherfellarmory.client.model.CrystalGolemModel;
import com.modgen.aetherfellarmory.client.renderer.CrystalGolemRenderer;
import com.modgen.aetherfellarmory.client.model.AncientDragonBossModel;
import com.modgen.aetherfellarmory.client.renderer.AncientDragonBossRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class AetherfellArmoryClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("aetherfellarmory/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Aetherfell Armory client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Aetherfell Armory client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.FROST_ELEMENTAL, FrostElementalRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WOLF, ShadowWolfRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.ANCIENT_DRAGON_BOSS, AncientDragonBossRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FROST_ELEMENTAL, FrostElementalModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_WOLF, ShadowWolfModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ANCIENT_DRAGON_BOSS, AncientDragonBossModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}