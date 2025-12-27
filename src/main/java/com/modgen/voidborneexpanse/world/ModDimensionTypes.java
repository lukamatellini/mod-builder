package com.modgen.voidborneexpanse.world;

import com.modgen.voidborneexpanse.VoidborneExpanse;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> VOID_EXPANSE_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(VoidborneExpanse.MOD_ID, "void_expanse"));
    
    public static void register() {
        VoidborneExpanse.LOGGER.info("Registered 1 dimension types");
    }
}