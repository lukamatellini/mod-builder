package com.modgen.etherealexpanse;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> VOID_EXPANSE_BIOME_KEY = RegistryKey.of(RegistryKeys.BIOME, Identifier.of(EtherealExpanse.MOD_ID, "void_expanse_biome"));
    
    public static void registerBiomes() {
        EtherealExpanse.LOGGER.info("Registered 1 biomes");
    }
}