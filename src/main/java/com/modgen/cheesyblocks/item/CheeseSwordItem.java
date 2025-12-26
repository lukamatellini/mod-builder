package com.modgen.cheesyblocks.item;

import com.modgen.cheesyblocks.CheesyBlocks;
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

public class CheeseSwordItem extends Item {
    
    public CheeseSwordItem(Settings settings) {
        super(settings);
    }


    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (Math.random() < 0.1) target.addStatusEffect(new StatusEffectInstance(StatusEffects.MINECRAFT:WEAKNESS, 60, 0));
        return super.postHit(stack, target, attacker);
    }
    
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        tooltip.add(Text.literal("§cOn hit: Special effect"));
    }
}