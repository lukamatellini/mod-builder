package com.modgen.aetheriaascendant.client.renderer;

import com.modgen.aetheriaascendant.client.ModModelLayers;
import com.modgen.aetheriaascendant.client.model.AetherGolemModel;
import com.modgen.aetheriaascendant.entity.AetherGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Aether Golem
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class AetherGolemRenderer extends MobEntityRenderer<AetherGolemEntity, AetherGolemModel> {
    private static final Identifier TEXTURE = Identifier.of("aetheriaascendant", "textures/entity/aether_golem.png");
    
    public AetherGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new AetherGolemModel(context.getPart(ModModelLayers.AETHER_GOLEM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(AetherGolemEntity entity) {
        return TEXTURE;
    }

}