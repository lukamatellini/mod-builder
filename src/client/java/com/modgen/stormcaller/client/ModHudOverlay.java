package com.modgen.stormcaller.client;

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
 * HUD Overlay System for Storm Caller
 * Renders quest progress, mana bars, and status effects on screen
 * without opening any GUI
 */
@Environment(EnvType.CLIENT)
public class ModHudOverlay implements HudRenderCallback {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormcaller/hud");
    
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
    private static final Identifier HUD_ICONS = Identifier.of("stormcaller", "textures/gui/hud_icons.png");
    
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
        

        // === MANA BAR ===
        yOffset = renderManaBar(context, textRenderer, screenWidth, yOffset);


    }


    /**
     * Render mana bar below quest progress
     */
    private int renderManaBar(DrawContext context, TextRenderer textRenderer, int screenWidth, int yOffset) {
        int x = screenWidth - PADDING - 150;
        
        // Mana label
        context.drawText(textRenderer, Text.literal("§bMana"), x, yOffset, 0x55FFFF, true);
        yOffset += LINE_HEIGHT;
        
        // Mana bar
        int barX = x;
        int barY = yOffset;
        float manaPercent = maxMana > 0 ? currentMana / maxMana : 0;
        int filledWidth = (int)(BAR_WIDTH * manaPercent);
        
        // Background
        context.fill(barX, barY, barX + BAR_WIDTH, barY + BAR_HEIGHT, 0xFF333333);
        // Filled portion (cyan/blue gradient effect)
        if (filledWidth > 0) {
            context.fill(barX, barY, barX + filledWidth, barY + BAR_HEIGHT, 0xFF00AAFF);
        }
        // Border
        context.drawBorder(barX, barY, BAR_WIDTH, BAR_HEIGHT, 0xFF666666);
        
        // Mana value text
        String manaText = String.format("%.0f/%.0f", currentMana, maxMana);
        context.drawText(textRenderer, Text.literal(manaText), barX + BAR_WIDTH + 4, barY, 0x55FFFF, true);
        
        return yOffset + BAR_HEIGHT + PADDING;
    }
    
    /**
     * Update mana values (called from server sync)
     */
    public static void setMana(float current, float max) {
        currentMana = current;
        maxMana = max;
    }
    
    /**
     * Consume mana if available
     * @return true if mana was consumed, false if insufficient
     */
    public static boolean consumeMana(float amount) {
        if (currentMana >= amount) {
            currentMana -= amount;
            return true;
        }
        return false;
    }
    
    /**
     * Regenerate mana over time
     */
    public static void regenerateMana(float amount) {
        currentMana = Math.min(currentMana + amount, maxMana);
    }



}