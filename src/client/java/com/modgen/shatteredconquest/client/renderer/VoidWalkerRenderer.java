package com.modgen.shatteredconquest.client.renderer;

import com.modgen.shatteredconquest.client.ModModelLayers;
import com.modgen.shatteredconquest.client.model.VoidWalkerModel;
import com.modgen.shatteredconquest.entity.VoidWalkerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Walker
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidWalkerRenderer extends MobEntityRenderer<VoidWalkerEntity, VoidWalkerModel> {
    private static final Identifier TEXTURE = Identifier.of("shatteredconquest", "textures/entity/void_walker.png");
    
    public VoidWalkerRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidWalkerModel(context.getPart(ModModelLayers.VOID_WALKER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VoidWalkerEntity entity) {
        return TEXTURE;
    }

}