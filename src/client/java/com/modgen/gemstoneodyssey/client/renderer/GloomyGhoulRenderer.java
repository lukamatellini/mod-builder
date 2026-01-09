package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.GloomyGhoulModel;
import com.modgen.gemstoneodyssey.entity.GloomyGhoulEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Gloomy Ghoul
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class GloomyGhoulRenderer extends MobEntityRenderer<GloomyGhoulEntity, GloomyGhoulModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/gloomy_ghoul.png");
    
    public GloomyGhoulRenderer(EntityRendererFactory.Context context) {
        super(context, new GloomyGhoulModel(context.getPart(ModModelLayers.GLOOMY_GHOUL)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(GloomyGhoulEntity entity) {
        return TEXTURE;
    }

}