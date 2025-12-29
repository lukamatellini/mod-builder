package com.modgen.luckyblocks.engine;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Structure Registry - DATA-DRIVEN approach
 * 
 * DESIGN:
 * - Structure block placements are stored in JSON files
 * - Java code only manages IDs and loading
 * - This prevents "code too large" errors for complex structures
 * 
 * JSON files are at: data/luckyblocks/structures/{id}.json
 */
public class StructureRegistry {
    private static final Logger LOGGER = LoggerFactory.getLogger("luckyblocks/structures");
    private static final Gson GSON = new GsonBuilder().create();
    
    // Structure data loaded from JSON at runtime
    private final Map<String, StructureData> structures = new ConcurrentHashMap<>();
    
    // Known structure IDs (from build-time spec)
    private static final Set<String> KNOWN_STRUCTURE_IDS = Set.of("lucky_shrine");
    
    public StructureRegistry() {
        // Structures are loaded from JSON in loadStructuresFromResources()
        LOGGER.info("StructureRegistry initialized with {} known structure IDs", KNOWN_STRUCTURE_IDS.size());
    }
    
    /**
     * Load structure data from JSON resources
     * Called during server startup
     */
    public int loadStructuresFromResources(MinecraftServer server) {
        int loaded = 0;
        
        for (String structureId : KNOWN_STRUCTURE_IDS) {
            try {
                var resourceManager = server.getResourceManager();
                var resourceId = Identifier.of("luckyblocks", "structures/" + structureId + ".json");
                var resourceOptional = resourceManager.getResource(resourceId);
                
                if (resourceOptional.isPresent()) {
                    try (var reader = new InputStreamReader(resourceOptional.get().getInputStream())) {
                        StructureJson json = GSON.fromJson(reader, StructureJson.class);
                        if (json != null && json.blocks != null) {
                            StructureData data = convertJsonToData(structureId, json);
                            structures.put(structureId, data);
                            loaded++;
                            LOGGER.info("Loaded structure: {} ({} blocks)", structureId, json.blocks.size());
                        }
                    }
                } else {
                    LOGGER.warn("Structure JSON not found: {}", resourceId);
                }
            } catch (Exception e) {
                LOGGER.error("Failed to load structure: " + structureId, e);
            }
        }
        
        LOGGER.info("Loaded {}/{} structures from JSON", loaded, KNOWN_STRUCTURE_IDS.size());
        return loaded;
    }
    
    private StructureData convertJsonToData(String id, StructureJson json) {
        List<BlockPlacement> placements = new ArrayList<>();
        
        for (StructureJson.BlockEntry entry : json.blocks) {
            Block block = resolveBlock(entry.block);
            placements.add(new BlockPlacement(entry.x, entry.y, entry.z, block));
        }
        
        return new StructureData(id, json.name, json.type, placements.toArray(new BlockPlacement[0]));
    }
    
    private Block resolveBlock(String blockId) {
        if (blockId == null || blockId.isEmpty()) return Blocks.STONE;
        
        // Handle minecraft: prefix
        String cleanId = blockId.startsWith("minecraft:") ? blockId : "minecraft:" + blockId;
        Identifier id = Identifier.of(cleanId);
        Block block = Registries.BLOCK.get(id);
        
        return block != null ? block : Blocks.STONE;
    }
    
    public StructureData getStructure(String structureId) {
        return structures.get(structureId);
    }
    
    public boolean isValidStructureId(String structureId) {
        return KNOWN_STRUCTURE_IDS.contains(structureId);
    }
    
    public Set<String> getValidStructureIds() {
        return new HashSet<>(KNOWN_STRUCTURE_IDS);
    }
    
    public int getStructureCount() {
        return structures.size();
    }
    
    // JSON deserialization classes
    private static class StructureJson {
        String name;
        String type;
        List<BlockEntry> blocks;
        
        static class BlockEntry {
            int x, y, z;
            String block;
        }
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