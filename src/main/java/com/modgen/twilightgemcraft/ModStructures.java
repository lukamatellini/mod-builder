package com.modgen.twilightgemcraft;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.modgen.twilightgemcraft.structure.AncientAetheriumShrineStructure;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("twilightgemcraft/structures");
    
    public static void registerStructures() {
        TwilightGemcraft.LOGGER.info("Registering 1 structures for worldgen");
        
        // Register worldgen for: Ancient Aetherium Shrine
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            if (!chunk.needsSaving()) return;
            ChunkPos chunkPos = chunk.getPos();
            Random random = Random.create(chunkPos.toLong() ^ world.getSeed());
            if (random.nextInt(500) != 0) return;
            BlockPos centerPos = chunkPos.getStartPos().add(8, 0, 8);
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, centerPos.getX(), centerPos.getZ());
            if (y < 10 || y > 250) return;
            AncientAetheriumShrineStructure.placeAt(world, new BlockPos(centerPos.getX(), y, centerPos.getZ()));
            LOGGER.info("Generated structure 'ancient_aetherium_shrine' at {}", centerPos);
        });
        
        LOGGER.info("Structure worldgen registration complete");
    }
}