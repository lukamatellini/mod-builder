package com.modgen.abyssalascent.client.renderer;

import com.modgen.abyssalascent.client.ModModelLayers;
import com.modgen.abyssalascent.client.model.VoidCommanderModel;
import com.modgen.abyssalascent.entity.VoidCommanderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Commander
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidCommanderRenderer extends MobEntityRenderer<VoidCommanderEntity, VoidCommanderModel> {
    private static final Identifier TEXTURE = Identifier.of("abyssalascent", "textures/entity/void_commander.png");
    
    public VoidCommanderRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidCommanderModel(context.getPart(ModModelLayers.VOID_COMMANDER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VoidCommanderEntity entity) {
        return TEXTURE;
    }

}