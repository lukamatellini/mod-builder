package com.modgen.shatteredrealms.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.shatteredrealms.ModEntities;
import com.modgen.shatteredrealms.client.ModModelLayers;
import com.modgen.shatteredrealms.client.model.VoidWalkerModel;
import com.modgen.shatteredrealms.client.renderer.VoidWalkerRenderer;
import com.modgen.shatteredrealms.client.model.CrystalGolemModel;
import com.modgen.shatteredrealms.client.renderer.CrystalGolemRenderer;
import com.modgen.shatteredrealms.client.model.ShadowWraithModel;
import com.modgen.shatteredrealms.client.renderer.ShadowWraithRenderer;
import com.modgen.shatteredrealms.client.model.VoidTitanModel;
import com.modgen.shatteredrealms.client.renderer.VoidTitanRenderer;
import com.modgen.shatteredrealms.client.model.CrystalEmpressModel;
import com.modgen.shatteredrealms.client.renderer.CrystalEmpressRenderer;
import com.modgen.shatteredrealms.client.model.NPCModel;
import com.modgen.shatteredrealms.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class ShatteredRealmsClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("shatteredrealms/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Shattered Realms client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Shattered Realms client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.VOID_WALKER, VoidWalkerRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WRAITH, ShadowWraithRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_TITAN, VoidTitanRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_EMPRESS, CrystalEmpressRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
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