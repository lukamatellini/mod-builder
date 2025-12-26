package com.modgen.voidconquest.client;

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
    public static final EntityModelLayer SHADOW_LORD = new EntityModelLayer(Identifier.of("voidconquest", "shadow_lord"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("voidconquest", "crystal_golem"), "main");
    public static final EntityModelLayer VOID_SERPENT = new EntityModelLayer(Identifier.of("voidconquest", "void_serpent"), "main");
    public static final EntityModelLayer SHADOW_MINION = new EntityModelLayer(Identifier.of("voidconquest", "shadow_minion"), "main");
    public static final EntityModelLayer VOID_WALKER = new EntityModelLayer(Identifier.of("voidconquest", "void_walker"), "main");
    public static final EntityModelLayer VOID_SERPENT_HATCHLING = new EntityModelLayer(Identifier.of("voidconquest", "void_serpent_hatchling"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("voidconquest", "npc"), "main");
}