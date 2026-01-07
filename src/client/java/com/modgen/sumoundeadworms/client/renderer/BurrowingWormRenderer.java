package com.modgen.sumoundeadworms.client.renderer;

import com.modgen.sumoundeadworms.client.ModModelLayers;
import com.modgen.sumoundeadworms.client.model.BurrowingWormModel;
import com.modgen.sumoundeadworms.entity.BurrowingWormEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Burrowing Worm
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class BurrowingWormRenderer extends MobEntityRenderer<BurrowingWormEntity, BurrowingWormModel> {
    private static final Identifier TEXTURE = Identifier.of("sumoundeadworms", "textures/entity/burrowing_worm.png");
    
    public BurrowingWormRenderer(EntityRendererFactory.Context context) {
        super(context, new BurrowingWormModel(context.getPart(ModModelLayers.BURROWING_WORM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(BurrowingWormEntity entity) {
        return TEXTURE;
    }

}