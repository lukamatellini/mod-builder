package com.modgen.epicadventure;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> SHATTERED_REALM_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(EpicAdventure.MOD_ID, "shattered_realm_biome"));
    
    public static void registerBiomes() {
        EpicAdventure.LOGGER.info("Registered 1 biomes");
    }
}