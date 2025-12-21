package com.modgen.shatteredvoidrealms.entity;

import com.modgen.shatteredvoidrealms.ShatteredVoidRealms;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;


import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class CrystalGolemEntity extends HostileEntity {
    private int cooldownExplode = 0;
    
    public CrystalGolemEntity(EntityType<? extends CrystalGolemEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }
    
    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
            .add(EntityAttributes.GENERIC_ARMOR, 0.0D)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.0D);
    }
    
    @Override
    protected void mobTick() {
        super.mobTick();
        // explode ability
        if (this.cooldownExplode > 0) {
            this.cooldownExplode--;
        } else {
            LivingEntity target = this.getTarget();
            if (target != null && this.canSee(target)) {
                // Create explosion
                this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), 
                    3F, true, World.ExplosionSourceType.MOB);
                this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
                this.cooldownExplode = 200;
            }
        }

    }
    
    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        }
        return super.damage(source, amount);
    }
}