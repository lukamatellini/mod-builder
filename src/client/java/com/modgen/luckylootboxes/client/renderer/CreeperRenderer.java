package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.CreeperModel;
import com.modgen.luckylootboxes.entity.CreeperEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Creeper
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CreeperRenderer extends MobEntityRenderer<CreeperEntity, CreeperModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/creeper.png");
    
    public CreeperRenderer(EntityRendererFactory.Context context) {
        super(context, new CreeperModel(context.getPart(ModModelLayers.CREEPER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CreeperEntity entity) {
        return TEXTURE;
    }

}