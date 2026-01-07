package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.CursedSpiritModel;
import com.modgen.luckylootboxes.entity.CursedSpiritEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Cursed Spirit
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CursedSpiritRenderer extends MobEntityRenderer<CursedSpiritEntity, CursedSpiritModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/cursed_spirit.png");
    
    public CursedSpiritRenderer(EntityRendererFactory.Context context) {
        super(context, new CursedSpiritModel(context.getPart(ModModelLayers.CURSED_SPIRIT)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CursedSpiritEntity entity) {
        return TEXTURE;
    }

}