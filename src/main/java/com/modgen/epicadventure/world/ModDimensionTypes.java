package com.modgen.epicadventure.world;

import com.modgen.epicadventure.EpicAdventure;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> ABYSSAL_VOID_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(EpicAdventure.MOD_ID, "abyssal_void"));
    
    public static void register() {
        EpicAdventure.LOGGER.info("Registered 1 dimension types");
    }
}