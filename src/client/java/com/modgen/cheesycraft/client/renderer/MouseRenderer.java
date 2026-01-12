package com.modgen.cheesycraft.client.renderer;

import com.modgen.cheesycraft.client.ModModelLayers;
import com.modgen.cheesycraft.client.model.MouseModel;
import com.modgen.cheesycraft.entity.MouseEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Mouse
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class MouseRenderer extends MobEntityRenderer<MouseEntity, MouseModel> {
    private static final Identifier TEXTURE = Identifier.of("cheesycraft", "textures/entity/mouse.png");
    
    public MouseRenderer(EntityRendererFactory.Context context) {
        super(context, new MouseModel(context.getPart(ModModelLayers.MOUSE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(MouseEntity entity) {
        return TEXTURE;
    }

}