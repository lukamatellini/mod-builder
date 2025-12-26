package com.modgen.voidconquest.client.renderer;

import com.modgen.voidconquest.client.ModModelLayers;
import com.modgen.voidconquest.client.model.CrystalGolemModel;
import com.modgen.voidconquest.entity.CrystalGolemBossEntity;
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
public class CrystalGolemRenderer extends MobEntityRenderer<CrystalGolemBossEntity, CrystalGolemModel> {
    private static final Identifier TEXTURE = Identifier.of("voidconquest", "textures/entity/crystal_golem.png");
    
    public CrystalGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CrystalGolemModel(context.getPart(ModModelLayers.CRYSTAL_GOLEM)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(CrystalGolemBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(CrystalGolemBossEntity entity) {
        return true;
    }
}