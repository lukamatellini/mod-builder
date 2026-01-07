package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.VexModel;
import com.modgen.luckylootboxes.entity.VexEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Vex
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VexRenderer extends MobEntityRenderer<VexEntity, VexModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/vex.png");
    
    public VexRenderer(EntityRendererFactory.Context context) {
        super(context, new VexModel(context.getPart(ModModelLayers.VEX)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VexEntity entity) {
        return TEXTURE;
    }

}