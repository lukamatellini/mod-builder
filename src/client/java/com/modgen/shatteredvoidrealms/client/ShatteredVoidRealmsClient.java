package com.modgen.shatteredvoidrealms.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.shatteredvoidrealms.ModEntities;
import com.modgen.shatteredvoidrealms.client.ModModelLayers;
import com.modgen.shatteredvoidrealms.client.model.VoidWalkerModel;
import com.modgen.shatteredvoidrealms.client.renderer.VoidWalkerRenderer;
import com.modgen.shatteredvoidrealms.client.model.CrystalGolemModel;
import com.modgen.shatteredvoidrealms.client.renderer.CrystalGolemRenderer;
import com.modgen.shatteredvoidrealms.client.model.ShadowWraithModel;
import com.modgen.shatteredvoidrealms.client.renderer.ShadowWraithRenderer;
import com.modgen.shatteredvoidrealms.client.model.VoidTitanModel;
import com.modgen.shatteredvoidrealms.client.renderer.VoidTitanRenderer;
import com.modgen.shatteredvoidrealms.client.model.CrystalEmpressModel;
import com.modgen.shatteredvoidrealms.client.renderer.CrystalEmpressRenderer;
import com.modgen.shatteredvoidrealms.client.model.NPCModel;
import com.modgen.shatteredvoidrealms.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class ShatteredVoidRealmsClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("shatteredvoidrealms/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Shattered Void Realms client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Shattered Void Realms client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.VOID_WALKER, VoidWalkerRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WRAITH, ShadowWraithRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_TITAN, VoidTitanRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_EMPRESS, CrystalEmpressRenderer::new);
        EntityRendererRegistry.register(ModEntities.MODGEN_NPC, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_WALKER, VoidWalkerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_WRAITH, ShadowWraithModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_TITAN, VoidTitanModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_EMPRESS, CrystalEmpressModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}