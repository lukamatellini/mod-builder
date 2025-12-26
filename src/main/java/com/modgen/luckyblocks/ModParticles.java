package com.modgen.luckyblocks;

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
    
    public static final SimpleParticleType SMOKE = FabricParticleTypes.simple();
    
    /**
     * Register all particles
     */
    public static void register() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(LuckyBlocks.MOD_ID, "smoke"), SMOKE);
    }
}