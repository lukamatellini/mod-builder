package com.modgen.chancecubes.client.renderer;

import com.modgen.chancecubes.client.ModModelLayers;
import com.modgen.chancecubes.client.model.UnluckyZombieModel;
import com.modgen.chancecubes.entity.UnluckyZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Unlucky Zombie
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class UnluckyZombieRenderer extends MobEntityRenderer<UnluckyZombieEntity, UnluckyZombieModel> {
    private static final Identifier TEXTURE = Identifier.of("chancecubes", "textures/entity/unlucky_zombie.png");
    
    public UnluckyZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new UnluckyZombieModel(context.getPart(ModModelLayers.UNLUCKY_ZOMBIE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(UnluckyZombieEntity entity) {
        return TEXTURE;
    }

}