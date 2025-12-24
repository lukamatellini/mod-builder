package com.modgen.shatteredrealmsaga.world;

import com.modgen.shatteredrealmsaga.ShatteredRealmSaga;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> THE_SHATTERED_REALM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(ShatteredRealmSaga.MOD_ID, "the_shattered_realm"));
    
    public static void register() {
        ShatteredRealmSaga.LOGGER.info("Registered 1 dimension types");
    }
}