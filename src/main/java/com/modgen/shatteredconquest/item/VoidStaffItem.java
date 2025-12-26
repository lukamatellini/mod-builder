package com.modgen.shatteredconquest.item;

import com.modgen.shatteredconquest.ShatteredConquest;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.List;

public class VoidStaffItem extends Item {
    
    public VoidStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        // Play sound using vanilla SoundEvents
        world.playSound(null, player.getX(), player.getY(), player.getZ(), 
            SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        if (!world.isClient) {
            // Summon entity
            var entity = EntityType.ZOMBIE.create(world);
            if (entity != null) {
                entity.setPosition(player.getX() + 2, player.getY(), player.getZ() + 2);
                world.spawnEntity(entity);
            }
        }
        
        // Cooldown (1.21.1 API - uses stack.getItem() instead of stack)
        player.getItemCooldownManager().set(stack.getItem(), 100);
        
        // Durability damage if applicable
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        
        return TypedActionResult.success(stack, world.isClient());
    }

    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§7Right-click to use"));

    }
}