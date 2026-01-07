package com.modgen.yokaiuprising.client.renderer;

import com.modgen.yokaiuprising.client.ModModelLayers;
import com.modgen.yokaiuprising.client.model.CaveWormModel;
import com.modgen.yokaiuprising.entity.CaveWormEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Cave Worm
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CaveWormRenderer extends MobEntityRenderer<CaveWormEntity, CaveWormModel> {
    private static final Identifier TEXTURE = Identifier.of("yokaiuprising", "textures/entity/cave_worm.png");
    
    public CaveWormRenderer(EntityRendererFactory.Context context) {
        super(context, new CaveWormModel(context.getPart(ModModelLayers.CAVE_WORM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CaveWormEntity entity) {
        return TEXTURE;
    }

}