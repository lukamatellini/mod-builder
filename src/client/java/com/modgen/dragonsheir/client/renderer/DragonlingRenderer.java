package com.modgen.dragonsheir.client.renderer;

import com.modgen.dragonsheir.client.ModModelLayers;
import com.modgen.dragonsheir.client.model.DragonlingModel;
import com.modgen.dragonsheir.entity.DragonlingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Dragonling
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class DragonlingRenderer extends MobEntityRenderer<DragonlingEntity, DragonlingModel> {
    private static final Identifier TEXTURE = Identifier.of("dragonsheir", "textures/entity/dragonling.png");
    
    public DragonlingRenderer(EntityRendererFactory.Context context) {
        super(context, new DragonlingModel(context.getPart(ModModelLayers.DRAGONLING)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(DragonlingEntity entity) {
        return TEXTURE;
    }

}