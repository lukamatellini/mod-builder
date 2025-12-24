package com.modgen.shatteredrealmsreviv;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent UI_CLICK = registerSound("ui_click");
    public static final SoundEvent QUEST_COMPLETE = registerSound("quest_complete");
    public static final SoundEvent NPC_GREET = registerSound("npc_greet");
    
    private static SoundEvent registerSound(String name) {
        Identifier id = Identifier.of(ShatteredRealmsRevival.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
    
    public static void registerSounds() {
        ShatteredRealmsRevival.LOGGER.info("Registered sounds for " + ShatteredRealmsRevival.MOD_ID);
    }
}