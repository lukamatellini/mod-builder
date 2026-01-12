package com.modgen.cheesycraft.client.renderer;

import com.modgen.cheesycraft.client.ModModelLayers;
import com.modgen.cheesycraft.client.model.RatModel;
import com.modgen.cheesycraft.entity.RatEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Rat
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class RatRenderer extends MobEntityRenderer<RatEntity, RatModel> {
    private static final Identifier TEXTURE = Identifier.of("cheesycraft", "textures/entity/rat.png");
    
    public RatRenderer(EntityRendererFactory.Context context) {
        super(context, new RatModel(context.getPart(ModModelLayers.RAT)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(RatEntity entity) {
        return TEXTURE;
    }

}