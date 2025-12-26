package com.modgen.abyssalascent.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.abyssalascent.ModEntities;
import com.modgen.abyssalascent.client.ModModelLayers;
import com.modgen.abyssalascent.client.model.VoidCrawlerModel;
import com.modgen.abyssalascent.client.renderer.VoidCrawlerRenderer;
import com.modgen.abyssalascent.client.model.ShadowWraithModel;
import com.modgen.abyssalascent.client.renderer.ShadowWraithRenderer;
import com.modgen.abyssalascent.client.model.CrystalGolemModel;
import com.modgen.abyssalascent.client.renderer.CrystalGolemRenderer;
import com.modgen.abyssalascent.client.model.AbyssalLurkerModel;
import com.modgen.abyssalascent.client.renderer.AbyssalLurkerRenderer;
import com.modgen.abyssalascent.client.model.CorruptedVillagerModel;
import com.modgen.abyssalascent.client.renderer.CorruptedVillagerRenderer;
import com.modgen.abyssalascent.client.model.VoidKingModel;
import com.modgen.abyssalascent.client.renderer.VoidKingRenderer;
import com.modgen.abyssalascent.client.model.VoidCommanderModel;
import com.modgen.abyssalascent.client.renderer.VoidCommanderRenderer;
import com.modgen.abyssalascent.client.model.NPCModel;
import com.modgen.abyssalascent.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class AbyssalAscentClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("abyssalascent/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Abyssal Ascent client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Abyssal Ascent client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.VOID_CRAWLER, VoidCrawlerRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHADOW_WRAITH, ShadowWraithRenderer::new);
        EntityRendererRegistry.register(ModEntities.CRYSTAL_GOLEM, CrystalGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.ABYSSAL_LURKER, AbyssalLurkerRenderer::new);
        EntityRendererRegistry.register(ModEntities.CORRUPTED_VILLAGER, CorruptedVillagerRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_KING, VoidKingRenderer::new);
        EntityRendererRegistry.register(ModEntities.VOID_COMMANDER, VoidCommanderRenderer::new);
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
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_KING, VoidKingModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VOID_COMMANDER, VoidCommanderModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}