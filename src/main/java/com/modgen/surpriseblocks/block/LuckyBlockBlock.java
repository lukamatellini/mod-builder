package com.modgen.surpriseblocks.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.Random;
import com.modgen.surpriseblocks.entity.ModEntities;


/**
 * Lucky Block - Custom block with break handler
 * Spawns entities and/or creates effects when broken
 */
public class LuckyBlockBlock extends Block {
    private static final Random RANDOM = new Random();
    
    public LuckyBlockBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state,
                          @Nullable net.minecraft.block.entity.BlockEntity blockEntity, ItemStack tool) {
        super.afterBreak(world, player, pos, state, blockEntity, tool);
        
        if (world instanceof ServerWorld serverWorld) {
            // Spawn surpriseblocks:worm
            for (int i = 0; i < 2; i++) {
                double offsetX = (RANDOM.nextDouble() - 0.5) * 4;
                double offsetZ = (RANDOM.nextDouble() - 0.5) * 4;
                ModEntities.WORM.spawn(serverWorld, 
                    pos.add((int)offsetX, 1, (int)offsetZ), SpawnReason.MOB_SUMMONED);
            }
            // Spawn surpriseblocks:japanese_sumo_wrestlers_that_attack_till_kill_them
            for (int i = 0; i < 2; i++) {
                double offsetX = (RANDOM.nextDouble() - 0.5) * 4;
                double offsetZ = (RANDOM.nextDouble() - 0.5) * 4;
                ModEntities.JAPANESE_SUMO_WRESTLERS_THAT_ATTACK_TILL_KILL_THEM.spawn(serverWorld, 
                    pos.add((int)offsetX, 1, (int)offsetZ), SpawnReason.MOB_SUMMONED);
            }

        }
    }
}
