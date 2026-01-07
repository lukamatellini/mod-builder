package com.modgen.sumoundeadworms.client.renderer;

import com.modgen.sumoundeadworms.client.ModModelLayers;
import com.modgen.sumoundeadworms.client.model.YokaiZombieModel;
import com.modgen.sumoundeadworms.entity.YokaiZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Yokai Zombie
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class YokaiZombieRenderer extends MobEntityRenderer<YokaiZombieEntity, YokaiZombieModel> {
    private static final Identifier TEXTURE = Identifier.of("sumoundeadworms", "textures/entity/yokai_zombie.png");
    
    public YokaiZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new YokaiZombieModel(context.getPart(ModModelLayers.YOKAI_ZOMBIE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(YokaiZombieEntity entity) {
        return TEXTURE;
    }

}