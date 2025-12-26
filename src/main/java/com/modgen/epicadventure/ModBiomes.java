package com.modgen.epicadventure;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> THE_ABYSSAL_VOID_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(EpicAdventure.MOD_ID, "the_abyssal_void_biome"));
    
    public static void registerBiomes() {
        EpicAdventure.LOGGER.info("Registered 1 biomes");
    }
}