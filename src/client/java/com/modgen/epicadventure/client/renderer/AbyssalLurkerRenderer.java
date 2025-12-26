package com.modgen.epicadventure.client.renderer;

import com.modgen.epicadventure.client.ModModelLayers;
import com.modgen.epicadventure.client.model.AbyssalLurkerModel;
import com.modgen.epicadventure.entity.AbyssalLurkerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Abyssal Lurker
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class AbyssalLurkerRenderer extends MobEntityRenderer<AbyssalLurkerEntity, AbyssalLurkerModel> {
    private static final Identifier TEXTURE = Identifier.of("epicadventure", "textures/entity/abyssal_lurker.png");
    
    public AbyssalLurkerRenderer(EntityRendererFactory.Context context) {
        super(context, new AbyssalLurkerModel(context.getPart(ModModelLayers.ABYSSAL_LURKER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(AbyssalLurkerEntity entity) {
        return TEXTURE;
    }

}