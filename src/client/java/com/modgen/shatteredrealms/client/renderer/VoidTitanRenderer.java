package com.modgen.shatteredrealms.client.renderer;

import com.modgen.shatteredrealms.client.ModModelLayers;
import com.modgen.shatteredrealms.client.model.VoidTitanModel;
import com.modgen.shatteredrealms.entity.VoidTitanBossEntity;
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
public class VoidTitanRenderer extends MobEntityRenderer<VoidTitanBossEntity, VoidTitanModel> {
    private static final Identifier TEXTURE = Identifier.of("shatteredrealms", "textures/entity/void_titan.png");
    
    public VoidTitanRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidTitanModel(context.getPart(ModModelLayers.VOID_TITAN)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(VoidTitanBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(VoidTitanBossEntity entity) {
        return true;
    }
}