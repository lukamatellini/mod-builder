package com.modgen.shatteredrealmsaga;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> THE_SHATTERED_REALM_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(ShatteredRealmSaga.MOD_ID, "the_shattered_realm_biome"));
    
    public static void registerBiomes() {
        ShatteredRealmSaga.LOGGER.info("Registered 1 biomes");
    }
}