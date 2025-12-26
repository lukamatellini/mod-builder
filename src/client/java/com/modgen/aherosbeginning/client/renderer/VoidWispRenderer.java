package com.modgen.aherosbeginning.client.renderer;

import com.modgen.aherosbeginning.client.ModModelLayers;
import com.modgen.aherosbeginning.client.model.VoidWispModel;
import com.modgen.aherosbeginning.entity.VoidWispEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Wisp
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidWispRenderer extends MobEntityRenderer<VoidWispEntity, VoidWispModel> {
    private static final Identifier TEXTURE = Identifier.of("aherosbeginning", "textures/entity/void_wisp.png");
    
    public VoidWispRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidWispModel(context.getPart(ModModelLayers.VOID_WISP)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VoidWispEntity entity) {
        return TEXTURE;
    }

}