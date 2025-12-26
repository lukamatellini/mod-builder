package com.modgen.voidconquest;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> THE_VOID_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(VoidConquest.MOD_ID, "the_void"));
    
    public static void registerDimensions() {
        VoidConquest.LOGGER.info("Registered 1 dimensions");
    }
}