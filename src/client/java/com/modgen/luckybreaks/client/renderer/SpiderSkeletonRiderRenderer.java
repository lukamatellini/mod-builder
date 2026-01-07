package com.modgen.luckybreaks.client.renderer;

import com.modgen.luckybreaks.client.ModModelLayers;
import com.modgen.luckybreaks.client.model.SpiderSkeletonRiderModel;
import com.modgen.luckybreaks.entity.SpiderSkeletonRiderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Spider (Skeleton Rider)
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class SpiderSkeletonRiderRenderer extends MobEntityRenderer<SpiderSkeletonRiderEntity, SpiderSkeletonRiderModel> {
    private static final Identifier TEXTURE = Identifier.of("luckybreaks", "textures/entity/spider_skeleton_rider.png");
    
    public SpiderSkeletonRiderRenderer(EntityRendererFactory.Context context) {
        super(context, new SpiderSkeletonRiderModel(context.getPart(ModModelLayers.SPIDER_SKELETON_RIDER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(SpiderSkeletonRiderEntity entity) {
        return TEXTURE;
    }

}