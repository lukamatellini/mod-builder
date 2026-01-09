package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.AncientDragonModel;
import com.modgen.gemstoneodyssey.entity.AncientDragonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Ancient Dragon
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class AncientDragonRenderer extends MobEntityRenderer<AncientDragonEntity, AncientDragonModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/ancient_dragon.png");
    
    public AncientDragonRenderer(EntityRendererFactory.Context context) {
        super(context, new AncientDragonModel(context.getPart(ModModelLayers.ANCIENT_DRAGON)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(AncientDragonEntity entity) {
        return TEXTURE;
    }

}