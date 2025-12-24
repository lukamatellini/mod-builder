package com.modgen.shatteredascent;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> THE_SHATTERED_REALM_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(ShatteredAscent.MOD_ID, "the_shattered_realm"));
    
    public static void registerDimensions() {
        ShatteredAscent.LOGGER.info("Registered 1 dimensions");
    }
}