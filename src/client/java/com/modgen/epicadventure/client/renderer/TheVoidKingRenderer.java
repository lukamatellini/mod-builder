package com.modgen.epicadventure.client.renderer;

import com.modgen.epicadventure.client.ModModelLayers;
import com.modgen.epicadventure.client.model.TheVoidKingModel;
import com.modgen.epicadventure.entity.TheVoidKingBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for The Void King
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class TheVoidKingRenderer extends MobEntityRenderer<TheVoidKingBossEntity, TheVoidKingModel> {
    private static final Identifier TEXTURE = Identifier.of("epicadventure", "textures/entity/the_void_king.png");
    
    public TheVoidKingRenderer(EntityRendererFactory.Context context) {
        super(context, new TheVoidKingModel(context.getPart(ModModelLayers.THE_VOID_KING)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(TheVoidKingBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(TheVoidKingBossEntity entity) {
        return true;
    }
}