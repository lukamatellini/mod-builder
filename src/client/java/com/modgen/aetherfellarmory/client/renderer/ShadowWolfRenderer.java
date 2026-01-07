package com.modgen.aetherfellarmory.client.renderer;

import com.modgen.aetherfellarmory.client.ModModelLayers;
import com.modgen.aetherfellarmory.client.model.ShadowWolfModel;
import com.modgen.aetherfellarmory.entity.ShadowWolfEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Shadow Wolf
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ShadowWolfRenderer extends MobEntityRenderer<ShadowWolfEntity, ShadowWolfModel> {
    private static final Identifier TEXTURE = Identifier.of("aetherfellarmory", "textures/entity/shadow_wolf.png");
    
    public ShadowWolfRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowWolfModel(context.getPart(ModModelLayers.SHADOW_WOLF)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ShadowWolfEntity entity) {
        return TEXTURE;
    }

}