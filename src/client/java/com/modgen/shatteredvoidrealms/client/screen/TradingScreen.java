package com.modgen.shatteredvoidrealms.client.screen;

import com.modgen.shatteredvoidrealms.client.ModClientNetworking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.*;

/**
 * Trading Screen - NPC shop interface
 * Displays available trades, costs, and allows purchasing
 */
@Environment(EnvType.CLIENT)
public class TradingScreen extends Screen {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 240;
    
    private final String merchantName;
    private final List<TradeDisplayData> trades;
    private int selectedTrade = -1;
    private int scrollOffset = 0;
    private static final int TRADES_PER_PAGE = 5;
    
    public TradingScreen(String merchantName, List<TradeDisplayData> trades) {
        super(Text.literal("Trade"));
        this.merchantName = merchantName;
        this.trades = trades != null ? trades : new ArrayList<>();
    }
    
    @Override
    protected void init() {
        super.init();
        
        int centerX = (this.width - WINDOW_WIDTH) / 2;
        int centerY = (this.height - WINDOW_HEIGHT) / 2;
        
        // Close button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> {
            this.close();
        }).dimensions(centerX + WINDOW_WIDTH - 70, centerY + WINDOW_HEIGHT - 30, 60, 20).build());
        
        // Buy button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Buy"), button -> {
            if (selectedTrade >= 0 && selectedTrade < trades.size()) {
                ModClientNetworking.sendExecuteTrade(selectedTrade);
            }
        }).dimensions(centerX + 10, centerY + WINDOW_HEIGHT - 30, 80, 20).build());
        
        // Scroll buttons
        this.addDrawableChild(ButtonWidget.builder(Text.literal("▲"), button -> {
            if (scrollOffset > 0) scrollOffset--;
        }).dimensions(centerX + WINDOW_WIDTH - 25, centerY + 55, 20, 15).build());
        
        this.addDrawableChild(ButtonWidget.builder(Text.literal("▼"), button -> {
            if (scrollOffset + TRADES_PER_PAGE < trades.size()) scrollOffset++;
        }).dimensions(centerX + WINDOW_WIDTH - 25, centerY + WINDOW_HEIGHT - 55, 20, 15).build());
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        int centerX = (this.width - WINDOW_WIDTH) / 2;
        int centerY = (this.height - WINDOW_HEIGHT) / 2;
        
        // Main background
        context.fill(centerX, centerY, centerX + WINDOW_WIDTH, centerY + WINDOW_HEIGHT, 0xEE1A1A1A);
        context.drawBorder(centerX, centerY, WINDOW_WIDTH, WINDOW_HEIGHT, 0xFFD4AF37);
        
        // Header
        context.fill(centerX + 1, centerY + 1, centerX + WINDOW_WIDTH - 1, centerY + 25, 0xFF2A2A2A);
        context.drawCenteredTextWithShadow(this.textRenderer, 
            Text.literal("§6" + merchantName + "'s Trades"), this.width / 2, centerY + 8, 0xFFFFFF);
        
        // Divider
        context.fill(centerX + 10, centerY + 50, centerX + WINDOW_WIDTH - 30, centerY + 51, 0xFF555555);
        
        // Trade list
        int y = centerY + 55;
        int endIndex = Math.min(scrollOffset + TRADES_PER_PAGE, trades.size());
        
        for (int i = scrollOffset; i < endIndex; i++) {
            TradeDisplayData trade = trades.get(i);
            boolean isSelected = (i == selectedTrade);
            boolean canAfford = trade.canAfford;
            
            // Trade row background
            int rowColor = isSelected ? 0xFF3A3A5A : (i % 2 == 0 ? 0xFF2A2A2A : 0xFF252525);
            context.fill(centerX + 10, y, centerX + WINDOW_WIDTH - 35, y + 28, rowColor);
            
            // Selection indicator
            if (isSelected) {
                context.drawBorder(centerX + 10, y, WINDOW_WIDTH - 45, 28, 0xFF6666FF);
            }
            
            // Item name
            int textColor = canAfford ? 0xFFFFFF : 0xFF888888;
            context.drawTextWithShadow(this.textRenderer, Text.literal(trade.outputName), 
                centerX + 15, y + 4, textColor);
            
            // Cost display
            String costText = formatCost(trade);
            int costColor = canAfford ? 0xFF88FF88 : 0xFFFF6666;
            context.drawTextWithShadow(this.textRenderer, Text.literal(costText), 
                centerX + 15, y + 16, costColor);
            
            // Stock display (right side)
            if (trade.stock >= 0) {
                String stockText = trade.stock > 0 ? "Stock: " + trade.stock : "§cOut of Stock";
                int stockColor = trade.stock > 0 ? 0xFFAAAA : 0xFF6666;
                int stockX = centerX + WINDOW_WIDTH - 90;
                context.drawTextWithShadow(this.textRenderer, Text.literal(stockText), 
                    stockX, y + 10, stockColor);
            }
            
            y += 32;
        }
        
        // Empty state
        if (trades.isEmpty()) {
            context.drawCenteredTextWithShadow(this.textRenderer, 
                Text.literal("§7No trades available"), this.width / 2, centerY + 100, 0xAAAAAA);
        }
        
        // Selected trade details
        if (selectedTrade >= 0 && selectedTrade < trades.size()) {
            TradeDisplayData trade = trades.get(selectedTrade);
            int detailY = centerY + WINDOW_HEIGHT - 55;
            context.fill(centerX + 10, detailY - 5, centerX + WINDOW_WIDTH - 100, detailY + 20, 0xFF333333);
            context.drawTextWithShadow(this.textRenderer, 
                Text.literal("§eSelected: §f" + trade.outputName + " x" + trade.outputCount), 
                centerX + 15, detailY, 0xFFFFFF);
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    private String formatCost(TradeDisplayData trade) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < trade.inputNames.size(); i++) {
            if (i > 0) sb.append(" + ");
            sb.append(trade.inputCounts.get(i)).append("x ").append(trade.inputNames.get(i));
        }
        return sb.toString();
    }
    
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (button == 0) {
            int centerX = (this.width - WINDOW_WIDTH) / 2;
            int centerY = (this.height - WINDOW_HEIGHT) / 2;
            
            // Check if clicking on a trade row
            int y = centerY + 55;
            int endIndex = Math.min(scrollOffset + TRADES_PER_PAGE, trades.size());
            
            for (int i = scrollOffset; i < endIndex; i++) {
                if (mouseX >= centerX + 10 && mouseX <= centerX + WINDOW_WIDTH - 35 &&
                    mouseY >= y && mouseY <= y + 28) {
                    selectedTrade = i;
                    return true;
                }
                y += 32;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }
    
    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
        if (verticalAmount > 0 && scrollOffset > 0) {
            scrollOffset--;
            return true;
        } else if (verticalAmount < 0 && scrollOffset + TRADES_PER_PAGE < trades.size()) {
            scrollOffset++;
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
    
    /**
     * Trade display data received from server
     */
    public static class TradeDisplayData {
        public final String tradeId;
        public final String outputName;
        public final int outputCount;
        public final List<String> inputNames;
        public final List<Integer> inputCounts;
        public final int stock;
        public final boolean canAfford;
        public final int requiredReputation;
        
        public TradeDisplayData(String tradeId, String outputName, int outputCount, 
                               List<String> inputNames, List<Integer> inputCounts,
                               int stock, boolean canAfford, int requiredReputation) {
            this.tradeId = tradeId;
            this.outputName = outputName;
            this.outputCount = outputCount;
            this.inputNames = inputNames;
            this.inputCounts = inputCounts;
            this.stock = stock;
            this.canAfford = canAfford;
            this.requiredReputation = requiredReputation;
        }
    }
}