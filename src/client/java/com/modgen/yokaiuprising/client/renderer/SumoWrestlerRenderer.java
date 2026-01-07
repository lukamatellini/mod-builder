package com.modgen.yokaiuprising.client.renderer;

import com.modgen.yokaiuprising.client.ModModelLayers;
import com.modgen.yokaiuprising.client.model.SumoWrestlerModel;
import com.modgen.yokaiuprising.entity.SumoWrestlerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Sumo Wrestler
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class SumoWrestlerRenderer extends MobEntityRenderer<SumoWrestlerEntity, SumoWrestlerModel> {
    private static final Identifier TEXTURE = Identifier.of("yokaiuprising", "textures/entity/sumo_wrestler.png");
    
    public SumoWrestlerRenderer(EntityRendererFactory.Context context) {
        super(context, new SumoWrestlerModel(context.getPart(ModModelLayers.SUMO_WRESTLER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(SumoWrestlerEntity entity) {
        return TEXTURE;
    }

}