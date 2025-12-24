package com.modgen.shatteredrealmsreviv.entity;

import com.modgen.shatteredrealmsreviv.ShatteredRealmsRevival;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ModGenNPCEntity extends PathAwareEntity {
    private String npcId = "default";
    private String npcName = "Villager";
    
    public ModGenNPCEntity(EntityType<? extends ModGenNPCEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(2, new LookAroundGoal(this));
    }
    
    public static DefaultAttributeContainer.Builder createAttributes() {
        return PathAwareEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25D);
    }
    
    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient && player instanceof ServerPlayerEntity serverPlayer) {
            ShatteredRealmsRevival.NPC_MANAGER.onNPCInteract(serverPlayer, this.npcId);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }
    
    public void setNpcId(String id) {
        this.npcId = id;
    }
    
    public void setNpcName(String name) {
        this.npcName = name;
        this.setCustomName(net.minecraft.text.Text.literal(name));
        this.setCustomNameVisible(true);
    }
    
    @Override
    public boolean cannotDespawn() {
        return true;
    }
    
    @Override
    protected boolean canStartRiding(net.minecraft.entity.Entity entity) {
        return false;
    }
}