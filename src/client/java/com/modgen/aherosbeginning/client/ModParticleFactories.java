package com.modgen.aherosbeginning.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import com.modgen.aherosbeginning.ModParticles;
import com.modgen.aherosbeginning.client.particle.MagicParticle;
import com.modgen.aherosbeginning.client.particle.FlameParticle;
import com.modgen.aherosbeginning.client.particle.SoulParticle;
import com.modgen.aherosbeginning.client.particle.VoidParticle;

/**
 * Client-side particle factory registration
 */
@Environment(EnvType.CLIENT)
public class ModParticleFactories {
    
    /**
     * Register all particle factories
     */
    public static void register() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGIC, MagicParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.SOUL, SoulParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.VOID, VoidParticle.Factory::new);
    }
}