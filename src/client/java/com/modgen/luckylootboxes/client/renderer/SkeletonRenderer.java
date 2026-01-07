package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.SkeletonModel;
import com.modgen.luckylootboxes.entity.SkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Skeleton
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class SkeletonRenderer extends MobEntityRenderer<SkeletonEntity, SkeletonModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/skeleton.png");
    
    public SkeletonRenderer(EntityRendererFactory.Context context) {
        super(context, new SkeletonModel(context.getPart(ModModelLayers.SKELETON)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(SkeletonEntity entity) {
        return TEXTURE;
    }

}