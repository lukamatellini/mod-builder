package com.modgen.romanconquests.engine;

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
    private static final Logger LOGGER = LoggerFactory.getLogger("romanconquests/structures");
    
    private final Map<String, StructureData> structures = new ConcurrentHashMap<>();
    
    public StructureRegistry() {
        registerStructures();
    }
    
    private void registerStructures() {
        structures.put("roman_camp", new StructureData(
            "roman_camp",
            "Roman Camp",
            "surface",
            new BlockPlacement[] {
                new BlockPlacement(0, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(2, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 3, 2, Blocks.GLOWSTONE)
            }
        ));
        structures.put("roman_fort", new StructureData(
            "roman_fort",
            "Roman Fort",
            "surface",
            new BlockPlacement[] {
                new BlockPlacement(0, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(2, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 3, 2, Blocks.GLOWSTONE)
            }
        ));
        structures.put("imperial_palace", new StructureData(
            "imperial_palace",
            "Imperial Palace",
            "surface",
            new BlockPlacement[] {
                new BlockPlacement(0, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(1, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(2, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(3, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 0, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 1, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 2, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 3, Blocks.OAK_PLANKS),
                new BlockPlacement(4, 0, 4, Blocks.OAK_PLANKS),
                new BlockPlacement(0, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 1, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 2, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 1, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 2, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 3, Blocks.OAK_LOG),
                new BlockPlacement(0, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(1, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(1, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(2, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(2, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(3, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(3, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 0, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 1, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 2, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 3, Blocks.OAK_LOG),
                new BlockPlacement(4, 3, 4, Blocks.OAK_LOG),
                new BlockPlacement(0, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(0, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(1, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(3, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 0, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 1, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 2, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 3, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(4, 4, 4, Blocks.DARK_OAK_PLANKS),
                new BlockPlacement(2, 3, 2, Blocks.GLOWSTONE)
            }
        ));
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