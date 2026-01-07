package com.modgen.cheesyblade.client;

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
    public static final EntityModelLayer CHEESE_GOLEM = new EntityModelLayer(Identifier.of("cheesyblade", "cheese_golem"), "main");
    public static final EntityModelLayer HUNGRY_MOUSE = new EntityModelLayer(Identifier.of("cheesyblade", "hungry_mouse"), "main");
}