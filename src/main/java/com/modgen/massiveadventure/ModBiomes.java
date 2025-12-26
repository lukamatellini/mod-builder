package com.modgen.massiveadventure;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> ETHEREAL_VOID_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(MassiveAdventure.MOD_ID, "ethereal_void_biome"));
    
    public static void registerBiomes() {
        MassiveAdventure.LOGGER.info("Registered 1 biomes");
    }
}