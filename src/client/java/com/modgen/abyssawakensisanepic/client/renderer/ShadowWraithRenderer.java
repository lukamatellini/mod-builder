package com.modgen.abyssawakensisanepic.client.renderer;

import com.modgen.abyssawakensisanepic.client.ModModelLayers;
import com.modgen.abyssawakensisanepic.client.model.ShadowWraithModel;
import com.modgen.abyssawakensisanepic.entity.ShadowWraithEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Shadow Wraith
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ShadowWraithRenderer extends MobEntityRenderer<ShadowWraithEntity, ShadowWraithModel> {
    private static final Identifier TEXTURE = Identifier.of("abyssawakensisanepic", "textures/entity/shadow_wraith.png");
    
    public ShadowWraithRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowWraithModel(context.getPart(ModModelLayers.SHADOW_WRAITH)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ShadowWraithEntity entity) {
        return TEXTURE;
    }

}