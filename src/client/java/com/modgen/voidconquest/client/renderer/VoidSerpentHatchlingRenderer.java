package com.modgen.voidconquest.client.renderer;

import com.modgen.voidconquest.client.ModModelLayers;
import com.modgen.voidconquest.client.model.VoidSerpentHatchlingModel;
import com.modgen.voidconquest.entity.VoidSerpentHatchlingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Serpent Hatchling
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidSerpentHatchlingRenderer extends MobEntityRenderer<VoidSerpentHatchlingEntity, VoidSerpentHatchlingModel> {
    private static final Identifier TEXTURE = Identifier.of("voidconquest", "textures/entity/void_serpent_hatchling.png");
    
    public VoidSerpentHatchlingRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidSerpentHatchlingModel(context.getPart(ModModelLayers.VOID_SERPENT_HATCHLING)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VoidSerpentHatchlingEntity entity) {
        return TEXTURE;
    }

}