package com.modgen.voidconquest;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> THE_VOID_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(VoidConquest.MOD_ID, "the_void_biome"));
    
    public static void registerBiomes() {
        VoidConquest.LOGGER.info("Registered 1 biomes");
    }
}