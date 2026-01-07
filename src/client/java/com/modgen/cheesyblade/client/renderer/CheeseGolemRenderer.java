package com.modgen.cheesyblade.client.renderer;

import com.modgen.cheesyblade.client.ModModelLayers;
import com.modgen.cheesyblade.client.model.CheeseGolemModel;
import com.modgen.cheesyblade.entity.CheeseGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Cheese Golem
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CheeseGolemRenderer extends MobEntityRenderer<CheeseGolemEntity, CheeseGolemModel> {
    private static final Identifier TEXTURE = Identifier.of("cheesyblade", "textures/entity/cheese_golem.png");
    
    public CheeseGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CheeseGolemModel(context.getPart(ModModelLayers.CHEESE_GOLEM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CheeseGolemEntity entity) {
        return TEXTURE;
    }

}