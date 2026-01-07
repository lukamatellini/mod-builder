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
    public static final EntityModelLayer LUCKY_ZOMBIE = new EntityModelLayer(Identifier.of("luckylootblocks", "lucky_zombie"), "main");
    public static final EntityModelLayer LUCKY_SPIDER = new EntityModelLayer(Identifier.of("luckylootblocks", "lucky_spider"), "main");
    public static final EntityModelLayer LUCKY_CREEPER = new EntityModelLayer(Identifier.of("luckylootblocks", "lucky_creeper"), "main");
    public static final EntityModelLayer LUCKY_CAVE_SPIDER = new EntityModelLayer(Identifier.of("luckylootblocks", "lucky_cave_spider"), "main");
}