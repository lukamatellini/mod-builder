package com.modgen.yokaiuprising.client.renderer;

import com.modgen.yokaiuprising.client.ModModelLayers;
import com.modgen.yokaiuprising.client.model.MutatedZombieModel;
import com.modgen.yokaiuprising.entity.MutatedZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Mutated Zombie
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class MutatedZombieRenderer extends MobEntityRenderer<MutatedZombieEntity, MutatedZombieModel> {
    private static final Identifier TEXTURE = Identifier.of("yokaiuprising", "textures/entity/mutated_zombie.png");
    
    public MutatedZombieRenderer(EntityRendererFactory.Context context) {
        super(context, new MutatedZombieModel(context.getPart(ModModelLayers.MUTATED_ZOMBIE)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(MutatedZombieEntity entity) {
        return TEXTURE;
    }

}