package com.modgen.shatteredrealms.client.screen;

import com.modgen.shatteredrealms.client.ModClientNetworking;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.*;

@Environment(EnvType.CLIENT)
public class DialogueScreen extends Screen {
    private static final int WINDOW_WIDTH = 320;
    private static final int WINDOW_HEIGHT = 180;
    
    private final String npcName;
    private final List<String> dialogueLines;
    private final List<String> choices;
    
    public DialogueScreen(String npcName, List<String> lines, List<String> choices) {
        super(Text.literal("Dialogue"));
        this.npcName = npcName;
        this.dialogueLines = lines;
        this.choices = choices;
    }
    
    @Override
    protected void init() {
        super.init();
        
        int centerX = (this.width - WINDOW_WIDTH) / 2;
        int centerY = (this.height - WINDOW_HEIGHT) / 2;
        
        // Choice buttons
        int buttonY = centerY + WINDOW_HEIGHT - 30 - (choices.size() * 25);
        for (int i = 0; i < choices.size(); i++) {
            final int choiceIndex = i;
            this.addDrawableChild(ButtonWidget.builder(Text.literal(choices.get(i)), button -> {
                selectChoice(choiceIndex);
            }).dimensions(centerX + 20, buttonY + (i * 25), WINDOW_WIDTH - 40, 20).build());
        }
    }
    
    private void selectChoice(int index) {
        ModClientNetworking.sendDialogueChoice(index);
    }
    
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        
        int centerX = (this.width - WINDOW_WIDTH) / 2;
        int centerY = (this.height - WINDOW_HEIGHT) / 2;
        
        // Background
        context.fill(centerX, centerY, centerX + WINDOW_WIDTH, centerY + WINDOW_HEIGHT, 0xEE222222);
        context.drawBorder(centerX, centerY, WINDOW_WIDTH, WINDOW_HEIGHT, 0xFFFFFFFF);
        
        // NPC name
        context.drawTextWithShadow(this.textRenderer, Text.literal("§e" + npcName), 
            centerX + 15, centerY + 10, 0xFFFFFF);
        
        // Dialogue lines
        int y = centerY + 30;
        for (String line : dialogueLines) {
            // Word wrap
            List<String> wrapped = wrapText(line, WINDOW_WIDTH - 30);
            for (String wrappedLine : wrapped) {
                context.drawTextWithShadow(this.textRenderer, Text.literal(wrappedLine), 
                    centerX + 15, y, 0xFFFFFF);
                y += 12;
            }
            y += 5;
        }
        
        super.render(context, mouseX, mouseY, delta);
    }
    
    private List<String> wrapText(String text, int maxWidth) {
        List<String> lines = new ArrayList<>();
        String[] words = text.split(" ");
        StringBuilder current = new StringBuilder();
        
        for (String word : words) {
            String test = current.length() > 0 ? current + " " + word : word;
            if (this.textRenderer.getWidth(test) <= maxWidth) {
                current = new StringBuilder(test);
            } else {
                if (current.length() > 0) {
                    lines.add(current.toString());
                }
                current = new StringBuilder(word);
            }
        }
        if (current.length() > 0) {
            lines.add(current.toString());
        }
        
        return lines;
    }
    
    @Override
    public boolean shouldPause() {
        return false;
    }
}