package com.modgen.shatteredascent.client;

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
    public static final EntityModelLayer VOID_WALKER = new EntityModelLayer(Identifier.of("shatteredascent", "void_walker"), "main");
    public static final EntityModelLayer CRYSTAL_GOLEM = new EntityModelLayer(Identifier.of("shatteredascent", "crystal_golem"), "main");
    public static final EntityModelLayer SHADOW_WRAITH = new EntityModelLayer(Identifier.of("shatteredascent", "shadow_wraith"), "main");
    public static final EntityModelLayer THE_VOID_TITAN = new EntityModelLayer(Identifier.of("shatteredascent", "the_void_titan"), "main");
    public static final EntityModelLayer CRYSTAL_EMPRESS = new EntityModelLayer(Identifier.of("shatteredascent", "crystal_empress"), "main");
    public static final EntityModelLayer NPC = new EntityModelLayer(Identifier.of("shatteredascent", "npc"), "main");
}