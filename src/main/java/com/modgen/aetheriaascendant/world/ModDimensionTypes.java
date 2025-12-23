package com.modgen.aetheriaascendant.world;

import com.modgen.aetheriaascendant.AetheriaAscendant;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> AETHER_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(AetheriaAscendant.MOD_ID, "aether"));
    
    public static void register() {
        AetheriaAscendant.LOGGER.info("Registered 1 dimension types");
    }
}