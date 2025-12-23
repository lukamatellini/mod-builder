package com.modgen.aetheriaascendant.entity;

import com.modgen.aetheriaascendant.AetheriaAscendant;
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

import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class AetherGolemEntity extends HostileEntity {
    private int cooldownSummon = 0;
    
    public AetherGolemEntity(EntityType<? extends AetherGolemEntity> entityType, World world) {
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
    
    public static DefaultAttributeContainer.Builder createAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.MAX_HEALTH, 80.0D)
            .add(EntityAttributes.ATTACK_DAMAGE, 8.0D)
            .add(EntityAttributes.MOVEMENT_SPEED, 0.3D)
            .add(EntityAttributes.ARMOR, 0.0D)
            .add(EntityAttributes.FOLLOW_RANGE, 16.0D)
            .add(EntityAttributes.KNOCKBACK_RESISTANCE, 0.0D);
    }
    
    @Override
    protected void mobTick() {
        super.mobTick();
        // summon ability
        if (this.cooldownSummon > 0) {
            this.cooldownSummon--;
        } else {
            LivingEntity target = this.getTarget();
            if (target != null && this.canSee(target)) {
                // Summon minions
                if (this.getWorld() instanceof ServerWorld serverWorld) {
                    for (int i = 0; i < 2; i++) {
                        // Summon at random nearby position
                        double sx = this.getX() + (this.random.nextDouble() - 0.5) * 4;
                        double sy = this.getY();
                        double sz = this.getZ() + (this.random.nextDouble() - 0.5) * 4;
                        // Would spawn entity here with entity type registry
                    }
                    this.playSound(SoundEvents.ENTITY_EVOKER_PREPARE_SUMMON.value(), 1.0F, 1.0F);
                }
                this.cooldownSummon = 300;
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