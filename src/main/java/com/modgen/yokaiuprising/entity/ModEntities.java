package com.modgen.yokaiuprising.entity;

import com.modgen.yokaiuprising.YokaiUprising;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.yokaiuprising.entity.MutatedZombieEntity;
import com.modgen.yokaiuprising.entity.CaveWormEntity;
import com.modgen.yokaiuprising.entity.SumoWrestlerEntity;

public class ModEntities {
    public static final EntityType<MutatedZombieEntity> MUTATED_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(YokaiUprising.MOD_ID, "mutated_zombie"),
        EntityType.Builder.create(MutatedZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CaveWormEntity> CAVE_WORM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(YokaiUprising.MOD_ID, "cave_worm"),
        EntityType.Builder.create(CaveWormEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<SumoWrestlerEntity> SUMO_WRESTLER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(YokaiUprising.MOD_ID, "sumo_wrestler"),
        EntityType.Builder.create(SumoWrestlerEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        YokaiUprising.LOGGER.info("Registering entities for " + YokaiUprising.MOD_ID);
        FabricDefaultAttributeRegistry.register(MUTATED_ZOMBIE, MutatedZombieEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CAVE_WORM, CaveWormEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SUMO_WRESTLER, SumoWrestlerEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        YokaiUprising.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Mutated Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            MUTATED_ZOMBIE,
            10,
            1,
            3
        );

        // Natural spawn for Cave Worm
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CAVE_WORM,
            10,
            1,
            3
        );

        // Natural spawn for Sumo Wrestler
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(net.minecraft.registry.RegistryKey.of(net.minecraft.registry.RegistryKeys.BIOME, Identifier.of("minecraft", "plains"))),
            SpawnGroup.CREATURE,
            SUMO_WRESTLER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            MUTATED_ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CAVE_WORM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            SUMO_WRESTLER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}