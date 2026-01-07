package com.modgen.aetherfellarmory;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> VOID_REALM_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(AetherfellArmory.MOD_ID, "void_realm"));
    public static final RegistryKey<World> SKY_ISLANDS_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(AetherfellArmory.MOD_ID, "sky_islands"));
    
    public static void registerDimensions() {
        AetherfellArmory.LOGGER.info("Registered 2 dimensions");
    }
}