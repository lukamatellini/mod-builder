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
    public static final EntityModelLayer LUCKY_GOBLIN = new EntityModelLayer(Identifier.of("luckylootboxes", "lucky_goblin"), "main");
    public static final EntityModelLayer CURSED_SPIRIT = new EntityModelLayer(Identifier.of("luckylootboxes", "cursed_spirit"), "main");
}