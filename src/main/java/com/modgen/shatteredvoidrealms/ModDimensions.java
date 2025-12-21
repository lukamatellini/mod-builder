package com.modgen.shatteredvoidrealms;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> SHATTERED_VOID_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(ShatteredVoidRealms.MOD_ID, "shattered_void"));
    
    public static void registerDimensions() {
        ShatteredVoidRealms.LOGGER.info("Registered 1 dimensions");
    }
}