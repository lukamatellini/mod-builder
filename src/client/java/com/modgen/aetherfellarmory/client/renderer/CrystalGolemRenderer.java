package com.modgen.aetherfellarmory.client.renderer;

import com.modgen.aetherfellarmory.client.ModModelLayers;
import com.modgen.aetherfellarmory.client.model.CrystalGolemModel;
import com.modgen.aetherfellarmory.entity.CrystalGolemEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Crystal Golem
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CrystalGolemRenderer extends MobEntityRenderer<CrystalGolemEntity, CrystalGolemModel> {
    private static final Identifier TEXTURE = Identifier.of("aetherfellarmory", "textures/entity/crystal_golem.png");
    
    public CrystalGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CrystalGolemModel(context.getPart(ModModelLayers.CRYSTAL_GOLEM)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CrystalGolemEntity entity) {
        return TEXTURE;
    }

}