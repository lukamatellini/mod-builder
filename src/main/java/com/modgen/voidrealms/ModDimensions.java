package com.modgen.voidrealms;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> SHATTERED_REALM_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(VoidRealms.MOD_ID, "shattered_realm"));
    
    public static void registerDimensions() {
        VoidRealms.LOGGER.info("Registered 1 dimensions");
    }
}