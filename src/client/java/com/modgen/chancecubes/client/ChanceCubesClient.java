package com.modgen.chancecubes.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.chancecubes.ModEntities;
import com.modgen.chancecubes.client.ModModelLayers;
import com.modgen.chancecubes.client.model.LuckyGoblinModel;
import com.modgen.chancecubes.client.renderer.LuckyGoblinRenderer;
import com.modgen.chancecubes.client.model.UnluckyZombieModel;
import com.modgen.chancecubes.client.renderer.UnluckyZombieRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class ChanceCubesClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("chancecubes/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Chance Cubes client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        // No keybinds to register
        
        // Register HUD overlay (quest progress, mana bar, status effects)
        ModHudOverlay.register();
        
        LOGGER.info("Chance Cubes client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.LUCKY_GOBLIN, LuckyGoblinRenderer::new);
        EntityRendererRegistry.register(ModEntities.UNLUCKY_ZOMBIE, UnluckyZombieRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.LUCKY_GOBLIN, LuckyGoblinModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.UNLUCKY_ZOMBIE, UnluckyZombieModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}