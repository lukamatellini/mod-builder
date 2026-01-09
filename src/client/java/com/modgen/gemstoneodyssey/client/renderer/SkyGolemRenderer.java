package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.SkyGolemModel;
import com.modgen.gemstoneodyssey.entity.SkyGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Sky Golem
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class SkyGolemRenderer extends MobEntityRenderer<SkyGolemEntity, SkyGolemModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/sky_golem.png");
    
    public SkyGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new SkyGolemModel(context.getPart(ModModelLayers.SKY_GOLEM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(SkyGolemEntity entity) {
        return TEXTURE;
    }

}