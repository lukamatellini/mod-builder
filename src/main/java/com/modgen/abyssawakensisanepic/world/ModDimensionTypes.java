package com.modgen.abyssawakensisanepic.world;

import com.modgen.abyssawakensisanepic.AbyssAwakensIsAnEpicAdventure;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> ABYSSAL_VOID_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "abyssal_void"));
    
    public static void register() {
        AbyssAwakensIsAnEpicAdventure.LOGGER.info("Registered 1 dimension types");
    }
}