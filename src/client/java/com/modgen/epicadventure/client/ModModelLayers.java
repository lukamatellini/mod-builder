package com.modgen.epicadventure.client;

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
    public static final EntityModelLayer VOID_CRAWLER = new EntityModelLayer(Identifier.of("epicadventure", "void_crawler"), "main");
    public static final EntityModelLayer SHADOW_WRAITH = new EntityModelLayer(Identifier.of("epicadventure", "shadow_wraith"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("epicadventure", "crystal_golem"), "main");
    public static final EntityModelLayer ABYSSAL_LURKER = new EntityModelLayer(Identifier.of("epicadventure", "abyssal_lurker"), "main");
    public static final EntityModelLayer CORRUPTED_VILLAGER = new EntityModelLayer(Identifier.of("epicadventure", "corrupted_villager"), "main");
    public static final EntityModelLayer THE_VOID_KING = new EntityModelLayer(Identifier.of("epicadventure", "the_void_king"), "main");
    public static final EntityModelLayer VOID_COMMANDER = new EntityModelLayer(Identifier.of("epicadventure", "void_commander"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("epicadventure", "npc"), "main");
}