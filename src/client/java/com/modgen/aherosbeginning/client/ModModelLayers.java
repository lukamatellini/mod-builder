package com.modgen.aherosbeginning.client;

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
    public static final EntityModelLayer VOID_WISP = new EntityModelLayer(Identifier.of("aherosbeginning", "void_wisp"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("aherosbeginning", "crystal_golem"), "main");
    public static final EntityModelLayer CRYSTAL_GUARDIAN = new EntityModelLayer(Identifier.of("aherosbeginning", "crystal_guardian"), "main");
    public static final EntityModelLayer VOID_OVERLORD = new EntityModelLayer(Identifier.of("aherosbeginning", "void_overlord"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("aherosbeginning", "npc"), "main");
}