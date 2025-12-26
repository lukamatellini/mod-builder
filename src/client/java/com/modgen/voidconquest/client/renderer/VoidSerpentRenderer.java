package com.modgen.voidconquest.client.renderer;

import com.modgen.voidconquest.client.ModModelLayers;
import com.modgen.voidconquest.client.model.VoidSerpentModel;
import com.modgen.voidconquest.entity.VoidSerpentBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Serpent
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidSerpentRenderer extends MobEntityRenderer<VoidSerpentBossEntity, VoidSerpentModel> {
    private static final Identifier TEXTURE = Identifier.of("voidconquest", "textures/entity/void_serpent.png");
    
    public VoidSerpentRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidSerpentModel(context.getPart(ModModelLayers.VOID_SERPENT)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(VoidSerpentBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(VoidSerpentBossEntity entity) {
        return true;
    }
}