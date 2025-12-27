package com.modgen.etherealexpanse;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDimensions {
    public static final RegistryKey<World> VOID_EXPANSE_KEY = RegistryKey.of(RegistryKeys.WORLD, Identifier.of(EtherealExpanse.MOD_ID, "void_expanse"));
    
    public static void registerDimensions() {
        EtherealExpanse.LOGGER.info("Registered 1 dimensions");
    }
}