package com.modgen.aetherfellarmory.client;

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
    public static final EntityModelLayer FROST_ELEMENTAL = new EntityModelLayer(Identifier.of("aetherfellarmory", "frost_elemental"), "main");
    public static final EntityModelLayer SHADOW_WOLF = new EntityModelLayer(Identifier.of("aetherfellarmory", "shadow_wolf"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("aetherfellarmory", "crystal_golem"), "main");
    public static final EntityModelLayer ANCIENT_DRAGON_BOSS = new EntityModelLayer(Identifier.of("aetherfellarmory", "ancient_dragon_boss"), "main");
}