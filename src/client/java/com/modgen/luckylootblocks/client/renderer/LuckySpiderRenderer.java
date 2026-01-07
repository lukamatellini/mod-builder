package com.modgen.luckylootblocks.client.renderer;

import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.LuckySpiderModel;
import com.modgen.luckylootblocks.entity.LuckySpiderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Lucky Spider
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class LuckySpiderRenderer extends MobEntityRenderer<LuckySpiderEntity, LuckySpiderModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootblocks", "textures/entity/lucky_spider.png");
    
    public LuckySpiderRenderer(EntityRendererFactory.Context context) {
        super(context, new LuckySpiderModel(context.getPart(ModModelLayers.LUCKY_SPIDER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(LuckySpiderEntity entity) {
        return TEXTURE;
    }

}