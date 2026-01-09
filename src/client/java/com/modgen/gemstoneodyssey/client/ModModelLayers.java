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
    public static final EntityModelLayer FROST_ELEMENTAL = new EntityModelLayer(Identifier.of("gemstoneodyssey", "frost_elemental"), "main");
    public static final EntityModelLayer SHADOW_WOLF = new EntityModelLayer(Identifier.of("gemstoneodyssey", "shadow_wolf"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("gemstoneodyssey", "crystal_golem"), "main");
    public static final EntityModelLayer ANCIENT_DRAGON = new EntityModelLayer(Identifier.of("gemstoneodyssey", "ancient_dragon"), "main");
    public static final EntityModelLayer FIRE_ELEMENTAL = new EntityModelLayer(Identifier.of("gemstoneodyssey", "fire_elemental"), "main");
    public static final EntityModelLayer UNICORN = new EntityModelLayer(Identifier.of("gemstoneodyssey", "unicorn"), "main");
    public static final EntityModelLayer PIRATE = new EntityModelLayer(Identifier.of("gemstoneodyssey", "pirate"), "main");
    public static final EntityModelLayer BENEVOLENT_FLOATING_CREATURE = new EntityModelLayer(Identifier.of("gemstoneodyssey", "benevolent_floating_creature"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("gemstoneodyssey", "npc"), "main");
}