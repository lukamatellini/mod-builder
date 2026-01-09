package com.modgen.twilightgemcraft.client.renderer;

import com.modgen.twilightgemcraft.client.ModModelLayers;
import com.modgen.twilightgemcraft.client.model.NightProwlerModel;
import com.modgen.twilightgemcraft.entity.NightProwlerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Night Prowler
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class NightProwlerRenderer extends MobEntityRenderer<NightProwlerEntity, NightProwlerModel> {
    private static final Identifier TEXTURE = Identifier.of("twilightgemcraft", "textures/entity/night_prowler.png");
    
    public NightProwlerRenderer(EntityRendererFactory.Context context) {
        super(context, new NightProwlerModel(context.getPart(ModModelLayers.NIGHT_PROWLER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(NightProwlerEntity entity) {
        return TEXTURE;
    }

}