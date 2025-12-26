package com.modgen.epicadventure.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.epicadventure.ModEntities;
import com.modgen.epicadventure.client.ModModelLayers;
import com.modgen.epicadventure.client.model.VoidCrawlerModel;
import com.modgen.epicadventure.client.renderer.VoidCrawlerRenderer;
import com.modgen.epicadventure.client.model.ShadowWraithModel;
import com.modgen.epicadventure.client.renderer.ShadowWraithRenderer;
import com.modgen.epicadventure.client.model.CrystalGolemModel;
import com.modgen.epicadventure.client.renderer.CrystalGolemRenderer;
import com.modgen.epicadventure.client.model.AbyssalLurkerModel;
import com.modgen.epicadventure.client.renderer.AbyssalLurkerRenderer;
import com.modgen.epicadventure.client.model.CorruptedVillagerModel;
import com.modgen.epicadventure.client.renderer.CorruptedVillagerRenderer;
import com.modgen.epicadventure.client.model.TheVoidKingModel;
import com.modgen.epicadventure.client.renderer.TheVoidKingRenderer;
import com.modgen.epicadventure.client.model.NPCModel;
import com.modgen.epicadventure.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class EpicAdventureClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("epicadventure/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing epic adventure client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("epic adventure client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.VOID_CRAWLER, VoidCrawlerRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WRAITH, ShadowWraithRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSSAL_LURKER, AbyssalLurkerRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORRUPTED_VILLAGER, CorruptedVillagerRenderer::new);
        EntityRendererRegistry.register(ModEntities.THE_VOID_KING, TheVoidKingRenderer::new);
        EntityRendererRegistry.register(ModEntities.NPC_ENTITY_TYPE, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_CRAWLER, VoidCrawlerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_WRAITH, ShadowWraithModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CRYSTAL_GOLEM, CrystalGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ABYSSAL_LURKER, AbyssalLurkerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CORRUPTED_VILLAGER, CorruptedVillagerModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.THE_VOID_KING, TheVoidKingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}