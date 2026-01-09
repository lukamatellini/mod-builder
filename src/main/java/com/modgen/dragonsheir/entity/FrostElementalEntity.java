package com.modgen.dragonsheir.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;


public class FrostElementalEntity extends HostileEntity {
    private int abilityCooldown = 0;
    
    public FrostElementalEntity(EntityType<? extends FrostElementalEntity> entityType, World world) {
        super(entityType, world);
    }
    
    @Override
    protected void initGoals() {
        // Movement goals
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 0.8D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
        

    }
    

    
    public static DefaultAttributeContainer.Builder createMobAttributes() {
        return HostileEntity.createHostileAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH, 40)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, undefined)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3)
            .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16)
            
            ;
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return createMobAttributes();
    }
}