package com.modgen.aherosbeginning.item;

import com.modgen.aherosbeginning.AHerosBeginning;
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
import net.minecraft.world.Heightmap;

import java.util.List;

public class VoidScepterItem extends Item {
    
    public VoidScepterItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        // Play sound using vanilla SoundEvents
        world.playSound(null, player.getX(), player.getY(), player.getZ(), 
            SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        
        if (!world.isClient) {
            // Random teleport
            var random = world.random;
            double x = player.getX() + (random.nextDouble() - 0.5) * 20 * 2;
            double z = player.getZ() + (random.nextDouble() - 0.5) * 20 * 2;
            double y = world.getTopY(Heightmap.Type.WORLD_SURFACE, (int)x, (int)z);
            player.teleport((ServerWorld)world, x, y, z, java.util.Set.of(), player.getYaw(), player.getPitch());
        }
        
        // Cooldown (1.21.1 API - uses stack.getItem() instead of stack)
        player.getItemCooldownManager().set(stack.getItem(), 40);
        
        // Durability damage if applicable
        stack.damage(1, player, LivingEntity.getSlotForHand(hand));
        
        return TypedActionResult.success(stack, world.isClient());
    }

    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.literal("§7Right-click to use"));

    }
}