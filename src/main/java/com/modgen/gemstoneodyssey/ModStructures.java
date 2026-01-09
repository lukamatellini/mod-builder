package com.modgen.gemstoneodyssey;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerChunkEvents;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.modgen.gemstoneodyssey.structure.DragonLairStructure;
import com.modgen.gemstoneodyssey.structure.CrystalCavesStructure;
import com.modgen.gemstoneodyssey.structure.PirateShipwreckStructure;
import com.modgen.gemstoneodyssey.structure.WizardTowerStructure;

public class ModStructures {
    private static final Logger LOGGER = LoggerFactory.getLogger("gemstoneodyssey/structures");
    
    public static void registerStructures() {
        GemstoneOdyssey.LOGGER.info("Registering 4 structures for worldgen");
        
        // Register worldgen for: Dragon Lair
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            if (!chunk.needsSaving()) return;
            ChunkPos chunkPos = chunk.getPos();
            Random random = Random.create(chunkPos.toLong() ^ world.getSeed());
            if (random.nextInt(500) != 0) return;
            BlockPos centerPos = chunkPos.getStartPos().add(8, 0, 8);
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, centerPos.getX(), centerPos.getZ());
            if (y < 10 || y > 250) return;
            DragonLairStructure.placeAt(world, new BlockPos(centerPos.getX(), y, centerPos.getZ()));
            LOGGER.info("Generated structure 'dragon_lair' at {}", centerPos);
        });
        // Register worldgen for: Crystal Caves
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            if (!chunk.needsSaving()) return;
            ChunkPos chunkPos = chunk.getPos();
            Random random = Random.create(chunkPos.toLong() ^ world.getSeed());
            if (random.nextInt(500) != 0) return;
            BlockPos centerPos = chunkPos.getStartPos().add(8, 0, 8);
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, centerPos.getX(), centerPos.getZ());
            if (y < 10 || y > 250) return;
            CrystalCavesStructure.placeAt(world, new BlockPos(centerPos.getX(), y, centerPos.getZ()));
            LOGGER.info("Generated structure 'crystal_caves' at {}", centerPos);
        });
        // Register worldgen for: Pirate Shipwreck
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            if (!chunk.needsSaving()) return;
            ChunkPos chunkPos = chunk.getPos();
            Random random = Random.create(chunkPos.toLong() ^ world.getSeed());
            if (random.nextInt(500) != 0) return;
            BlockPos centerPos = chunkPos.getStartPos().add(8, 0, 8);
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, centerPos.getX(), centerPos.getZ());
            if (y < 10 || y > 250) return;
            PirateShipwreckStructure.placeAt(world, new BlockPos(centerPos.getX(), y, centerPos.getZ()));
            LOGGER.info("Generated structure 'pirate_shipwreck' at {}", centerPos);
        });
        // Register worldgen for: Wizard Tower
        ServerChunkEvents.CHUNK_LOAD.register((world, chunk) -> {
            if (!chunk.needsSaving()) return;
            ChunkPos chunkPos = chunk.getPos();
            Random random = Random.create(chunkPos.toLong() ^ world.getSeed());
            if (random.nextInt(500) != 0) return;
            BlockPos centerPos = chunkPos.getStartPos().add(8, 0, 8);
            int y = world.getTopY(Heightmap.Type.WORLD_SURFACE_WG, centerPos.getX(), centerPos.getZ());
            if (y < 10 || y > 250) return;
            WizardTowerStructure.placeAt(world, new BlockPos(centerPos.getX(), y, centerPos.getZ()));
            LOGGER.info("Generated structure 'wizard_tower' at {}", centerPos);
        });
        
        LOGGER.info("Structure worldgen registration complete");
    }
}