package com.modgen.epicadventure.client.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.*;

/**
 * Progress Bar HUD - Renders custom progress bars on the client screen
 * Used for quest progress, ability cooldowns, event timers, etc.
 */
@Environment(EnvType.CLIENT)
public class ProgressBarHud implements HudRenderCallback {
    
    private static final int BAR_WIDTH = 120;
    private static final int BAR_HEIGHT = 8;
    private static final int PADDING = 5;
    
    // Active progress bars to display
    private static final List<ProgressBarData> activeBars = new ArrayList<>();
    
    // Singleton instance
    private static ProgressBarHud INSTANCE;
    
    public static void register() {
        INSTANCE = new ProgressBarHud();
        HudRenderCallback.EVENT.register(INSTANCE);
    }
    
    public static void addProgressBar(String id, String label, float progress, int color, int durationTicks) {
        // Remove existing bar with same ID
        activeBars.removeIf(bar -> bar.id.equals(id));
        activeBars.add(new ProgressBarData(id, label, progress, color, durationTicks, System.currentTimeMillis()));
    }
    
    public static void updateProgressBar(String id, float progress) {
        for (ProgressBarData bar : activeBars) {
            if (bar.id.equals(id)) {
                bar.progress = Math.max(0, Math.min(1, progress));
                break;
            }
        }
    }
    
    public static void removeProgressBar(String id) {
        activeBars.removeIf(bar -> bar.id.equals(id));
    }
    
    public static void clearAllBars() {
        activeBars.clear();
    }
    
    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) return;
        
        // Clean up expired bars
        long now = System.currentTimeMillis();
        activeBars.removeIf(bar -> bar.durationTicks > 0 && 
            (now - bar.startTime) > (bar.durationTicks * 50L));
        
        if (activeBars.isEmpty()) return;
        
        int screenWidth = context.getScaledWindowWidth();
        int screenHeight = context.getScaledWindowHeight();
        
        // Render bars in top-right corner
        int x = screenWidth - BAR_WIDTH - PADDING - 10;
        int y = PADDING + 30; // Below boss bar area
        
        for (ProgressBarData bar : activeBars) {
            renderProgressBar(context, client, x, y, bar);
            y += BAR_HEIGHT + PADDING + 12; // Space for label
        }
    }
    
    private void renderProgressBar(DrawContext context, MinecraftClient client, int x, int y, ProgressBarData bar) {
        // Label above bar
        context.drawTextWithShadow(client.textRenderer, Text.literal(bar.label), 
            x, y - 10, 0xFFFFFF);
        
        // Background
        context.fill(x - 1, y - 1, x + BAR_WIDTH + 1, y + BAR_HEIGHT + 1, 0xFF000000);
        context.fill(x, y, x + BAR_WIDTH, y + BAR_HEIGHT, 0xFF333333);
        
        // Progress fill
        int fillWidth = (int) (BAR_WIDTH * bar.progress);
        if (fillWidth > 0) {
            context.fill(x, y, x + fillWidth, y + BAR_HEIGHT, bar.color | 0xFF000000);
            
            // Gradient overlay for shine effect
            int shineColor = lightenColor(bar.color) | 0x44000000;
            context.fill(x, y, x + fillWidth, y + 2, shineColor);
        }
        
        // Percentage text
        String percentage = String.format("%.0f%%", bar.progress * 100);
        int textX = x + (BAR_WIDTH - client.textRenderer.getWidth(percentage)) / 2;
        context.drawTextWithShadow(client.textRenderer, Text.literal(percentage), 
            textX, y, 0xFFFFFF);
    }
    
    private int lightenColor(int color) {
        int r = Math.min(255, ((color >> 16) & 0xFF) + 50);
        int g = Math.min(255, ((color >> 8) & 0xFF) + 50);
        int b = Math.min(255, (color & 0xFF) + 50);
        return (r << 16) | (g << 8) | b;
    }
    
    public static class ProgressBarData {
        String id;
        String label;
        float progress;
        int color;
        int durationTicks;
        long startTime;
        
        ProgressBarData(String id, String label, float progress, int color, int durationTicks, long startTime) {
            this.id = id;
            this.label = label;
            this.progress = progress;
            this.color = color;
            this.durationTicks = durationTicks;
            this.startTime = startTime;
        }
    }
}