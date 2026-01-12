package com.modgen.cheesycraft.client.model;

import com.modgen.cheesycraft.entity.MouseEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Entity model for Mouse
 * Body type: quadruped
 */
@Environment(EnvType.CLIENT)
public class MouseModel extends EntityModel<MouseEntity> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart rightBackLeg;
    private final ModelPart leftBackLeg;
    
    public MouseModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightFrontLeg = root.getChild("right_front_leg");
        this.leftFrontLeg = root.getChild("left_front_leg");
        this.rightBackLeg = root.getChild("right_back_leg");
        this.leftBackLeg = root.getChild("left_back_leg");
    }
    
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        
        // Head
        modelPartData.addChild("head", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F), 
            ModelTransform.pivot(0.0F, 6.0F, -8.0F));
        
        // Body
        modelPartData.addChild("body", ModelPartBuilder.create()
            .uv(28, 8).cuboid(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F), 
            ModelTransform.of(0.0F, 11.0F, 2.0F, 1.5707964F, 0.0F, 0.0F));
        
        // Legs
        modelPartData.addChild("right_front_leg", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(-3.0F, 12.0F, -5.0F));
        
        modelPartData.addChild("left_front_leg", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(3.0F, 12.0F, -5.0F));
        
        modelPartData.addChild("right_back_leg", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(-3.0F, 12.0F, 7.0F));
        
        modelPartData.addChild("left_back_leg", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), 
            ModelTransform.pivot(3.0F, 12.0F, 7.0F));
        
        return TexturedModelData.of(modelData, 64, 64);
    }
    
    @Override
    public void setAngles(MouseEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Head rotation
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        
        // Walking animation for quadruped
        this.rightFrontLeg.pitch = (float) Math.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        this.leftFrontLeg.pitch = (float) Math.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
        this.rightBackLeg.pitch = (float) Math.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
        this.leftBackLeg.pitch = (float) Math.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.head.render(matrices, vertices, light, overlay, color);
        this.body.render(matrices, vertices, light, overlay, color);
        this.rightFrontLeg.render(matrices, vertices, light, overlay, color);
        this.leftFrontLeg.render(matrices, vertices, light, overlay, color);
        this.rightBackLeg.render(matrices, vertices, light, overlay, color);
        this.leftBackLeg.render(matrices, vertices, light, overlay, color);
    }
}