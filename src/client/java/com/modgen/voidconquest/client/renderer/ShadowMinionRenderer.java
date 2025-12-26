package com.modgen.voidconquest.client.renderer;

import com.modgen.voidconquest.client.ModModelLayers;
import com.modgen.voidconquest.client.model.ShadowMinionModel;
import com.modgen.voidconquest.entity.ShadowMinionEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Shadow Minion
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ShadowMinionRenderer extends MobEntityRenderer<ShadowMinionEntity, ShadowMinionModel> {
    private static final Identifier TEXTURE = Identifier.of("voidconquest", "textures/entity/shadow_minion.png");
    
    public ShadowMinionRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowMinionModel(context.getPart(ModModelLayers.SHADOW_MINION)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ShadowMinionEntity entity) {
        return TEXTURE;
    }

}