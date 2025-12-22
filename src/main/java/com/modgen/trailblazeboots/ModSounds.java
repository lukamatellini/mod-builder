package com.modgen.trailblazeboots;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent UI_CLICK = registerSound("ui_click");
    public static final SoundEvent QUEST_COMPLETE = registerSound("quest_complete");
    public static final SoundEvent NPC_GREET = registerSound("npc_greet");
    
    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of(TrailblazeBoots.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    
    public static void registerSounds() {
        TrailblazeBoots.LOGGER.info("Registered sounds for " + TrailblazeBoots.MOD_ID);
    }
}