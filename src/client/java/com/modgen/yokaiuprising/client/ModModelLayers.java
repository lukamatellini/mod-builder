package com.modgen.yokaiuprising.client;

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
    public static final EntityModelLayer MUTATED_ZOMBIE = new EntityModelLayer(Identifier.of("yokaiuprising", "mutated_zombie"), "main");
    public static final EntityModelLayer CAVE_WORM = new EntityModelLayer(Identifier.of("yokaiuprising", "cave_worm"), "main");
    public static final EntityModelLayer SUMO_WRESTLER = new EntityModelLayer(Identifier.of("yokaiuprising", "sumo_wrestler"), "main");
}