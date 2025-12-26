package com.modgen.abyssalascent.client.renderer;

import com.modgen.abyssalascent.client.ModModelLayers;
import com.modgen.abyssalascent.client.model.CorruptedVillagerModel;
import com.modgen.abyssalascent.entity.CorruptedVillagerEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Corrupted Villager
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class CorruptedVillagerRenderer extends MobEntityRenderer<CorruptedVillagerEntity, CorruptedVillagerModel> {
    private static final Identifier TEXTURE = Identifier.of("abyssalascent", "textures/entity/corrupted_villager.png");
    
    public CorruptedVillagerRenderer(EntityRendererFactory.Context context) {
        super(context, new CorruptedVillagerModel(context.getPart(ModModelLayers.CORRUPTED_VILLAGER)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(CorruptedVillagerEntity entity) {
        return TEXTURE;
    }

}