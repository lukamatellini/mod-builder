package com.modgen.luckybreaks.client.renderer;

import com.modgen.luckybreaks.client.ModModelLayers;
import com.modgen.luckybreaks.client.model.SkeletonEnchantedBowModel;
import com.modgen.luckybreaks.entity.SkeletonEnchantedBowEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Skeleton (Enchanted Bow)
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class SkeletonEnchantedBowRenderer extends MobEntityRenderer<SkeletonEnchantedBowEntity, SkeletonEnchantedBowModel> {
    private static final Identifier TEXTURE = Identifier.of("luckybreaks", "textures/entity/skeleton_enchanted_bow.png");
    
    public SkeletonEnchantedBowRenderer(EntityRendererFactory.Context context) {
        super(context, new SkeletonEnchantedBowModel(context.getPart(ModModelLayers.SKELETON_ENCHANTED_BOW)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(SkeletonEnchantedBowEntity entity) {
        return TEXTURE;
    }

}