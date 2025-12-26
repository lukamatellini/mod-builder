package com.modgen.massiveadventure.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.massiveadventure.ModEntities;
import com.modgen.massiveadventure.client.ModModelLayers;
import com.modgen.massiveadventure.client.model.VoidWispModel;
import com.modgen.massiveadventure.client.renderer.VoidWispRenderer;
import com.modgen.massiveadventure.client.model.CrystalGolemModel;
import com.modgen.massiveadventure.client.renderer.CrystalGolemRenderer;
import com.modgen.massiveadventure.client.model.CrystalGuardianModel;
import com.modgen.massiveadventure.client.renderer.CrystalGuardianRenderer;
import com.modgen.massiveadventure.client.model.VoidOverlordModel;
import com.modgen.massiveadventure.client.renderer.VoidOverlordRenderer;
import com.modgen.massiveadventure.client.model.NPCModel;
import com.modgen.massiveadventure.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class MassiveAdventureClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("massiveadventure/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing massive adventure client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("massive adventure client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.VOID_WISP, VoidWispRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GUARDIAN, CrystalGuardianRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_OVERLORD, VoidOverlordRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_WISP, VoidWispModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GUARDIAN, CrystalGuardianModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_OVERLORD, VoidOverlordModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}