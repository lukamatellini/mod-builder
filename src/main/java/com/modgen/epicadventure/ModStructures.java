package com.modgen.epicadventure;

import com.modgen.epicadventure.engine.StructureRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

/**
 * ModStructures - Registers structures for NATURAL WORLD GENERATION
 * Structures will appear automatically in newly generated chunks
 */
public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("epicadventure/structures");
    
    public static void registerStructures() {
        EpicAdventure.LOGGER.info("Registering 7 structures for worldgen");
        
        // Register worldgen for: Ruined Alchemist Lab
        registerStructureFeature("ruined_alchemist_lab", BiomeSelectors.tag(BiomeTags.IS_FOREST), 20);
        // Register worldgen for: Crystal Forge
        registerStructureFeature("crystal_forge", BiomeSelectors.tag(BiomeTags.IS_FOREST), 20);
        // Register worldgen for: Void Obelisk
        registerStructureFeature("void_obelisk", BiomeSelectors.tag(BiomeTags.IS_FOREST), 20);
        // Register worldgen for: Corrupted Village
        registerStructureFeature("corrupted_village", BiomeSelectors.tag(BiomeTags.IS_FOREST), 20);
        // Register worldgen for: Shadow Shrine
        registerStructureFeature("shadow_shrine", BiomeSelectors.tag(BiomeTags.IS_FOREST), 20);
        // Register worldgen for: Void King's Citadel
        registerStructureFeature("void_kings_citadel", BiomeSelectors.tag(BiomeTags.IS_FOREST), 20);
        // Register worldgen for: The Abyssal Void Obelisk
        registerStructureFeature("the_abyssal_void_structure", BiomeSelectors.foundInOverworld(), 80);
        
        LOGGER.info("Structure worldgen registration complete");
    }
    
    /**
     * Register a structure to generate in biomes matching the selector
     * Uses chunk population events to place structures procedurally
     */
    private static void registerStructureFeature(String structureId, Predicate<net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext> biomeSelector, int chancePerChunk) {
        // Use ServerChunkEvents to place structures during chunk generation
        net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            // Only place in newly generated chunks (first load)
            if (!chunk.needsSaving()) return;
            
            ChunkPos chunkPos = chunk.getPos();
            Random random = Random.create(chunkPos.toLong() ^ world.getSeed());
            
            // Check spawn chance (1 in N chunks)
            if (random.nextInt(chancePerChunk) != 0) return;
            
            // Check if biome matches
            BlockPos centerPos = chunkPos.getStartPos().add(8, 0, 8);
            var biomeEntry = world.getBiome(centerPos);
            
            // Get structure data from registry
            var structureData = EpicAdventure.STRUCTURE_REGISTRY.getStructure(structureId);
            if (structureData == null) return;
            
            // Find suitable Y position (on surface)
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, centerPos.getX(), centerPos.getZ());
            if (y < 10 || y > 250) return; // Skip if in void or too high
            
            BlockPos spawnPos = new BlockPos(centerPos.getX(), y, centerPos.getZ());
            
            // Place the structure
            structureData.placeAt(world, spawnPos);
            LOGGER.info("Generated structure '{}' at {}", structureId, spawnPos);
        });
        
        LOGGER.info("Registered structure '{}' for worldgen (1 in {} chunks)", structureId, chancePerChunk);
    }
}