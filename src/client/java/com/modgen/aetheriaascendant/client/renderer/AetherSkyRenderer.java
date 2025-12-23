package com.modgen.aetheriaascendant.client.renderer;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

/**
 * Custom sky renderer for the The Aether dimension
 * Renders themed sky, sun, moon, and atmospheric effects
 */
public class AetherSkyRenderer {
    
    private static final Identifier SKY_TEXTURE = Identifier.of("aetheriaascendant", "textures/environment/aether_sky.png");
    private static final Identifier SUN_TEXTURE = Identifier.of("aetheriaascendant", "textures/environment/aether_sun.png");
    private static final Identifier MOON_TEXTURE = Identifier.of("aetheriaascendant", "textures/environment/aether_moon.png");
    
    // Theme colors (RGB 0-1)
    private static final float SKY_R = 0.392f;
    private static final float SKY_G = 0.588f;
    private static final float SKY_B = 0.784f;
    
    private static final float HORIZON_R = 0.706f;
    private static final float HORIZON_G = 0.784f;
    private static final float HORIZON_B = 0.863f;
    
    private static final float FOG_R = 0.627f;
    private static final float FOG_G = 0.706f;
    private static final float FOG_B = 0.784f;
    
    /**
     * Render the custom sky for this dimension
     */
    public static void render(MatrixStack matrices, Matrix4f projectionMatrix, float tickDelta, Runnable fogCallback) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientWorld world = client.world;
        if (world == null) return;
        
        // Clear depth and set up rendering
        RenderSystem.depthMask(false);
        
        // Calculate time-based effects
        float timeOfDay = world.getSkyAngle(tickDelta);
        float dayNightBlend = getDayNightBlend(timeOfDay);
        
        // Render sky gradient
        renderSkyGradient(matrices, projectionMatrix, dayNightBlend);
        
        // Render celestial bodies
        if (true) {
            renderCelestialBodies(matrices, projectionMatrix, timeOfDay, tickDelta);
        }
        
        // Apply fog
        fogCallback.run();
        
        RenderSystem.depthMask(true);
    }
    
    /**
     * Render the sky gradient from zenith to horizon
     */
    private static void renderSkyGradient(MatrixStack matrices, Matrix4f projectionMatrix, float dayNightBlend) {
        // Calculate blended colors
        float r = MathHelper.lerp(dayNightBlend, SKY_R * 0.2f, SKY_R);
        float g = MathHelper.lerp(dayNightBlend, SKY_G * 0.2f, SKY_G);
        float b = MathHelper.lerp(dayNightBlend, SKY_B * 0.2f, SKY_B);
        
        // Set fog color
        RenderSystem.setShaderFogColor(FOG_R, FOG_G, FOG_B);
        
        // The actual gradient is rendered by the vanilla sky renderer
        // We just set the colors here
        RenderSystem.setShaderColor(r, g, b, 1.0f);
    }
    
    /**
     * Render sun and moon
     */
    private static void renderCelestialBodies(MatrixStack matrices, Matrix4f projectionMatrix, float timeOfDay, float tickDelta) {
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        
        matrices.push();
        
        // Rotate based on time of day
        float rotation = timeOfDay * 360.0f;
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90.0f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rotation));
        
        Matrix4f matrix = matrices.peek().getPositionMatrix();
        float size = 30.0f;
        
        // Render sun
        RenderSystem.setShaderTexture(0, SUN_TEXTURE);
        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX);
        
        BufferBuilder bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix, -size, 100.0f, -size).texture(0.0f, 0.0f);
        bufferBuilder.vertex(matrix, size, 100.0f, -size).texture(1.0f, 0.0f);
        bufferBuilder.vertex(matrix, size, 100.0f, size).texture(1.0f, 1.0f);
        bufferBuilder.vertex(matrix, -size, 100.0f, size).texture(0.0f, 1.0f);
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
        
        // Render moon (opposite side)
        RenderSystem.setShaderTexture(0, MOON_TEXTURE);
        size = 20.0f;
        
        bufferBuilder = Tessellator.getInstance().begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION_TEXTURE);
        bufferBuilder.vertex(matrix, -size, -100.0f, size).texture(0.0f, 0.0f);
        bufferBuilder.vertex(matrix, size, -100.0f, size).texture(1.0f, 0.0f);
        bufferBuilder.vertex(matrix, size, -100.0f, -size).texture(1.0f, 1.0f);
        bufferBuilder.vertex(matrix, -size, -100.0f, -size).texture(0.0f, 1.0f);
        BufferRenderer.drawWithGlobalProgram(bufferBuilder.end());
        
        matrices.pop();
        
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.disableBlend();
    }
    
    /**
     * Get day/night blend factor (0 = night, 1 = day)
     */
    private static float getDayNightBlend(float timeOfDay) {
        float adjusted = timeOfDay - 0.25f;
        if (adjusted < 0) adjusted += 1.0f;
        
        if (adjusted < 0.5f) {
            // Day
            return 1.0f;
        } else if (adjusted < 0.55f) {
            // Sunset transition
            return 1.0f - (adjusted - 0.5f) * 20.0f;
        } else if (adjusted < 0.95f) {
            // Night
            return 0.0f;
        } else {
            // Sunrise transition
            return (adjusted - 0.95f) * 20.0f;
        }
    }
    
    /**
     * Get the fog color for this dimension
     */
    public static int getFogColor() {
        return ((int)(FOG_R * 255) << 16) | ((int)(FOG_G * 255) << 8) | (int)(FOG_B * 255);
    }
    
    /**
     * Get the sky color for this dimension
     */
    public static int getSkyColor() {
        return ((int)(SKY_R * 255) << 16) | ((int)(SKY_G * 255) << 8) | (int)(SKY_B * 255);
    }
}