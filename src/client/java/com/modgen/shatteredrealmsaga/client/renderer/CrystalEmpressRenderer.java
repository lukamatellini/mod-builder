package com.modgen.shatteredrealmsaga.client.renderer;

import com.modgen.shatteredrealmsaga.client.ModModelLayers;
import com.modgen.shatteredrealmsaga.client.model.CrystalEmpressModel;
import com.modgen.shatteredrealmsaga.entity.CrystalEmpressBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Crystal Empress
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CrystalEmpressRenderer extends MobEntityRenderer<CrystalEmpressBossEntity, CrystalEmpressModel> {
    private static final Identifier TEXTURE = Identifier.of("shatteredrealmsaga", "textures/entity/crystal_empress.png");
    
    public CrystalEmpressRenderer(EntityRendererFactory.Context context) {
        super(context, new CrystalEmpressModel(context.getPart(ModModelLayers.CRYSTAL_EMPRESS)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(CrystalEmpressBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(CrystalEmpressBossEntity entity) {
        return true;
    }
}