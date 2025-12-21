package com.modgen.voidconquest.item;

import com.modgen.voidconquest.VoidConquest;
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
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.List;

public class VoidReaperItem extends Item {
    
    public VoidReaperItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        // Play sound using vanilla SoundEvents
        world.playSound(null, player.getX(), player.getY(), player.getZ(), 
            SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        if (!world.isClient) {
            // Create explosion
            world.createExplosion(player, player.getX(), player.getY(), player.getZ(), 
                2.0f, World.ExplosionSourceType.MOB);
        }
        
        // Cooldown
        player.getItemCooldownManager().set(this, 40);
        
        // Durability damage if applicable
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        
        return TypedActionResult.success(stack, world.isClient());
    }
    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§7Right-click to use"));
    }
}