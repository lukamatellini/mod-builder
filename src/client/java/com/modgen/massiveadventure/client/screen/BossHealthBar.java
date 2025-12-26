package com.modgen.massiveadventure.client.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

import java.util.*;

/**
 * Custom Boss Health Bar - Enhanced boss health display
 * Supports multiple bosses, phases, and custom styling
 */
@Environment(EnvType.CLIENT)
public class BossHealthBar implements HudRenderCallback {
    
    private static final int BAR_WIDTH = 200;
    private static final int BAR_HEIGHT = 12;
    
    // Active boss bars
    private static final Map<UUID, BossBarData> activeBossBars = new LinkedHashMap<>();
    
    private static BossHealthBar INSTANCE;
    
    public static void register() {
        INSTANCE = new BossHealthBar();
        HudRenderCallback.EVENT.register(INSTANCE);
    }
    
    public static void addBossBar(UUID bossId, String name, float health, int color, int phase, int maxPhases) {
        activeBossBars.put(bossId, new BossBarData(name, health, color, phase, maxPhases));
    }
    
    public static void updateBossBar(UUID bossId, float health) {
        BossBarData bar = activeBossBars.get(bossId);
        if (bar != null) {
            bar.health = Math.max(0, Math.min(1, health));
        }
    }
    
    public static void updateBossPhase(UUID bossId, int phase) {
        BossBarData bar = activeBossBars.get(bossId);
        if (bar != null) {
            bar.phase = phase;
        }
    }
    
    public static void removeBossBar(UUID bossId) {
        activeBossBars.remove(bossId);
    }
    
    public static void clearAllBars() {
        activeBossBars.clear();
    }
    
    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) return;
        if (activeBossBars.isEmpty()) return;
        
        int screenWidth = context.getScaledWindowWidth();
        int centerX = (screenWidth - BAR_WIDTH) / 2;
        int y = 10;
        
        for (var entry : activeBossBars.entrySet()) {
            renderBossBar(context, client, centerX, y, entry.getValue());
            y += BAR_HEIGHT + 20;
        }
    }
    
    private void renderBossBar(DrawContext context, MinecraftClient client, int x, int y, BossBarData bar) {
        // Boss name with phase indicator
        String phaseText = bar.maxPhases > 1 ? " [Phase " + bar.phase + "/" + bar.maxPhases + "]" : "";
        Text name = Text.literal("§c§l" + bar.name + "§r" + phaseText);
        int textX = x + (BAR_WIDTH - client.textRenderer.getWidth(name)) / 2;
        context.drawTextWithShadow(client.textRenderer, name, textX, y, 0xFFFFFF);
        
        y += 12;
        
        // Bar background
        context.fill(x - 2, y - 2, x + BAR_WIDTH + 2, y + BAR_HEIGHT + 2, 0xFF000000);
        context.fill(x - 1, y - 1, x + BAR_WIDTH + 1, y + BAR_HEIGHT + 1, 0xFF222222);
        
        // Health fill
        int fillWidth = (int) (BAR_WIDTH * bar.health);
        if (fillWidth > 0) {
            // Base color
            context.fill(x, y, x + fillWidth, y + BAR_HEIGHT, bar.color | 0xFF000000);
            
            // Highlight at top
            int highlightColor = lightenColor(bar.color);
            context.fill(x, y, x + fillWidth, y + 2, highlightColor | 0x66000000);
            
            // Shadow at bottom
            int shadowColor = darkenColor(bar.color);
            context.fill(x, y + BAR_HEIGHT - 2, x + fillWidth, y + BAR_HEIGHT, shadowColor | 0x66000000);
        }
        
        // Phase dividers (if multiple phases)
        if (bar.maxPhases > 1) {
            int phaseWidth = BAR_WIDTH / bar.maxPhases;
            for (int i = 1; i < bar.maxPhases; i++) {
                int divX = x + (phaseWidth * i);
                context.fill(divX - 1, y, divX + 1, y + BAR_HEIGHT, 0xCC000000);
            }
        }
        
        // Health percentage
        String healthText = String.format("%.0f%%", bar.health * 100);
        int percentX = x + (BAR_WIDTH - client.textRenderer.getWidth(healthText)) / 2;
        context.drawTextWithShadow(client.textRenderer, Text.literal(healthText), 
            percentX, y + 2, 0xFFFFFF);
    }
    
    private int lightenColor(int color) {
        int r = Math.min(255, ((color >> 16) & 0xFF) + 60);
        int g = Math.min(255, ((color >> 8) & 0xFF) + 60);
        int b = Math.min(255, (color & 0xFF) + 60);
        return (r << 16) | (g << 8) | b;
    }
    
    private int darkenColor(int color) {
        int r = Math.max(0, ((color >> 16) & 0xFF) - 40);
        int g = Math.max(0, ((color >> 8) & 0xFF) - 40);
        int b = Math.max(0, (color & 0xFF) - 40);
        return (r << 16) | (g << 8) | b;
    }
    
    public static class BossBarData {
        String name;
        float health;
        int color;
        int phase;
        int maxPhases;
        
        BossBarData(String name, float health, int color, int phase, int maxPhases) {
            this.name = name;
            this.health = health;
            this.color = color;
            this.phase = phase;
            this.maxPhases = maxPhases;
        }
    }
}