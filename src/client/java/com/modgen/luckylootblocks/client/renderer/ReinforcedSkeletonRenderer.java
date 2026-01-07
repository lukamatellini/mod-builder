package com.modgen.luckylootblocks.client.renderer;

import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.ReinforcedSkeletonModel;
import com.modgen.luckylootblocks.entity.ReinforcedSkeletonEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Reinforced Skeleton
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ReinforcedSkeletonRenderer extends MobEntityRenderer<ReinforcedSkeletonEntity, ReinforcedSkeletonModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootblocks", "textures/entity/reinforced_skeleton.png");
    
    public ReinforcedSkeletonRenderer(EntityRendererFactory.Context context) {
        super(context, new ReinforcedSkeletonModel(context.getPart(ModModelLayers.REINFORCED_SKELETON)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ReinforcedSkeletonEntity entity) {
        return TEXTURE;
    }

}