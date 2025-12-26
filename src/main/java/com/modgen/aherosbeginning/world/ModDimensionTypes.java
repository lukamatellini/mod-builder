package com.modgen.aherosbeginning.world;

import com.modgen.aherosbeginning.AHerosBeginning;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> ETHEREAL_VOID_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(AHerosBeginning.MOD_ID, "ethereal_void"));
    
    public static void register() {
        AHerosBeginning.LOGGER.info("Registered 1 dimension types");
    }
}