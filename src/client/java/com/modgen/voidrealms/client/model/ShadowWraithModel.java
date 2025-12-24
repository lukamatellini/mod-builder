package com.modgen.voidrealms.client.model;

import com.modgen.voidrealms.entity.ShadowWraithEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Entity model for Shadow Wraith
 * Body type: humanoid
 */
@Environment(EnvType.CLIENT)
public class ShadowWraithModel extends EntityModel<ShadowWraithEntity> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightArm;
    private final ModelPart leftArm;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    
    public ShadowWraithModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
    }
    
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        
        // Head - 8x8x8 at top
        modelPartData.addChild("head", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), 
            ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        
        // Body - 8x12x4 below head
        modelPartData.addChild("body", ModelPartBuilder.create()
            .uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        
        // Right arm - 4x12x4
        modelPartData.addChild("right_arm", ModelPartBuilder.create()
            .uv(40, 16).cuboid(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        
        // Left arm - 4x12x4
        modelPartData.addChild("left_arm", ModelPartBuilder.create()
            .uv(40, 16).mirrored().cuboid(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        
        // Right leg - 4x12x4
        modelPartData.addChild("right_leg", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(-1.9F, 12.0F, 0.0F));
        
        // Left leg - 4x12x4
        modelPartData.addChild("left_leg", ModelPartBuilder.create()
            .uv(0, 16).mirrored().cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        
        return TexturedModelData.of(modelData, 64, 64);
    }
    
    @Override
    public void setAngles(ShadowWraithEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Head rotation
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        
        // Walking animation
        this.rightArm.pitch = (float) Math.cos(limbAngle * 0.6662F + 3.1415927F) * 2.0F * limbDistance * 0.5F;
        this.leftArm.pitch = (float) Math.cos(limbAngle * 0.6662F) * 2.0F * limbDistance * 0.5F;
        this.rightLeg.pitch = (float) Math.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        this.leftLeg.pitch = (float) Math.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.head.render(matrices, vertices, light, overlay, color);
        this.body.render(matrices, vertices, light, overlay, color);
        this.rightArm.render(matrices, vertices, light, overlay, color);
        this.leftArm.render(matrices, vertices, light, overlay, color);
        this.rightLeg.render(matrices, vertices, light, overlay, color);
        this.leftLeg.render(matrices, vertices, light, overlay, color);
    }
}