package com.modgen.dragonsheir.npc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WizardMerchantNPC {
    public static final String NAME = "Elara the Enchanter";
    public static final String TITLE = "";
    
    private static final String[] DIALOGUES = {
        "Hello, traveler! I am Elara the Enchanter."
    };
    
    public static void onInteract(PlayerEntity player) {
        if (!player.getWorld().isClient) {
            int dialogueIndex = player.getWorld().random.nextInt(DIALOGUES.length);
            player.sendMessage(Text.literal("§e[Elara the Enchanter]§r " + DIALOGUES[dialogueIndex]), false);
        }
    }
}