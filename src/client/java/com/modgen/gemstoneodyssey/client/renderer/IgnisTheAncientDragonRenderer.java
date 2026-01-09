package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.IgnisTheAncientDragonModel;
import com.modgen.gemstoneodyssey.entity.IgnisTheAncientDragonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Ignis, the Ancient Dragon
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class IgnisTheAncientDragonRenderer extends MobEntityRenderer<IgnisTheAncientDragonEntity, IgnisTheAncientDragonModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/ignis_the_ancient_dragon.png");
    
    public IgnisTheAncientDragonRenderer(EntityRendererFactory.Context context) {
        super(context, new IgnisTheAncientDragonModel(context.getPart(ModModelLayers.IGNIS_THE_ANCIENT_DRAGON)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(IgnisTheAncientDragonEntity entity) {
        return TEXTURE;
    }

}