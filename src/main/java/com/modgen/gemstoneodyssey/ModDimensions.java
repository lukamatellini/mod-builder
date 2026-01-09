package com.modgen.gemstoneodyssey;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensions {
    public static final RegistryKey<World> SHADOWFELL_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(GemstoneOdyssey.MOD_ID, "shadowfell"));
    public static final RegistryKey<World> AETHERIAL_EXPANSE_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(GemstoneOdyssey.MOD_ID, "aetherial_expanse"));
    
    public static void registerDimensions() {
        GemstoneOdyssey.LOGGER.info("Registered 2 dimensions");
    }
}