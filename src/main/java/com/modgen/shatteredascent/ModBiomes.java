package com.modgen.shatteredascent;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> THE_SHATTERED_REALM_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(ShatteredAscent.MOD_ID, "the_shattered_realm_biome"));
    
    public static void registerBiomes() {
        ShatteredAscent.LOGGER.info("Registered 1 biomes");
    }
}