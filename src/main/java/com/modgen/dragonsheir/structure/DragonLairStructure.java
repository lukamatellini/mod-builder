package com.modgen.dragonsheir.structure;

import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import com.modgen.dragonsheir.DragonsHeir;

public class DragonLairStructure {
    public static final int SIZE_X = undefined;
    public static final int SIZE_Y = undefined;
    public static final int SIZE_Z = undefined;
    
    public static void register() {
        DragonsHeir.LOGGER.info("Registered structure: Dragon's Lair");
    }
    
    /**
     * Place the structure at the given position (called from worldgen)
     */
    public static void placeAt(ServerWorld world, BlockPos origin) {
        generate(world, origin);
    }
    
    public static void generate(World world, BlockPos origin) {
        DragonsHeir.LOGGER.info("Generating Dragon's Lair at " + origin);
        
        // Generate arena floor
        for (int x = 0; x < SIZE_X; x++) {
            for (int z = 0; z < SIZE_Z; z++) {
                world.setBlockState(origin.add(x, 0, z), Blocks.STONE.getDefaultState(), 3);
            }
        }
        
        // Generate arena walls
        for (int y = 1; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {
                world.setBlockState(origin.add(x, y, 0), Blocks.STONE_BRICKS.getDefaultState(), 3);
                world.setBlockState(origin.add(x, y, SIZE_Z - 1), Blocks.STONE_BRICKS.getDefaultState(), 3);
            }
            for (int z = 0; z < SIZE_Z; z++) {
                world.setBlockState(origin.add(0, y, z), Blocks.STONE_BRICKS.getDefaultState(), 3);
                world.setBlockState(origin.add(SIZE_X - 1, y, z), Blocks.STONE_BRICKS.getDefaultState(), 3);
            }
        }
        
        // Add lighting
        world.setBlockState(origin.add(SIZE_X / 2, SIZE_Y - 1, SIZE_Z / 2), Blocks.LANTERN.getDefaultState(), 3);
        

    }
}