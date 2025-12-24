package com.modgen.shatteredascent.client.renderer;

import com.modgen.shatteredascent.client.ModModelLayers;
import com.modgen.shatteredascent.client.model.ShadowWraithModel;
import com.modgen.shatteredascent.entity.ShadowWraithEntity;
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
    private static final Identifier TEXTURE = Identifier.of("shatteredascent", "textures/entity/shadow_wraith.png");
    
    public ShadowWraithRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowWraithModel(context.getPart(ModModelLayers.SHADOW_WRAITH)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ShadowWraithEntity entity) {
        return TEXTURE;
    }

}