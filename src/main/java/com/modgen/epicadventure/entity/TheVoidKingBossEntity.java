package com.modgen.epicadventure.entity;

import com.modgen.epicadventure.EpicAdventure;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;

import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public class TheVoidKingBossEntity extends HostileEntity {
    private final ServerBossBar bossBar = new ServerBossBar(
        Text.literal("The Void King"), 
        BossBar.Color.RED, 
        BossBar.Style.PROGRESS
    );
    
    public TheVoidKingBossEntity(EntityType<? extends TheVoidKingBossEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 100;
    }
    
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 16.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }
    
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 500.0D)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 15.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
            .add(EntityAttributes.GENERIC_ARMOR, 10.0D)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.5D)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0D);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createMobAttributes();
    }
    
    @Override
    public void onStartedTrackingBy(ServerPlayerEntity player) {
        super.onStartedTrackingBy(player);
        this.bossBar.addPlayer(player);
    }
    
    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }
    
    @Override
    protected void mobTick() {
        super.mobTick();
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }
    
    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        }
        return super.damage(source, amount);
    }
    
    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        
        if (!this.getWorld().isClient && this.getWorld() instanceof ServerWorld serverWorld) {
            // Default boss death effects
            // Particle explosion
            for (int i = 0; i < 50; i++) {
                double dx = (this.random.nextDouble() - 0.5) * 3.0;
                double dy = this.random.nextDouble() * 2.0;
                double dz = (this.random.nextDouble() - 0.5) * 3.0;
                serverWorld.spawnParticles(ParticleTypes.EXPLOSION, this.getX(), this.getY() + 1, this.getZ(), 1, dx, dy, dz, 0.1);
            }
            // Victory sound
            serverWorld.playSound(null, this.getBlockPos(), SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, SoundCategory.HOSTILE, 1.0F, 1.0F);
            // Victory message
            for (ServerPlayerEntity player : serverWorld.getPlayers(p -> p.squaredDistanceTo(this) < 10000)) {
                player.sendMessage(Text.literal("§6§l✦ The Void King has been defeated! ✦"), false);
            }
        }
    }
    
    @Override
    public boolean cannotDespawn() {
        return true;
    }
}