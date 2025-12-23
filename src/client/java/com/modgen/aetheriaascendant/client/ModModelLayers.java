package com.modgen.aetheriaascendant.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

/**
 * Registry for all entity model layers
 * Each entity needs a unique layer for its model
 */
@Environment(EnvType.CLIENT)
public class ModModelLayers {
    public static final EntityModelLayer AETHER_GOLEM = new EntityModelLayer(Identifier.of("aetheriaascendant", "aether_golem"), "main");
    public static final EntityModelLayer CLOUD_SERPENT = new EntityModelLayer(Identifier.of("aetheriaascendant", "cloud_serpent"), "main");
    public static final EntityModelLayer CELESTIAL_GUARDIAN = new EntityModelLayer(Identifier.of("aetheriaascendant", "celestial_guardian"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("aetheriaascendant", "npc"), "main");
}