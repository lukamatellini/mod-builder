package com.modgen.dragonsheir.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.dragonsheir.entity.ModEntities;
import com.modgen.dragonsheir.client.ModModelLayers;
import com.modgen.dragonsheir.client.model.FrostElementalModel;
import com.modgen.dragonsheir.client.renderer.FrostElementalRenderer;
import com.modgen.dragonsheir.client.model.ShadowWolfModel;
import com.modgen.dragonsheir.client.renderer.ShadowWolfRenderer;
import com.modgen.dragonsheir.client.model.CrystalGolemModel;
import com.modgen.dragonsheir.client.renderer.CrystalGolemRenderer;
import com.modgen.dragonsheir.client.model.AncientDragonBossModel;
import com.modgen.dragonsheir.client.renderer.AncientDragonBossRenderer;
import com.modgen.dragonsheir.client.model.DragonlingModel;
import com.modgen.dragonsheir.client.renderer.DragonlingRenderer;
import com.modgen.dragonsheir.client.model.FireElementalModel;
import com.modgen.dragonsheir.client.renderer.FireElementalRenderer;
import com.modgen.dragonsheir.client.model.ScorpionModel;
import com.modgen.dragonsheir.client.renderer.ScorpionRenderer;
import com.modgen.dragonsheir.client.model.UnicornModel;
import com.modgen.dragonsheir.client.renderer.UnicornRenderer;
import com.modgen.dragonsheir.client.model.NPCModel;
import com.modgen.dragonsheir.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here including entity renderers
 */
@Environment(EnvType.CLIENT)
public class DragonsHeirClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("dragonsheir/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Dragons Heir client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        LOGGER.info("Dragons Heir client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.FROST_ELEMENTAL, FrostElementalRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WOLF, ShadowWolfRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.ANCIENT_DRAGON_BOSS, AncientDragonBossRenderer::new);
        EntityRendererRegistry.register(ModEntities.DRAGONLING, DragonlingRenderer::new);
        EntityRendererRegistry.register(ModEntities.FIRE_ELEMENTAL, FireElementalRenderer::new);
        EntityRendererRegistry.register(ModEntities.SCORPION, ScorpionRenderer::new);
        EntityRendererRegistry.register(ModEntities.UNICORN, UnicornRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FROST_ELEMENTAL, FrostElementalModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_WOLF, ShadowWolfModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ANCIENT_DRAGON_BOSS, AncientDragonBossModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.DRAGONLING, DragonlingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.FIRE_ELEMENTAL, FireElementalModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SCORPION, ScorpionModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.UNICORN, UnicornModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}