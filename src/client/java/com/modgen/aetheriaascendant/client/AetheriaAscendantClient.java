package com.modgen.aetheriaascendant.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import com.modgen.aetheriaascendant.ModEntities;
import com.modgen.aetheriaascendant.client.ModModelLayers;
import com.modgen.aetheriaascendant.client.model.AetherGolemModel;
import com.modgen.aetheriaascendant.client.renderer.AetherGolemRenderer;
import com.modgen.aetheriaascendant.client.model.CloudSerpentModel;
import com.modgen.aetheriaascendant.client.renderer.CloudSerpentRenderer;
import com.modgen.aetheriaascendant.client.model.CelestialGuardianModel;
import com.modgen.aetheriaascendant.client.renderer.CelestialGuardianRenderer;
import com.modgen.aetheriaascendant.client.model.NPCModel;
import com.modgen.aetheriaascendant.client.renderer.NPCRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client entrypoint - MUST be in src/client/java
 * All client-only code lives here
 */
@Environment(EnvType.CLIENT)
public class AetheriaAscendantClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("aetheriaascendant/client");
    
    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing Aetheria Ascendant client...");
        
        // Register entity renderers
        registerEntityRenderers();
        
        // Register model layers
        registerModelLayers();
        
        // Register client-side networking
        ModClientNetworking.registerClientPackets();
        
        LOGGER.info("Aetheria Ascendant client initialized");
    }

    private void registerEntityRenderers() {
        LOGGER.info("Registering entity renderers...");
        EntityRendererRegistry.register(ModEntities.AETHER_GOLEM, AetherGolemRenderer::new);
        EntityRendererRegistry.register(ModEntities.CLOUD_SERPENT, CloudSerpentRenderer::new);
        EntityRendererRegistry.register(ModEntities.CELESTIAL_GUARDIAN, CelestialGuardianRenderer::new);
        EntityRendererRegistry.register(ModEntities.MODGEN_NPC, NPCRenderer::new);
        LOGGER.info("Entity renderers registered");
    }
    
    private void registerModelLayers() {
        LOGGER.info("Registering model layers...");
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.AETHER_GOLEM, AetherGolemModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CLOUD_SERPENT, CloudSerpentModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CELESTIAL_GUARDIAN, CelestialGuardianModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.NPC, NPCModel::getTexturedModelData);
        LOGGER.info("Model layers registered");
    }
}