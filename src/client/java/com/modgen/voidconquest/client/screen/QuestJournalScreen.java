package com.modgen.voidconquest.client.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.*;

@Environment(EnvType.CLIENT)
public class QuestJournalScreen extends Screen {
    private static final int WINDOW_WIDTH = 280;
    private static final int WINDOW_HEIGHT = 200;
    
    private List<QuestDisplayData> activeQuests = new ArrayList<>();
    private List<QuestDisplayData> completedQuests = new ArrayList<>();
    private int selectedTab = 0;
    
    public QuestJournalScreen() {
        super(Text.literal("Quest Journal"));
    }
    
    public void setQuestData(List<QuestDisplayData> active, List<QuestDisplayData> completed) {
        this.activeQuests = active;
        this.completedQuests = completed;
    }
    
    @Override
    protected void init() {
        super.init();
        
        int centerX = (this.width - WINDOW_WIDTH) / 2;
        int centerY = (this.height - WINDOW_HEIGHT) / 2;
        
        // Tab buttons
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Active"), button -> {
            selectedTab = 0;
        }).dimensions(centerX + 10, centerY + 30, 80, 20).build());
        
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Completed"), button -> {
            selectedTab = 1;
        }).dimensions(centerX + 100, centerY + 30, 80, 20).build());
        
        // Close button
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> {
            this.close();
        }).dimensions(centerX + WINDOW_WIDTH - 70, centerY + WINDOW_HEIGHT - 30, 60, 20).build());
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        int centerX = (this.width - WINDOW_WIDTH) / 2;
        int centerY = (this.height - WINDOW_HEIGHT) / 2;
        
        // Background
        context.fill(centerX, centerY, centerX + WINDOW_WIDTH, centerY + WINDOW_HEIGHT, 0xDD000000);
        context.drawBorder(centerX, centerY, WINDOW_WIDTH, WINDOW_HEIGHT, 0xFFFFD700);
        
        // Title
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, centerY + 10, 0xFFD700);
        
        // Quest list
        List<QuestDisplayData> quests = selectedTab == 0 ? activeQuests : completedQuests;
        int y = centerY + 60;
        
        if (quests.isEmpty()) {
            context.drawCenteredTextWithShadow(this.textRenderer, 
                Text.literal(selectedTab == 0 ? "No active quests" : "No completed quests"),
                this.width / 2, y, 0x888888);
        } else {
            for (QuestDisplayData quest : quests) {
                context.drawTextWithShadow(this.textRenderer, Text.literal("• " + quest.name), 
                    centerX + 15, y, selectedTab == 0 ? 0xFFFFFF : 0x88FF88);
                y += 12;
                
                if (selectedTab == 0 && quest.progress != null) {
                    context.drawTextWithShadow(this.textRenderer, Text.literal("  " + quest.progress), 
                        centerX + 20, y, 0xAAAAAA);
                    y += 12;
                }
                y += 5;
            }
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
    
    public static class QuestDisplayData {
        public String id;
        public String name;
        public String progress;
        
        public QuestDisplayData(String id, String name, String progress) {
            this.id = id;
            this.name = name;
            this.progress = progress;
        }
    }
}