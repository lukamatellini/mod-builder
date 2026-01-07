package com.modgen.luckybreaks.client;

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
    public static final EntityModelLayer ZOMBIE_IRON_ARMOR = new EntityModelLayer(Identifier.of("luckybreaks", "zombie_iron_armor"), "main");
    public static final EntityModelLayer SKELETON_ENCHANTED_BOW = new EntityModelLayer(Identifier.of("luckybreaks", "skeleton_enchanted_bow"), "main");
    public static final EntityModelLayer SPIDER_SKELETON_RIDER = new EntityModelLayer(Identifier.of("luckybreaks", "spider_skeleton_rider"), "main");
    public static final EntityModelLayer SPIDER_WITHER_SKELETON_RIDER = new EntityModelLayer(Identifier.of("luckybreaks", "spider_wither_skeleton_rider"), "main");
}