package com.modgen.magicwand.item;

import com.modgen.magicwand.MagicWand;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.EntityType;
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

public class SparkWandItem extends Item {
    
    public SparkWandItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        // Play sound using vanilla SoundEvents
        world.playSound(null, player.getX(), player.getY(), player.getZ(), 
            SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        if (!world.isClient) {
            // Strike lightning bolt at target
            if (world instanceof ServerWorld serverWorld) {
                var hit = player.raycast(50.0, 0, false);
                double x = hit.getPos().x;
                double y = hit.getPos().y;
                double z = hit.getPos().z;
                net.minecraft.entity.LightningEntity lightning = net.minecraft.entity.EntityType.LIGHTNING_BOLT.create(serverWorld, net.minecraft.entity.SpawnReason.TRIGGERED);
                if (lightning != null) {
                    lightning.setPosition(x, y, z);
                    serverWorld.spawnEntity(lightning);
                }
            }
        }
        
        // Cooldown (1.21.1 API - uses stack.getItem() instead of stack)
        player.getItemCooldownManager().set(stack.getItem(), 20);
        
        // Durability damage if applicable
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        
        return TypedActionResult.success(stack, world.isClient());
    }

    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§7Right-click to use"));

    }
}