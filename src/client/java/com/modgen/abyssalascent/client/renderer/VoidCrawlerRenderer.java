package com.modgen.abyssalascent.client.renderer;

import com.modgen.abyssalascent.client.ModModelLayers;
import com.modgen.abyssalascent.client.model.VoidCrawlerModel;
import com.modgen.abyssalascent.entity.VoidCrawlerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Void Crawler
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class VoidCrawlerRenderer extends MobEntityRenderer<VoidCrawlerEntity, VoidCrawlerModel> {
    private static final Identifier TEXTURE = Identifier.of("abyssalascent", "textures/entity/void_crawler.png");
    
    public VoidCrawlerRenderer(EntityRendererFactory.Context context) {
        super(context, new VoidCrawlerModel(context.getPart(ModModelLayers.VOID_CRAWLER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(VoidCrawlerEntity entity) {
        return TEXTURE;
    }

}