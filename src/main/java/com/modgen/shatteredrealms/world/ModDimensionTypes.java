package com.modgen.shatteredrealms.world;

import com.modgen.shatteredrealms.ShatteredRealms;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> SHATTERED_REALM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(ShatteredRealms.MOD_ID, "shattered_realm"));
    
    public static void register() {
        ShatteredRealms.LOGGER.info("Registered 1 dimension types");
    }
}