package com.modgen.shatteredrealmsreviv;

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
    public static final SimpleParticleType NATURE = FabricParticleTypes.simple();
    public static final SimpleParticleType MAGIC = FabricParticleTypes.simple();
    public static final SimpleParticleType SOUL = FabricParticleTypes.simple();
    public static final SimpleParticleType VOID = FabricParticleTypes.simple();
    
    /**
     * Register all particles
     */
    public static void register() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ShatteredRealmsRevival.MOD_ID, "flame"), FLAME);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ShatteredRealmsRevival.MOD_ID, "nature"), NATURE);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ShatteredRealmsRevival.MOD_ID, "magic"), MAGIC);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ShatteredRealmsRevival.MOD_ID, "soul"), SOUL);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(ShatteredRealmsRevival.MOD_ID, "void"), VOID);
    }
}