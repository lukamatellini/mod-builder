package com.modgen.shatteredrealmsreviv.world;

import com.modgen.shatteredrealmsreviv.ShatteredRealmsRevival;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> SHATTERED_REALM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(ShatteredRealmsRevival.MOD_ID, "shattered_realm"));
    
    public static void register() {
        ShatteredRealmsRevival.LOGGER.info("Registered 1 dimension types");
    }
}