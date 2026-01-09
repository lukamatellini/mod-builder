package com.modgen.gemstoneodyssey.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.gemstoneodyssey.entity.ModEntities;
import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.FrostElementalModel;
import com.modgen.gemstoneodyssey.client.renderer.FrostElementalRenderer;
import com.modgen.gemstoneodyssey.client.model.ShadowWolfModel;
import com.modgen.gemstoneodyssey.client.renderer.ShadowWolfRenderer;
import com.modgen.gemstoneodyssey.client.model.CrystalGolemModel;
import com.modgen.gemstoneodyssey.client.renderer.CrystalGolemRenderer;
import com.modgen.gemstoneodyssey.client.model.AncientDragonModel;
import com.modgen.gemstoneodyssey.client.renderer.AncientDragonRenderer;
import com.modgen.gemstoneodyssey.client.model.NPCModel;
import com.modgen.gemstoneodyssey.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class GemstoneOdysseyClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("gemstoneodyssey/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Gemstone Odyssey client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Gemstone Odyssey client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.FROST_ELEMENTAL, FrostElementalRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WOLF, ShadowWolfRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.ANCIENT_DRAGON, AncientDragonRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FROST_ELEMENTAL, FrostElementalModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_WOLF, ShadowWolfModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ANCIENT_DRAGON, AncientDragonModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}