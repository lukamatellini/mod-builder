package com.modgen.luckylootblocks.client.renderer;

import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.LuckyZombieModel;
import com.modgen.luckylootblocks.entity.LuckyZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Lucky Zombie
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class LuckyZombieRenderer extends MobEntityRenderer<LuckyZombieEntity, LuckyZombieModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootblocks", "textures/entity/lucky_zombie.png");
    
    public LuckyZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new LuckyZombieModel(context.getPart(ModModelLayers.LUCKY_ZOMBIE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(LuckyZombieEntity entity) {
        return TEXTURE;
    }

}