package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.PirateModel;
import com.modgen.gemstoneodyssey.entity.PirateEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Pirate
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class PirateRenderer extends MobEntityRenderer<PirateEntity, PirateModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/pirate.png");
    
    public PirateRenderer(EntityRendererFactory.Context context) {
        super(context, new PirateModel(context.getPart(ModModelLayers.PIRATE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(PirateEntity entity) {
        return TEXTURE;
    }

}