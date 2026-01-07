package com.modgen.cheesyblade.client.renderer;

import com.modgen.cheesyblade.client.ModModelLayers;
import com.modgen.cheesyblade.client.model.HungryMouseModel;
import com.modgen.cheesyblade.entity.HungryMouseEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Hungry Mouse
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class HungryMouseRenderer extends MobEntityRenderer<HungryMouseEntity, HungryMouseModel> {
    private static final Identifier TEXTURE = Identifier.of("cheesyblade", "textures/entity/hungry_mouse.png");
    
    public HungryMouseRenderer(EntityRendererFactory.Context context) {
        super(context, new HungryMouseModel(context.getPart(ModModelLayers.HUNGRY_MOUSE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(HungryMouseEntity entity) {
        return TEXTURE;
    }

}