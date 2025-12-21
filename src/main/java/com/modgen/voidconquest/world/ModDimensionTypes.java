package com.modgen.voidconquest.world;

import com.modgen.voidconquest.VoidConquest;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> SHATTERED_VOID_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(VoidConquest.MOD_ID, "shattered_void"));
    
    public static void register() {
        VoidConquest.LOGGER.info("Registered 1 dimension types");
    }
}