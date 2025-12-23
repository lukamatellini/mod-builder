package com.modgen.aetheriaascendant.item;

import com.modgen.aetheriaascendant.AetheriaAscendant;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


import java.util.List;

public class AetherPortalIgniterItem extends Item {
    
    public AetherPortalIgniterItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        // Play sound using vanilla SoundEvents
        world.playSound(null, player.getX(), player.getY(), player.getZ(), 
            SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        if (!world.isClient) {
            // Generic action
            player.sendMessage(Text.literal("§aUsed The Aether Portal Key!"), true);
        }
        
        // Cooldown (1.21.x API - uses ItemStack instead of Item)
        player.getItemCooldownManager().set(stack, 40);
        
        // Durability damage if applicable
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        
        return ActionResult.SUCCESS;
    }
    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§7Right-click to use"));
    }
}