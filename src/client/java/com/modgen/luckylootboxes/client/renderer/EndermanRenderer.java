package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.EndermanModel;
import com.modgen.luckylootboxes.entity.EndermanEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Enderman
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class EndermanRenderer extends MobEntityRenderer<EndermanEntity, EndermanModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/enderman.png");
    
    public EndermanRenderer(EntityRendererFactory.Context context) {
        super(context, new EndermanModel(context.getPart(ModModelLayers.ENDERMAN)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(EndermanEntity entity) {
        return TEXTURE;
    }

}