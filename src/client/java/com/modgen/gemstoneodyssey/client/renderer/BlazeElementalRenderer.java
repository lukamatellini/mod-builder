package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.BlazeElementalModel;
import com.modgen.gemstoneodyssey.entity.BlazeElementalEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Blaze Elemental
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class BlazeElementalRenderer extends MobEntityRenderer<BlazeElementalEntity, BlazeElementalModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/blaze_elemental.png");
    
    public BlazeElementalRenderer(EntityRendererFactory.Context context) {
        super(context, new BlazeElementalModel(context.getPart(ModModelLayers.BLAZE_ELEMENTAL)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(BlazeElementalEntity entity) {
        return TEXTURE;
    }

}