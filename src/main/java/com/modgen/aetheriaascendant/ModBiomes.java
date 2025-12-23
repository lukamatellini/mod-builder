package com.modgen.aetheriaascendant;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> AETHER_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(AetheriaAscendant.MOD_ID, "aether_biome"));
    
    public static void registerBiomes() {
        AetheriaAscendant.LOGGER.info("Registered 1 biomes");
    }
}