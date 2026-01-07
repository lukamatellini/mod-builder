package com.modgen.sumoundeadworms.client.renderer;

import com.modgen.sumoundeadworms.client.ModModelLayers;
import com.modgen.sumoundeadworms.client.model.JapaneseSumoWrestlerModel;
import com.modgen.sumoundeadworms.entity.JapaneseSumoWrestlerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Japanese Sumo Wrestler
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class JapaneseSumoWrestlerRenderer extends MobEntityRenderer<JapaneseSumoWrestlerEntity, JapaneseSumoWrestlerModel> {
    private static final Identifier TEXTURE = Identifier.of("sumoundeadworms", "textures/entity/japanese_sumo_wrestler.png");
    
    public JapaneseSumoWrestlerRenderer(EntityRendererFactory.Context context) {
        super(context, new JapaneseSumoWrestlerModel(context.getPart(ModModelLayers.JAPANESE_SUMO_WRESTLER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(JapaneseSumoWrestlerEntity entity) {
        return TEXTURE;
    }

}