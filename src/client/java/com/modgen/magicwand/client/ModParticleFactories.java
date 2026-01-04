package com.modgen.magicwand.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import com.modgen.magicwand.ModParticles;
import com.modgen.magicwand.client.particle.FlameParticle;

/**
 * Client-side particle factory registration
 */
@Environment(EnvType.CLIENT)
public class ModParticleFactories {
    
    /**
     * Register all particle factories
     */
    public static void register() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLAME, FlameParticle.Factory::new);
    }
}