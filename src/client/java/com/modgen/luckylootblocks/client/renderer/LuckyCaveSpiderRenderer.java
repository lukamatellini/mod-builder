package com.modgen.luckylootblocks.client.renderer;

import com.modgen.luckylootblocks.client.ModModelLayers;
import com.modgen.luckylootblocks.client.model.LuckyCaveSpiderModel;
import com.modgen.luckylootblocks.entity.LuckyCaveSpiderEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Lucky Cave Spider
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class LuckyCaveSpiderRenderer extends MobEntityRenderer<LuckyCaveSpiderEntity, LuckyCaveSpiderModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootblocks", "textures/entity/lucky_cave_spider.png");
    
    public LuckyCaveSpiderRenderer(EntityRendererFactory.Context context) {
        super(context, new LuckyCaveSpiderModel(context.getPart(ModModelLayers.LUCKY_CAVE_SPIDER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(LuckyCaveSpiderEntity entity) {
        return TEXTURE;
    }

}