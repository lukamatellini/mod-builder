package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.ZombieModel;
import com.modgen.luckylootboxes.entity.ZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Zombie
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ZombieRenderer extends MobEntityRenderer<ZombieEntity, ZombieModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/zombie.png");
    
    public ZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new ZombieModel(context.getPart(ModModelLayers.ZOMBIE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ZombieEntity entity) {
        return TEXTURE;
    }

}