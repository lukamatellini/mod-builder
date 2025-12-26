package com.modgen.voidconquest.client.model;

import com.modgen.voidconquest.entity.ModGenNPCEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Model for NPCs - Villager-like humanoid with robes
 */
@Environment(EnvType.CLIENT)
public class NPCModel extends EntityModel<ModGenNPCEntity> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart arms;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart nose;
    
    public NPCModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.arms = root.getChild("arms");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.nose = this.head.getChild("nose");
    }
    
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        
        // Head with hat
        ModelPartData headData = modelPartData.addChild("head", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F), 
            ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        
        // Nose (villager characteristic)
        headData.addChild("nose", ModelPartBuilder.create()
            .uv(24, 0).cuboid(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F), 
            ModelTransform.pivot(0.0F, -2.0F, 0.0F));
        
        // Body (long robe)
        modelPartData.addChild("body", ModelPartBuilder.create()
            .uv(16, 20).cuboid(-4.0F, 0.0F, -3.0F, 8.0F, 12.0F, 6.0F)
            .uv(0, 38).cuboid(-4.0F, 12.0F, -3.0F, 8.0F, 8.0F, 6.0F), 
            ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        
        // Arms (crossed)
        modelPartData.addChild("arms", ModelPartBuilder.create()
            .uv(40, 38).cuboid(-4.0F, 2.0F, -2.0F, 8.0F, 4.0F, 4.0F)
            .uv(44, 22).cuboid(-8.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F)
            .uv(44, 22).mirrored().cuboid(4.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F), 
            ModelTransform.of(0.0F, 3.0F, -1.0F, -0.75F, 0.0F, 0.0F));
        
        // Legs (hidden by robe)
        modelPartData.addChild("right_leg", ModelPartBuilder.create()
            .uv(0, 22).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(-2.0F, 12.0F, 0.0F));
        
        modelPartData.addChild("left_leg", ModelPartBuilder.create()
            .uv(0, 22).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(2.0F, 12.0F, 0.0F));
        
        return TexturedModelData.of(modelData, 64, 64);
    }
    
    @Override
    public void setAngles(ModGenNPCEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Head looks at player
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        
        // Subtle idle animation
        this.arms.pitch = -0.75F + (float) Math.sin(animationProgress * 0.1F) * 0.05F;
        
        // Walking animation
        this.rightLeg.pitch = (float) Math.cos(limbAngle * 0.6662F) * 1.0F * limbDistance;
        this.leftLeg.pitch = (float) Math.cos(limbAngle * 0.6662F + 3.1415927F) * 1.0F * limbDistance;
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.head.render(matrices, vertices, light, overlay, color);
        this.body.render(matrices, vertices, light, overlay, color);
        this.arms.render(matrices, vertices, light, overlay, color);
        this.rightLeg.render(matrices, vertices, light, overlay, color);
        this.leftLeg.render(matrices, vertices, light, overlay, color);
    }
}