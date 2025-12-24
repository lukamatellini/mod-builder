package com.modgen.shatteredvoidrealms.world;

import com.modgen.shatteredvoidrealms.ShatteredVoidRealms;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> SHATTERED_REALM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(ShatteredVoidRealms.MOD_ID, "shattered_realm"));
    
    public static void register() {
        ShatteredVoidRealms.LOGGER.info("Registered 1 dimension types");
    }
}