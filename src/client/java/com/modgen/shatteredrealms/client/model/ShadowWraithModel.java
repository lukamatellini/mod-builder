package com.modgen.shatteredrealms.client.model;

import com.modgen.shatteredrealms.entity.ShadowWraithEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

/**
 * Entity model for Shadow Wraith
 * Body type: flying
 */
@Environment(EnvType.CLIENT)
public class ShadowWraithModel extends EntityModel<ShadowWraithEntity> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    
    public ShadowWraithModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightWing = root.getChild("right_wing");
        this.leftWing = root.getChild("left_wing");
    }
    
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        
        // Head
        modelPartData.addChild("head", ModelPartBuilder.create()
            .uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F), 
            ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        
        // Body
        modelPartData.addChild("body", ModelPartBuilder.create()
            .uv(0, 16).cuboid(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F), 
            ModelTransform.pivot(0.0F, 4.0F, 0.0F));
        
        // Wings
        modelPartData.addChild("right_wing", ModelPartBuilder.create()
            .uv(24, 16).cuboid(0.0F, 0.0F, 0.0F, 12.0F, 1.0F, 8.0F), 
            ModelTransform.pivot(3.0F, 5.0F, 0.0F));
        
        modelPartData.addChild("left_wing", ModelPartBuilder.create()
            .uv(24, 16).mirrored().cuboid(-12.0F, 0.0F, 0.0F, 12.0F, 1.0F, 8.0F), 
            ModelTransform.pivot(-3.0F, 5.0F, 0.0F));
        
        return TexturedModelData.of(modelData, 64, 64);
    }
    
    @Override
    public void setAngles(ShadowWraithEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Head rotation
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
        
        // Wing flapping animation
        float wingAngle = (float) Math.sin(animationProgress * 0.3F) * 0.4F;
        this.rightWing.roll = wingAngle;
        this.leftWing.roll = -wingAngle;
    }
    
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        this.head.render(matrices, vertices, light, overlay, color);
        this.body.render(matrices, vertices, light, overlay, color);
        this.rightWing.render(matrices, vertices, light, overlay, color);
        this.leftWing.render(matrices, vertices, light, overlay, color);
    }
}