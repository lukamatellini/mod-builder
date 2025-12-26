package com.modgen.epicadventure.entity;

import com.modgen.epicadventure.EpicAdventure;
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


public class VoidCommanderEntity extends HostileEntity {
    private int cooldownTeleport = 0;
    
    public VoidCommanderEntity(EntityType<? extends VoidCommanderEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.6D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
    
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 60.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 8.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
            .add(EntityAttributes.GENERIC_ARMOR, 0.0D)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16.0D)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.0D);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createMobAttributes();
    }
    
    @Override
    protected void mobTick() {
        super.mobTick();
        // teleport ability
        if (this.cooldownTeleport > 0) {
            this.cooldownTeleport--;
        } else {
            LivingEntity target = this.getTarget();
            if (target != null && this.canSee(target)) {
                // Teleport behind target
                double tx = target.getX() - (target.getX() - this.getX()) * 0.5;
                double ty = target.getY();
                double tz = target.getZ() - (target.getZ() - this.getZ()) * 0.5;
                this.requestTeleport(tx, ty, tz);
                this.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                this.cooldownTeleport = 100;
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