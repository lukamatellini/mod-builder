package com.modgen.dragonsheir.client.renderer;

import com.modgen.dragonsheir.client.ModModelLayers;
import com.modgen.dragonsheir.client.model.AncientDragonBossModel;
import com.modgen.dragonsheir.entity.AncientDragonBossEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Ancient Dragon
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class AncientDragonBossRenderer extends MobEntityRenderer<AncientDragonBossEntity, AncientDragonBossModel> {
    private static final Identifier TEXTURE = Identifier.of("dragonsheir", "textures/entity/ancient_dragon_boss.png");
    
    public AncientDragonBossRenderer(EntityRendererFactory.Context context) {
        super(context, new AncientDragonBossModel(context.getPart(ModModelLayers.ANCIENT_DRAGON_BOSS)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(AncientDragonBossEntity entity) {
        return TEXTURE;
    }

}