package com.modgen.gemstoneodyssey.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.gemstoneodyssey.entity.ModEntities;
import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.GloomyGhoulModel;
import com.modgen.gemstoneodyssey.client.renderer.GloomyGhoulRenderer;
import com.modgen.gemstoneodyssey.client.model.IceElementalModel;
import com.modgen.gemstoneodyssey.client.renderer.IceElementalRenderer;
import com.modgen.gemstoneodyssey.client.model.BlazeElementalModel;
import com.modgen.gemstoneodyssey.client.renderer.BlazeElementalRenderer;
import com.modgen.gemstoneodyssey.client.model.VoidfishModel;
import com.modgen.gemstoneodyssey.client.renderer.VoidfishRenderer;
import com.modgen.gemstoneodyssey.client.model.SkyGolemModel;
import com.modgen.gemstoneodyssey.client.renderer.SkyGolemRenderer;
import com.modgen.gemstoneodyssey.client.model.IgnisTheAncientDragonModel;
import com.modgen.gemstoneodyssey.client.renderer.IgnisTheAncientDragonRenderer;
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
        EntityRendererRegistry.register(ModEntities.GLOOMY_GHOUL, GloomyGhoulRenderer::new);
        EntityRendererRegistry.register(ModEntities.ICE_ELEMENTAL, IceElementalRenderer::new);
        EntityRendererRegistry.register(ModEntities.BLAZE_ELEMENTAL, BlazeElementalRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOIDFISH, VoidfishRenderer::new);
        EntityRendererRegistry.register(ModEntities.SKY_GOLEM, SkyGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.IGNIS_THE_ANCIENT_DRAGON, IgnisTheAncientDragonRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.GLOOMY_GHOUL, GloomyGhoulModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ICE_ELEMENTAL, IceElementalModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BLAZE_ELEMENTAL, BlazeElementalModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOIDFISH, VoidfishModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SKY_GOLEM, SkyGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.IGNIS_THE_ANCIENT_DRAGON, IgnisTheAncientDragonModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}