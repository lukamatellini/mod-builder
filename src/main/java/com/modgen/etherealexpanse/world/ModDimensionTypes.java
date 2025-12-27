package com.modgen.etherealexpanse.world;

import com.modgen.etherealexpanse.EtherealExpanse;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;

public class ModDimensionTypes {
    public static final RegistryKey<DimensionType> VOID_EXPANSE_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE, Identifier.of(EtherealExpanse.MOD_ID, "void_expanse"));
    
    public static void register() {
        EtherealExpanse.LOGGER.info("Registered 1 dimension types");
    }
}