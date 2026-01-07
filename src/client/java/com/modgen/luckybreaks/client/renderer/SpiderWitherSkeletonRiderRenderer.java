package com.modgen.luckybreaks.client.renderer;

import com.modgen.luckybreaks.client.ModModelLayers;
import com.modgen.luckybreaks.client.model.SpiderWitherSkeletonRiderModel;
import com.modgen.luckybreaks.entity.SpiderWitherSkeletonRiderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Spider (Wither Skeleton Rider)
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class SpiderWitherSkeletonRiderRenderer extends MobEntityRenderer<SpiderWitherSkeletonRiderEntity, SpiderWitherSkeletonRiderModel> {
    private static final Identifier TEXTURE = Identifier.of("luckybreaks", "textures/entity/spider_wither_skeleton_rider.png");
    
    public SpiderWitherSkeletonRiderRenderer(EntityRendererFactory.Context context) {
        super(context, new SpiderWitherSkeletonRiderModel(context.getPart(ModModelLayers.SPIDER_WITHER_SKELETON_RIDER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(SpiderWitherSkeletonRiderEntity entity) {
        return TEXTURE;
    }

}