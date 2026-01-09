package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.BenevolentFloatingCreatureModel;
import com.modgen.gemstoneodyssey.entity.BenevolentFloatingCreatureEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Benevolent Floating Creature
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class BenevolentFloatingCreatureRenderer extends MobEntityRenderer<BenevolentFloatingCreatureEntity, BenevolentFloatingCreatureModel> {
    private static final Identifier TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/benevolent_floating_creature.png");
    
    public BenevolentFloatingCreatureRenderer(EntityRendererFactory.Context context) {
        super(context, new BenevolentFloatingCreatureModel(context.getPart(ModModelLayers.BENEVOLENT_FLOATING_CREATURE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(BenevolentFloatingCreatureEntity entity) {
        return TEXTURE;
    }

}