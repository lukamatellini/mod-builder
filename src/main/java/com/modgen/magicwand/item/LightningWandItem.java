package com.modgen.magicwand.item;

import com.modgen.magicwand.MagicWand;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
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

public class LightningWandItem extends Item {
    
    public LightningWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        // Play sound using vanilla SoundEvents
        world.playSound(null, player.getX(), player.getY(), player.getZ(), 
            SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        if (!world.isClient) {
            // Strike lightning bolt at target (Yarn 1.21.1 compatible)
            if (world instanceof ServerWorld serverWorld) {
                var hit = player.raycast(50.0, 0, false);
                BlockPos targetPos = BlockPos.ofFloored(hit.getPos());
                EntityType.LIGHTNING_BOLT.spawn(serverWorld, targetPos, SpawnReason.TRIGGERED);
            }
        }
        
        // Cooldown (1.21.1 API - uses stack.getItem() instead of stack)
        player.getItemCooldownManager().set(stack.getItem(), 20);
        
        // Durability damage if applicable (1.21.x - convert Hand to EquipmentSlot inline)
        stack.damage(1, player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
        
        return TypedActionResult.success(stack, world.isClient());
    }

    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§7Right-click to use"));

    }
}