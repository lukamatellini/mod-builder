package com.modgen.voidconquest.client.renderer;

import com.modgen.voidconquest.client.ModModelLayers;
import com.modgen.voidconquest.client.model.ShadowLordModel;
import com.modgen.voidconquest.entity.ShadowLordBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Shadow Lord
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ShadowLordRenderer extends MobEntityRenderer<ShadowLordBossEntity, ShadowLordModel> {
    private static final Identifier TEXTURE = Identifier.of("voidconquest", "textures/entity/shadow_lord.png");
    
    public ShadowLordRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowLordModel(context.getPart(ModModelLayers.SHADOW_LORD)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(ShadowLordBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(ShadowLordBossEntity entity) {
        return true;
    }
}