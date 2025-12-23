package com.modgen.aetheriaascendant.client.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

/**
 * Magic Particle
 * Custom particle effect for magic-type abilities
 */
@Environment(EnvType.CLIENT)
public class MagicParticle extends SpriteBillboardParticle {
    
    private final SpriteProvider spriteProvider;
    
    protected MagicParticle(ClientWorld world, double x, double y, double z, 
                                   double velocityX, double velocityY, double velocityZ,
                                   SpriteProvider spriteProvider) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.spriteProvider = spriteProvider;
        
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.velocityZ = velocityZ;
        
        this.maxAge = 25 + this.random.nextInt(10);
        this.scale = 0.1f + this.random.nextFloat() * 0.1f;
        this.gravityStrength = 0.000f;
        
        // Set color
        this.red = 0.70f;
        this.green = 0.50f;
        this.blue = 1.00f;
        
        this.velocityMultiplier = 0.98f;
        this.gravityStrength = 0.01f;
        
        this.setSpriteForAge(spriteProvider);
    }
    
    @Override
    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        
        if (this.age++ >= this.maxAge) {
            this.markDead();
            return;
        }
        
        // Fade out over time
        this.alpha = 1.0f - (float)this.age / (float)this.maxAge;
        
        // Apply velocity
        this.velocityY -= this.gravityStrength;
        this.move(this.velocityX, this.velocityY, this.velocityZ);
        this.velocityX *= this.velocityMultiplier;
        this.velocityY *= this.velocityMultiplier;
        this.velocityZ *= this.velocityMultiplier;
        
        this.setSpriteForAge(this.spriteProvider);
    }
    
    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }
    
    /**
     * Factory for creating this particle
     */
    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;
        
        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }
        
        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world,
                                       double x, double y, double z,
                                       double velocityX, double velocityY, double velocityZ) {
            return new MagicParticle(world, x, y, z, velocityX, velocityY, velocityZ, this.spriteProvider);
        }
    }
}