package com.modgen.sumoundeadworms.client;

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
    public static final EntityModelLayer YOKAI_ZOMBIE = new EntityModelLayer(Identifier.of("sumoundeadworms", "yokai_zombie"), "main");
    public static final EntityModelLayer BURROWING_WORM = new EntityModelLayer(Identifier.of("sumoundeadworms", "burrowing_worm"), "main");
    public static final EntityModelLayer JAPANESE_SUMO_WRESTLER = new EntityModelLayer(Identifier.of("sumoundeadworms", "japanese_sumo_wrestler"), "main");
}