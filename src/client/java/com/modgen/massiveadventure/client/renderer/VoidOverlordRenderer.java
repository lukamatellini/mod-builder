package com.modgen.massiveadventure.client.renderer;

import com.modgen.massiveadventure.client.ModModelLayers;
import com.modgen.massiveadventure.client.model.VoidOverlordModel;
import com.modgen.massiveadventure.entity.VoidOverlordBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Overlord
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidOverlordRenderer extends MobEntityRenderer<VoidOverlordBossEntity, VoidOverlordModel> {
    private static final Identifier TEXTURE = Identifier.of("massiveadventure", "textures/entity/void_overlord.png");
    
    public VoidOverlordRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidOverlordModel(context.getPart(ModModelLayers.VOID_OVERLORD)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(VoidOverlordBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(VoidOverlordBossEntity entity) {
        return true;
    }
}