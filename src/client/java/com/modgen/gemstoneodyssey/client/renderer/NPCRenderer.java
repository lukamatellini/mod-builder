package com.modgen.gemstoneodyssey.client.renderer;

import com.modgen.gemstoneodyssey.client.ModModelLayers;
import com.modgen.gemstoneodyssey.client.model.NPCModel;
import com.modgen.gemstoneodyssey.entity.ModGenNPCEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

/**
 * Renderer for NPCs
 * Supports dynamic textures based on NPC profession
 */
@Environment(EnvType.CLIENT)
public class NPCRenderer extends MobEntityRenderer<ModGenNPCEntity, NPCModel> {
    private static final Identifier DEFAULT_TEXTURE = Identifier.of("gemstoneodyssey", "textures/entity/npc_default.png");
    
    public NPCRenderer(EntityRendererFactory.Context context) {
        super(context, new NPCModel(context.getPart(ModModelLayers.NPC)), 0.5F);
    }
    
    @Override
    public Identifier getTexture(ModGenNPCEntity entity) {
        // Could return different textures based on entity.getNpcId()
        // For now, use a default texture
        String npcId = entity.getNpcId();
        if (npcId != null && !npcId.isEmpty()) {
            return Identifier.of("gemstoneodyssey", "textures/entity/npc_" + npcId + ".png");
        }
        return DEFAULT_TEXTURE;
    }
    
    @Override
    protected boolean hasLabel(ModGenNPCEntity entity) {
        return true; // Always show NPC name
    }
}