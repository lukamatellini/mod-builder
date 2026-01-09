package com.modgen.dragonsheir.npc;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PirateCaptainNPC {
    public static final String NAME = "Captain 'Redbeard' Morgan";
    public static final String TITLE = "";
    
    private static final String[] DIALOGUES = {
        "Hello, traveler! I am Captain 'Redbeard' Morgan."
    };
    
    public static void onInteract(PlayerEntity player) {
        if (!player.getWorld().isClient) {
            int dialogueIndex = player.getWorld().random.nextInt(DIALOGUES.length);
            player.sendMessage(Text.literal("§e[Captain 'Redbeard' Morgan]§r " + DIALOGUES[dialogueIndex]), false);
        }
    }
}