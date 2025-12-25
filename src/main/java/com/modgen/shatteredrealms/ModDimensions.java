package com.modgen.shatteredrealms;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> SHATTERED_REALM_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(ShatteredRealms.MOD_ID, "shattered_realm"));
    
    public static void registerDimensions() {
        ShatteredRealms.LOGGER.info("Registered 1 dimensions");
    }
}