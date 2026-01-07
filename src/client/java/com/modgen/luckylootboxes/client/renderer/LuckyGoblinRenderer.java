package com.modgen.luckylootboxes.client.renderer;

import com.modgen.luckylootboxes.client.ModModelLayers;
import com.modgen.luckylootboxes.client.model.LuckyGoblinModel;
import com.modgen.luckylootboxes.entity.LuckyGoblinEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Lucky Goblin
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class LuckyGoblinRenderer extends MobEntityRenderer<LuckyGoblinEntity, LuckyGoblinModel> {
    private static final Identifier TEXTURE = Identifier.of("luckylootboxes", "textures/entity/lucky_goblin.png");
    
    public LuckyGoblinRenderer(EntityRendererFactory.Context context) {
        super(context, new LuckyGoblinModel(context.getPart(ModModelLayers.LUCKY_GOBLIN)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(LuckyGoblinEntity entity) {
        return TEXTURE;
    }

}