package com.modgen.dragonsheir.client;

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
    public static final EntityModelLayer FROST_ELEMENTAL = new EntityModelLayer(Identifier.of("dragonsheir", "frost_elemental"), "main");
    public static final EntityModelLayer SHADOW_WOLF = new EntityModelLayer(Identifier.of("dragonsheir", "shadow_wolf"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("dragonsheir", "crystal_golem"), "main");
    public static final EntityModelLayer ANCIENT_DRAGON_BOSS = new EntityModelLayer(Identifier.of("dragonsheir", "ancient_dragon_boss"), "main");
    public static final EntityModelLayer DRAGONLING = new EntityModelLayer(Identifier.of("dragonsheir", "dragonling"), "main");
    public static final EntityModelLayer FIRE_ELEMENTAL = new EntityModelLayer(Identifier.of("dragonsheir", "fire_elemental"), "main");
    public static final EntityModelLayer SCORPION = new EntityModelLayer(Identifier.of("dragonsheir", "scorpion"), "main");
    public static final EntityModelLayer UNICORN = new EntityModelLayer(Identifier.of("dragonsheir", "unicorn"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("dragonsheir", "npc"), "main");
}