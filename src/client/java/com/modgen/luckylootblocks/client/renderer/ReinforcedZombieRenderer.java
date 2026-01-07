package com.modgen.luckylootblocks.client.renderer;

import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.ReinforcedZombieModel;
import com.modgen.luckylootblocks.entity.ReinforcedZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Reinforced Zombie
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ReinforcedZombieRenderer extends MobEntityRenderer<ReinforcedZombieEntity, ReinforcedZombieModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootblocks", "textures/entity/reinforced_zombie.png");
    
    public ReinforcedZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new ReinforcedZombieModel(context.getPart(ModModelLayers.REINFORCED_ZOMBIE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ReinforcedZombieEntity entity) {
        return TEXTURE;
    }

}