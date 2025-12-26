package com.modgen.aherosbeginning.client.renderer;

import com.modgen.aherosbeginning.client.ModModelLayers;
import com.modgen.aherosbeginning.client.model.CrystalGuardianModel;
import com.modgen.aherosbeginning.entity.CrystalGuardianEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Crystal Guardian
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CrystalGuardianRenderer extends MobEntityRenderer<CrystalGuardianEntity, CrystalGuardianModel> {
    private static final Identifier TEXTURE = Identifier.of("aherosbeginning", "textures/entity/crystal_guardian.png");
    
    public CrystalGuardianRenderer(EntityRendererFactory.Context context) {
        super(context, new CrystalGuardianModel(context.getPart(ModModelLayers.CRYSTAL_GUARDIAN)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CrystalGuardianEntity entity) {
        return TEXTURE;
    }

}