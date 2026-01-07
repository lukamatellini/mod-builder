package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.EvokerModel;
import com.modgen.luckylootboxes.entity.EvokerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Evoker
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class EvokerRenderer extends MobEntityRenderer<EvokerEntity, EvokerModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/evoker.png");
    
    public EvokerRenderer(EntityRendererFactory.Context context) {
        super(context, new EvokerModel(context.getPart(ModModelLayers.EVOKER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(EvokerEntity entity) {
        return TEXTURE;
    }

}