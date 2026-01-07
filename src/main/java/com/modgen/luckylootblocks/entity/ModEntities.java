package com.modgen.luckylootblocks.entity;

import com.modgen.luckylootblocks.LuckyLootBlocks;
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
import com.modgen.luckylootblocks.entity.LuckyZombieEntity;
import com.modgen.luckylootblocks.entity.LuckySpiderEntity;
import com.modgen.luckylootblocks.entity.LuckyCreeperEntity;
import com.modgen.luckylootblocks.entity.LuckyCaveSpiderEntity;

public class ModEntities {
    public static final EntityType<LuckyZombieEntity> LUCKY_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "lucky_zombie"),
        EntityType.Builder.create(LuckyZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<LuckySpiderEntity> LUCKY_SPIDER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "lucky_spider"),
        EntityType.Builder.create(LuckySpiderEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<LuckyCreeperEntity> LUCKY_CREEPER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "lucky_creeper"),
        EntityType.Builder.create(LuckyCreeperEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<LuckyCaveSpiderEntity> LUCKY_CAVE_SPIDER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "lucky_cave_spider"),
        EntityType.Builder.create(LuckyCaveSpiderEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        LuckyLootBlocks.LOGGER.info("Registering entities for " + LuckyLootBlocks.MOD_ID);
        FabricDefaultAttributeRegistry.register(LUCKY_ZOMBIE, LuckyZombieEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(LUCKY_SPIDER, LuckySpiderEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(LUCKY_CREEPER, LuckyCreeperEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(LUCKY_CAVE_SPIDER, LuckyCaveSpiderEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        LuckyLootBlocks.LOGGER.info("Registering natural spawn rules for 4 mobs");
        
        // Natural spawn for Lucky Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            LUCKY_ZOMBIE,
            10,
            1,
            3
        );

        // Natural spawn for Lucky Spider
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            LUCKY_SPIDER,
            10,
            1,
            3
        );

        // Natural spawn for Lucky Creeper
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            LUCKY_CREEPER,
            10,
            1,
            3
        );

        // Natural spawn for Lucky Cave Spider
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            LUCKY_CAVE_SPIDER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            LUCKY_ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            LUCKY_SPIDER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            LUCKY_CREEPER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            LUCKY_CAVE_SPIDER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}