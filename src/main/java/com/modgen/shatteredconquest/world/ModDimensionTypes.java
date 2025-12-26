package com.modgen.shatteredconquest.world;

import com.modgen.shatteredconquest.ShatteredConquest;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> VOID_DIMENSION_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(ShatteredConquest.MOD_ID, "void_dimension"));
    
    public static void register() {
        ShatteredConquest.LOGGER.info("Registered 1 dimension types");
    }
}