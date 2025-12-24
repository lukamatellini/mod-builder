package com.modgen.shatteredascent.client.renderer;

import com.modgen.shatteredascent.client.ModModelLayers;
import com.modgen.shatteredascent.client.model.TheVoidTitanModel;
import com.modgen.shatteredascent.entity.TheVoidTitanBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for The Void Titan
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class TheVoidTitanRenderer extends MobEntityRenderer<TheVoidTitanBossEntity, TheVoidTitanModel> {
    private static final Identifier TEXTURE = Identifier.of("shatteredascent", "textures/entity/the_void_titan.png");
    
    public TheVoidTitanRenderer(EntityRendererFactory.Context context) {
        super(context, new TheVoidTitanModel(context.getPart(ModModelLayers.THE_VOID_TITAN)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(TheVoidTitanBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(TheVoidTitanBossEntity entity) {
        return true;
    }
}