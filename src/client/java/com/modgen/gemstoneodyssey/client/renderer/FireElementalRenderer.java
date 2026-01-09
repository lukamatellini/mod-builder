package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.FireElementalModel;
import com.modgen.gemstoneodyssey.entity.FireElementalEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Fire Elemental
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class FireElementalRenderer extends MobEntityRenderer<FireElementalEntity, FireElementalModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/fire_elemental.png");
    
    public FireElementalRenderer(EntityRendererFactory.Context context) {
        super(context, new FireElementalModel(context.getPart(ModModelLayers.FIRE_ELEMENTAL)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(FireElementalEntity entity) {
        return TEXTURE;
    }

}