package com.modgen.dragonsheir.client.renderer;

import com.modgen.dragonsheir.client.ModModelLayers;
import com.modgen.dragonsheir.client.model.ScorpionModel;
import com.modgen.dragonsheir.entity.ScorpionEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Scorpion
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ScorpionRenderer extends MobEntityRenderer<ScorpionEntity, ScorpionModel> {
    private static final Identifier TEXTURE = Identifier.of("dragonsheir", "textures/entity/scorpion.png");
    
    public ScorpionRenderer(EntityRendererFactory.Context context) {
        super(context, new ScorpionModel(context.getPart(ModModelLayers.SCORPION)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ScorpionEntity entity) {
        return TEXTURE;
    }

}