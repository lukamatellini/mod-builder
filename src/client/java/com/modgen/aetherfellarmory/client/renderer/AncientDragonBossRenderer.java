package com.modgen.aetherfellarmory.client.renderer;

import com.modgen.aetherfellarmory.client.ModModelLayers;
import com.modgen.aetherfellarmory.client.model.AncientDragonBossModel;
import com.modgen.aetherfellarmory.entity.AncientDragonBossBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Ancient Dragon Boss
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class AncientDragonBossRenderer extends MobEntityRenderer<AncientDragonBossBossEntity, AncientDragonBossModel> {
    private static final Identifier TEXTURE = Identifier.of("aetherfellarmory", "textures/entity/ancient_dragon_boss.png");
    
    public AncientDragonBossRenderer(EntityRendererFactory.Context context) {
        super(context, new AncientDragonBossModel(context.getPart(ModModelLayers.ANCIENT_DRAGON_BOSS)), 1.5F);
    }
    
    @Override
    public Identifier getTexture(AncientDragonBossBossEntity entity) {
        return TEXTURE;
    }

    @Override
    protected boolean hasLabel(AncientDragonBossBossEntity entity) {
        return true;
    }
}