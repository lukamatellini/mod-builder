package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.IceElementalModel;
import com.modgen.gemstoneodyssey.entity.IceElementalEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Ice Elemental
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class IceElementalRenderer extends MobEntityRenderer<IceElementalEntity, IceElementalModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/ice_elemental.png");
    
    public IceElementalRenderer(EntityRendererFactory.Context context) {
        super(context, new IceElementalModel(context.getPart(ModModelLayers.ICE_ELEMENTAL)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(IceElementalEntity entity) {
        return TEXTURE;
    }

}