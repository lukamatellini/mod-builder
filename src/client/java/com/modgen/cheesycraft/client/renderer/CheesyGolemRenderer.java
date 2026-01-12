package com.modgen.cheesycraft.client.renderer;

import com.modgen.cheesycraft.client.ModModelLayers;
import com.modgen.cheesycraft.client.model.CheesyGolemModel;
import com.modgen.cheesycraft.entity.CheesyGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Cheesy Golem
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CheesyGolemRenderer extends MobEntityRenderer<CheesyGolemEntity, CheesyGolemModel> {
    private static final Identifier TEXTURE = Identifier.of("cheesycraft", "textures/entity/cheesy_golem.png");
    
    public CheesyGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CheesyGolemModel(context.getPart(ModModelLayers.CHEESY_GOLEM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CheesyGolemEntity entity) {
        return TEXTURE;
    }

}