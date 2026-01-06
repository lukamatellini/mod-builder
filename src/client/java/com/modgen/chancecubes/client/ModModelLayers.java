package com.modgen.chancecubes.client;

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
    public static final EntityModelLayer LUCKY_GOBLIN = new EntityModelLayer(Identifier.of("chancecubes", "lucky_goblin"), "main");
    public static final EntityModelLayer UNLUCKY_ZOMBIE = new EntityModelLayer(Identifier.of("chancecubes", "unlucky_zombie"), "main");
}