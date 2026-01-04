package com.modgen.speedboots.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * HUD Overlay System for Speed Boots
 * Renders quest progress, mana bars, and status effects on screen
 * without opening any GUI
 */
@Environment(EnvType.CLIENT)
public class ModHudOverlay implements HudRenderCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger("speedboots/hud");
    
    // HUD positioning constants
    private static final int PADDING = 10;
    private static final int LINE_HEIGHT = 12;
    private static final int BAR_WIDTH = 80;
    private static final int BAR_HEIGHT = 8;
    
    // Mana system state (synced from server)
    private static float currentMana = 100.0f;
    private static float maxMana = 100.0f;
    
    // Active quest tracking
    private static String activeQuestName = "";
    private static String activeQuestObjective = "";
    private static float questProgress = 0.0f;
    
    // Custom texture for HUD elements
    private static final Identifier HUD_ICONS = Identifier.of("speedboots", "textures/gui/hud_icons.png");
    
    /**
     * Register the HUD overlay callback
     * Called from client entrypoint
     */
    public static void register() {
        LOGGER.info("Registering HUD overlay...");
        HudRenderCallback.EVENT.register(new ModHudOverlay());
        LOGGER.info("HUD overlay registered");
    }
    
    @Override
    public void onHudRender(DrawContext context, RenderTickCounter tickCounter) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null || client.options.hudHidden) {
            return;
        }
        
        // Don't render HUD when a screen is open
        if (client.currentScreen != null) {
            return;
        }
        
        int screenWidth = client.getWindow().getScaledWidth();
        int screenHeight = client.getWindow().getScaledHeight();
        TextRenderer textRenderer = client.textRenderer;
        
        int yOffset = PADDING;
        


        // === CUSTOM STATUS EFFECTS ===
        renderStatusEffects(context, textRenderer, screenWidth, screenHeight);

    }



    /**
     * Render custom status effects in bottom-right corner
     */
    private void renderStatusEffects(DrawContext context, TextRenderer textRenderer, int screenWidth, int screenHeight) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;
        
        Collection<StatusEffectInstance> effects = client.player.getStatusEffects();
        if (effects.isEmpty()) return;
        
        int x = screenWidth - PADDING - 24;
        int y = screenHeight - PADDING - 24;
        int effectCount = 0;
        
        for (StatusEffectInstance effect : effects) {
            // Only render effects with remaining time
            if (!effect.isInfinite() || effect.getDuration() > 0) {
                // Background box for effect
                context.fill(x - 2, y - 2, x + 22, y + 22, 0x80000000);
                
                // Draw effect icon (using vanilla sprite system)
                Identifier effectId = net.minecraft.registry.Registries.STATUS_EFFECT.getId(effect.getEffectType().value());
                if (effectId != null) {
                    // Render amplifier if > 0
                    if (effect.getAmplifier() > 0) {
                        String amp = String.valueOf(effect.getAmplifier() + 1);
                        context.drawText(textRenderer, Text.literal(amp), x + 14, y + 14, 0xFFFFFF, true);
                    }
                    
                    // Duration text
                    if (!effect.isInfinite()) {
                        int seconds = effect.getDuration() / 20;
                        String duration = seconds < 60 ? seconds + "s" : (seconds / 60) + "m";
                        context.drawText(textRenderer, Text.literal(duration), x, y + 24, 0xAAAAAA, true);
                    }
                }
                
                effectCount++;
                // Stack effects vertically, then wrap to new column
                if (effectCount % 5 == 0) {
                    x -= 30;
                    y = screenHeight - PADDING - 24;
                } else {
                    y -= 30;
                }
            }
        }
    }


}