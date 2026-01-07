package com.modgen.luckylootboxes.client;

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
    public static final EntityModelLayer ZOMBIE = new EntityModelLayer(Identifier.of("luckylootboxes", "zombie"), "main");
    public static final EntityModelLayer SKELETON = new EntityModelLayer(Identifier.of("luckylootboxes", "skeleton"), "main");
    public static final EntityModelLayer CREEPER = new EntityModelLayer(Identifier.of("luckylootboxes", "creeper"), "main");
    public static final EntityModelLayer ENDERMAN = new EntityModelLayer(Identifier.of("luckylootboxes", "enderman"), "main");
    public static final EntityModelLayer VEX = new EntityModelLayer(Identifier.of("luckylootboxes", "vex"), "main");
    public static final EntityModelLayer EVOKER = new EntityModelLayer(Identifier.of("luckylootboxes", "evoker"), "main");
}