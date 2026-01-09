package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.VoidfishModel;
import com.modgen.gemstoneodyssey.entity.VoidfishEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Voidfish
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidfishRenderer extends MobEntityRenderer<VoidfishEntity, VoidfishModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/voidfish.png");
    
    public VoidfishRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidfishModel(context.getPart(ModModelLayers.VOIDFISH)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VoidfishEntity entity) {
        return TEXTURE;
    }

}