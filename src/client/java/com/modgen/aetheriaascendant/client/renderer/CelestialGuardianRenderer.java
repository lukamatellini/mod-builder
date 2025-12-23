package com.modgen.aetheriaascendant.client.renderer;

import com.modgen.aetheriaascendant.client.ModModelLayers;
import com.modgen.aetheriaascendant.client.model.CelestialGuardianModel;
import com.modgen.aetheriaascendant.entity.CelestialGuardianBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Celestial Guardian
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CelestialGuardianRenderer extends MobEntityRenderer<CelestialGuardianBossEntity, CelestialGuardianModel> {
    private static final Identifier TEXTURE = Identifier.of("aetheriaascendant", "textures/entity/celestial_guardian.png");
    
    public CelestialGuardianRenderer(EntityRendererFactory.Context context) {
        super(context, new CelestialGuardianModel(context.getPart(ModModelLayers.CELESTIAL_GUARDIAN)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(CelestialGuardianBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(CelestialGuardianBossEntity entity) {
        return true;
    }
}