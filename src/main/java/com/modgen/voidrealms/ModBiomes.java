package com.modgen.voidrealms;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> SHATTERED_REALM_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(VoidRealms.MOD_ID, "shattered_realm_biome"));
    
    public static void registerBiomes() {
        VoidRealms.LOGGER.info("Registered 1 biomes");
    }
}