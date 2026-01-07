package com.modgen.luckylootblocks.client;

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
    public static final EntityModelLayer REINFORCED_ZOMBIE = new EntityModelLayer(Identifier.of("luckylootblocks", "reinforced_zombie"), "main");
    public static final EntityModelLayer REINFORCED_SKELETON = new EntityModelLayer(Identifier.of("luckylootblocks", "reinforced_skeleton"), "main");
}