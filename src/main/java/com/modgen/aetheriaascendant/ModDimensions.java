package com.modgen.aetheriaascendant;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> AETHER_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(AetheriaAscendant.MOD_ID, "aether"));
    
    public static void registerDimensions() {
        AetheriaAscendant.LOGGER.info("Registered 1 dimensions");
    }
}