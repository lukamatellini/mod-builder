package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.FrostElementalModel;
import com.modgen.gemstoneodyssey.entity.FrostElementalEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Frost Elemental
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class FrostElementalRenderer extends MobEntityRenderer<FrostElementalEntity, FrostElementalModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/frost_elemental.png");
    
    public FrostElementalRenderer(EntityRendererFactory.Context context) {
        super(context, new FrostElementalModel(context.getPart(ModModelLayers.FROST_ELEMENTAL)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(FrostElementalEntity entity) {
        return TEXTURE;
    }

}