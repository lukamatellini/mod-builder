package com.modgen.luckycubes.engine;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Structure Registry - ID-DRIVEN structure data management
 */
public class StructureRegistry {
    private static final Logger LOGGER = LoggerFactory.getLogger("luckycubes/structures");
    
    private final Map<String, StructureData> structures = new ConcurrentHashMap<>();
    
    public StructureRegistry() {
        registerStructures();
    }
    
    private void registerStructures() {
        LOGGER.info("Registered {} structures", structures.size());
    }
    
    public StructureData getStructure(String structureId) {
        return structures.get(structureId);
    }
    
    public boolean isValidStructureId(String structureId) {
        return structures.containsKey(structureId);
    }
    
    public Set<String> getValidStructureIds() {
        return new HashSet<>(structures.keySet());
    }
    
    public int getStructureCount() {
        return structures.size();
    }
    
    public static class StructureData {
        public final String id;
        public final String name;
        public final String type;
        public final BlockPlacement[] blocks;
        
        public StructureData(String id, String name, String type, BlockPlacement[] blocks) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.blocks = blocks;
        }
        
        public int placeAt(ServerWorld world, BlockPos origin) {
            int placed = 0;
            for (BlockPlacement bp : blocks) {
                BlockPos pos = origin.add(bp.x, bp.y, bp.z);
                world.setBlockState(pos, bp.block.getDefaultState());
                placed++;
            }
            LOGGER.info("Placed structure {} ({} blocks) at {}", id, placed, origin);
            return placed;
        }
    }
    
    public static class BlockPlacement {
        public final int x, y, z;
        public final Block block;
        
        public BlockPlacement(int x, int y, int z, Block block) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.block = block;
        }
    }
}