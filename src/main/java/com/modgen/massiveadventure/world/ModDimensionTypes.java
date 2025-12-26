package com.modgen.massiveadventure.world;

import com.modgen.massiveadventure.MassiveAdventure;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> ETHEREAL_VOID_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(MassiveAdventure.MOD_ID, "ethereal_void"));
    
    public static void register() {
        MassiveAdventure.LOGGER.info("Registered 1 dimension types");
    }
}