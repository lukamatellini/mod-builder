package com.modgen.luckybreaks.client.renderer;

import com.modgen.luckybreaks.client.ModModelLayers;
import com.modgen.luckybreaks.client.model.ZombieIronArmorModel;
import com.modgen.luckybreaks.entity.ZombieIronArmorEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for Zombie (Iron Armor)
 * Links the entity to its model and texture
 */
@Environment(EnvType.CLIENT)
public class ZombieIronArmorRenderer extends MobEntityRenderer<ZombieIronArmorEntity, ZombieIronArmorModel> {
    private static final Identifier TEXTURE = Identifier.of("luckybreaks", "textures/entity/zombie_iron_armor.png");
    
    public ZombieIronArmorRenderer(EntityRendererFactory.Context context) {
        super(context, new ZombieIronArmorModel(context.getPart(ModModelLayers.ZOMBIE_IRON_ARMOR)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ZombieIronArmorEntity entity) {
        return TEXTURE;
    }

}