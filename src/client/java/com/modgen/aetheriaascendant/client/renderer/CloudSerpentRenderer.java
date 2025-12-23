package com.modgen.aetheriaascendant.client.renderer;

import com.modgen.aetheriaascendant.client.ModModelLayers;
import com.modgen.aetheriaascendant.client.model.CloudSerpentModel;
import com.modgen.aetheriaascendant.entity.CloudSerpentEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Cloud Serpent
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CloudSerpentRenderer extends MobEntityRenderer<CloudSerpentEntity, CloudSerpentModel> {
    private static final Identifier TEXTURE = Identifier.of("aetheriaascendant", "textures/entity/cloud_serpent.png");
    
    public CloudSerpentRenderer(EntityRendererFactory.Context context) {
        super(context, new CloudSerpentModel(context.getPart(ModModelLayers.CLOUD_SERPENT)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CloudSerpentEntity entity) {
        return TEXTURE;
    }

}