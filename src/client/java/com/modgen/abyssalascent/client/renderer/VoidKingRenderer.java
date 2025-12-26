package com.modgen.abyssalascent.client.renderer;

import com.modgen.abyssalascent.client.ModModelLayers;
import com.modgen.abyssalascent.client.model.VoidKingModel;
import com.modgen.abyssalascent.entity.VoidKingBossEntity;
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
public class VoidKingRenderer extends MobEntityRenderer<VoidKingBossEntity, VoidKingModel> {
    private static final Identifier TEXTURE = Identifier.of("abyssalascent", "textures/entity/void_king.png");
    
    public VoidKingRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidKingModel(context.getPart(ModModelLayers.VOID_KING)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(VoidKingBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(VoidKingBossEntity entity) {
        return true;
    }
}