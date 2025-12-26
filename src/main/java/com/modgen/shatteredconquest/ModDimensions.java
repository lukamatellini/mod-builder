package com.modgen.shatteredconquest;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> VOID_DIMENSION_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(ShatteredConquest.MOD_ID, "void_dimension"));
    
    public static void registerDimensions() {
        ShatteredConquest.LOGGER.info("Registered 1 dimensions");
    }
}