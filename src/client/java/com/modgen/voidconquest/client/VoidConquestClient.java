package com.modgen.voidconquest.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.voidconquest.ModEntities;
import com.modgen.voidconquest.client.ModModelLayers;
import com.modgen.voidconquest.client.model.ShadowLordModel;
import com.modgen.voidconquest.client.renderer.ShadowLordRenderer;
import com.modgen.voidconquest.client.model.CrystalGolemModel;
import com.modgen.voidconquest.client.renderer.CrystalGolemRenderer;
import com.modgen.voidconquest.client.model.VoidSerpentModel;
import com.modgen.voidconquest.client.renderer.VoidSerpentRenderer;
import com.modgen.voidconquest.client.model.ShadowMinionModel;
import com.modgen.voidconquest.client.renderer.ShadowMinionRenderer;
import com.modgen.voidconquest.client.model.VoidWalkerModel;
import com.modgen.voidconquest.client.renderer.VoidWalkerRenderer;
import com.modgen.voidconquest.client.model.VoidSerpentHatchlingModel;
import com.modgen.voidconquest.client.renderer.VoidSerpentHatchlingRenderer;
import com.modgen.voidconquest.client.model.NPCModel;
import com.modgen.voidconquest.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class VoidConquestClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("voidconquest/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Void Conquest client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Void Conquest client initialized");
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