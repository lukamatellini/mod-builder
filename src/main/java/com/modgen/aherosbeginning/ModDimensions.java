package com.modgen.aherosbeginning;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> ETHEREAL_VOID_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(AHerosBeginning.MOD_ID, "ethereal_void"));
    
    public static void registerDimensions() {
        AHerosBeginning.LOGGER.info("Registered 1 dimensions");
    }
}