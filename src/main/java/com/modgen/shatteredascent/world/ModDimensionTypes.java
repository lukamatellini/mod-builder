package com.modgen.shatteredascent.world;

import com.modgen.shatteredascent.ShatteredAscent;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> THE_SHATTERED_REALM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(ShatteredAscent.MOD_ID, "the_shattered_realm"));
    
    public static void register() {
        ShatteredAscent.LOGGER.info("Registered 1 dimension types");
    }
}