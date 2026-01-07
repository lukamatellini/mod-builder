package com.modgen.aetherfellarmory.entity;

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
import com.modgen.aetherfellarmory.AetherfellArmory;

public class AncientDragonBossBossEntity extends HostileEntity {
    private final ServerBossBar bossBar;
    private int currentPhase = 0;
    private int attackCooldown = 0;
    private int specialAttackCooldown = 0;
    
    public AncientDragonBossBossEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = new ServerBossBar(
            Text.literal("Ancient Dragon Boss"),
            BossBar.Color.RED,
            BossBar.Style.PROGRESS
        );
        this.experiencePoints = 500;
    }
    
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 16.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(2, new RevengeGoal(this));
    }
    
    @Override
    public void tick() {
        super.tick();
        
        // Update boss bar
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
        
        // Check phase transitions
        float healthPercent = this.getHealth() / this.getMaxHealth();
        if (healthPercent <= 1 && currentPhase < 0) {
            enterPhase(0, "Normal");
        }
        if (healthPercent <= 0.5 && currentPhase < 1) {
            enterPhase(1, "Enraged");
        }
        
        // Cooldowns
        if (attackCooldown > 0) attackCooldown--;
        if (specialAttackCooldown > 0) specialAttackCooldown--;
        
        // Basic boss attack pattern
        if (attackCooldown <= 0 && this.getTarget() != null) {
            attackCooldown = 40;
        }
    }
    
    private void enterPhase(int phase, String phaseName, String... message) {
        currentPhase = phase;
        AetherfellArmory.LOGGER.info("Ancient Dragon Boss entering phase: " + phaseName);
        if (message.length > 0 && !this.getWorld().isClient) {
            for (PlayerEntity player : this.getWorld().getPlayers()) {
                if (player.distanceTo(this) < 50) {
                    player.sendMessage(Text.literal("§c" + message[0]), false);
                }
            }
        }
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
    
    // MINECRAFT 1.21.1: damage does NOT take ServerWorld parameter (1.21.4 does)
    @Override
    public boolean damage(DamageSource source, float amount) {
        // Boss cannot be killed by void or /kill easily
        if (source.isOutOfWorld() && this.getHealth() > 1) {
            return false;
        }
        return super.damage(source, amount);
    }
    
    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        if (!this.getWorld().isClient && this.getWorld() instanceof net.minecraft.server.world.ServerWorld serverWorld) {
            // Default boss death effects
            for (int i = 0; i < 50; i++) {
                double dx = (this.random.nextDouble() - 0.5) * 3.0;
                double dy = this.random.nextDouble() * 2.0;
                double dz = (this.random.nextDouble() - 0.5) * 3.0;
                serverWorld.spawnParticles(net.minecraft.particle.ParticleTypes.EXPLOSION, this.getX(), this.getY() + 1, this.getZ(), 1, dx, dy, dz, 0.1);
            }
            serverWorld.playSound(null, this.getBlockPos(), net.minecraft.sound.SoundEvents.UI_TOAST_CHALLENGE_COMPLETE, net.minecraft.sound.SoundCategory.HOSTILE, 1.0F, 1.0F);
            for (net.minecraft.server.network.ServerPlayerEntity player : serverWorld.getPlayers(p -> p.squaredDistanceTo(this) < 10000)) {
                player.sendMessage(Text.literal("§6§l✦ Ancient Dragon Boss has been defeated! ✦"), false);
            }
        }
    }
    
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 500)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 25)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64)
            .add(EntityAttributes.GENERIC_ARMOR, 10)
            .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.8);
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createMobAttributes();
    }
}