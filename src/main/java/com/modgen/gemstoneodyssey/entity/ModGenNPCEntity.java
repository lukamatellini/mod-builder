package com.modgen.gemstoneodyssey.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

/**
 * Base NPC entity class for all NPCs in this mod
 */
public class ModGenNPCEntity extends PathAwareEntity {
    private String npcId = "";
    private String npcName = "NPC";
    
    public ModGenNPCEntity(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
    }
    
    public static DefaultAttributeContainer.Builder createNPCAttributes() {
        return PathAwareEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.5);
    }
    
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(2, new LookAroundGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.6));
    }
    
    @Override
    protected ActionResult interactMob(PlayerEntity player, Hand hand) {
        if (!this.getWorld().isClient) {
            player.sendMessage(Text.literal("§e[" + npcName + "]§r Hello, traveler!"), false);
        }
        return ActionResult.SUCCESS;
    }
    
    public void setNpcId(String id) {
        this.npcId = id;
    }
    
    public String getNpcId() {
        return this.npcId;
    }
    
    public void setNpcName(String name) {
        this.npcName = name;
        this.setCustomName(Text.literal(name));
        this.setCustomNameVisible(true);
    }
    
    public String getNpcName() {
        return this.npcName;
    }
    
    @Override
    public boolean cannotDespawn() {
        return true;
    }
}