package com.modgen.shatteredconquest;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> VOID_DIMENSION_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(ShatteredConquest.MOD_ID, "void_dimension_biome"));
    
    public static void registerBiomes() {
        ShatteredConquest.LOGGER.info("Registered 1 biomes");
    }
}