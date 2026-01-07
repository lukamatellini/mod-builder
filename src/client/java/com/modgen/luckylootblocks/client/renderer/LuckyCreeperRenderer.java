package com.modgen.luckylootblocks.client.renderer;

import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.LuckyCreeperModel;
import com.modgen.luckylootblocks.entity.LuckyCreeperEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Lucky Creeper
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class LuckyCreeperRenderer extends MobEntityRenderer<LuckyCreeperEntity, LuckyCreeperModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootblocks", "textures/entity/lucky_creeper.png");
    
    public LuckyCreeperRenderer(EntityRendererFactory.Context context) {
        super(context, new LuckyCreeperModel(context.getPart(ModModelLayers.LUCKY_CREEPER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(LuckyCreeperEntity entity) {
        return TEXTURE;
    }

}