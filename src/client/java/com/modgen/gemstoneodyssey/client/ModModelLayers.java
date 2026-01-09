package com.modgen.gemstoneodyssey.client;

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
    public static final EntityModelLayer GLOOMY_GHOUL = new EntityModelLayer(Identifier.of("gemstoneodyssey", "gloomy_ghoul"), "main");
    public static final EntityModelLayer ICE_ELEMENTAL = new EntityModelLayer(Identifier.of("gemstoneodyssey", "ice_elemental"), "main");
    public static final EntityModelLayer BLAZE_ELEMENTAL = new EntityModelLayer(Identifier.of("gemstoneodyssey", "blaze_elemental"), "main");
    public static final EntityModelLayer VOIDFISH = new EntityModelLayer(Identifier.of("gemstoneodyssey", "voidfish"), "main");
    public static final EntityModelLayer SKY_GOLEM = new EntityModelLayer(Identifier.of("gemstoneodyssey", "sky_golem"), "main");
    public static final EntityModelLayer IGNIS_THE_ANCIENT_DRAGON = new EntityModelLayer(Identifier.of("gemstoneodyssey", "ignis_the_ancient_dragon"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("gemstoneodyssey", "npc"), "main");
}