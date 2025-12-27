package com.modgen.voidborneexpanse;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * Mod Particle Types Registry
 * Custom particles for abilities, portals, and effects
 */
public class ModParticles {
    
    public static final SimpleParticleType FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType MAGIC = FabricParticleTypes.simple();
    public static final SimpleParticleType VOID = FabricParticleTypes.simple();
    
    /**
     * Register all particles
     */
    public static void register() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(VoidborneExpanse.MOD_ID, "flame"), FLAME);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(VoidborneExpanse.MOD_ID, "magic"), MAGIC);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(VoidborneExpanse.MOD_ID, "void"), VOID);
    }
}