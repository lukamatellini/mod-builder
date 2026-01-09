package com.modgen.dragonsheir.client.renderer;

import com.modgen.dragonsheir.client.ModModelLayers;
import com.modgen.dragonsheir.client.model.UnicornModel;
import com.modgen.dragonsheir.entity.UnicornEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Unicorn
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class UnicornRenderer extends MobEntityRenderer<UnicornEntity, UnicornModel> {
    private static final Identifier TEXTURE = Identifier.of("dragonsheir", "textures/entity/unicorn.png");
    
    public UnicornRenderer(EntityRendererFactory.Context context) {
        super(context, new UnicornModel(context.getPart(ModModelLayers.UNICORN)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(UnicornEntity entity) {
        return TEXTURE;
    }

}