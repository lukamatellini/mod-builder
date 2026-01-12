package com.modgen.cheesycraft.client;

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
    public static final EntityModelLayer MOUSE = new EntityModelLayer(Identifier.of("cheesycraft", "mouse"), "main");
    public static final EntityModelLayer RAT = new EntityModelLayer(Identifier.of("cheesycraft", "rat"), "main");
    public static final EntityModelLayer CHEESY_GOLEM = new EntityModelLayer(Identifier.of("cheesycraft", "cheesy_golem"), "main");
}