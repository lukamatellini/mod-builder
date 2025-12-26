package com.modgen.shatteredconquest.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.shatteredconquest.ModEntities;
import com.modgen.shatteredconquest.client.ModModelLayers;
import com.modgen.shatteredconquest.client.model.ShadowLordModel;
import com.modgen.shatteredconquest.client.renderer.ShadowLordRenderer;
import com.modgen.shatteredconquest.client.model.CrystalGolemModel;
import com.modgen.shatteredconquest.client.renderer.CrystalGolemRenderer;
import com.modgen.shatteredconquest.client.model.VoidSerpentModel;
import com.modgen.shatteredconquest.client.renderer.VoidSerpentRenderer;
import com.modgen.shatteredconquest.client.model.ShadowMinionModel;
import com.modgen.shatteredconquest.client.renderer.ShadowMinionRenderer;
import com.modgen.shatteredconquest.client.model.VoidWalkerModel;
import com.modgen.shatteredconquest.client.renderer.VoidWalkerRenderer;
import com.modgen.shatteredconquest.client.model.VoidSerpentHatchlingModel;
import com.modgen.shatteredconquest.client.renderer.VoidSerpentHatchlingRenderer;
import com.modgen.shatteredconquest.client.model.NPCModel;
import com.modgen.shatteredconquest.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class ShatteredConquestClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("shatteredconquest/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Shattered Conquest client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Shattered Conquest client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.SHADOW_LORD, ShadowLordRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_SERPENT, VoidSerpentRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_MINION, ShadowMinionRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_WALKER, VoidWalkerRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_SERPENT_HATCHLING, VoidSerpentHatchlingRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_LORD, ShadowLordModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_SERPENT, VoidSerpentModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_MINION, ShadowMinionModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_WALKER, VoidWalkerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_SERPENT_HATCHLING, VoidSerpentHatchlingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}