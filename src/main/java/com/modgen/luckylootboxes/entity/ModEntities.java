package com.modgen.luckylootboxes.entity;

import com.modgen.luckylootboxes.LuckyLootBoxes;
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
import com.modgen.luckylootboxes.entity.ZombieEntity;
import com.modgen.luckylootboxes.entity.SkeletonEntity;
import com.modgen.luckylootboxes.entity.CreeperEntity;
import com.modgen.luckylootboxes.entity.EndermanEntity;
import com.modgen.luckylootboxes.entity.VexEntity;
import com.modgen.luckylootboxes.entity.EvokerEntity;

public class ModEntities {
    public static final EntityType<ZombieEntity> ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBoxes.MOD_ID, "zombie"),
        EntityType.Builder.create(ZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<SkeletonEntity> SKELETON = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBoxes.MOD_ID, "skeleton"),
        EntityType.Builder.create(SkeletonEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CreeperEntity> CREEPER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBoxes.MOD_ID, "creeper"),
        EntityType.Builder.create(CreeperEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<EndermanEntity> ENDERMAN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBoxes.MOD_ID, "enderman"),
        EntityType.Builder.create(EndermanEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VexEntity> VEX = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBoxes.MOD_ID, "vex"),
        EntityType.Builder.create(VexEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<EvokerEntity> EVOKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBoxes.MOD_ID, "evoker"),
        EntityType.Builder.create(EvokerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        LuckyLootBoxes.LOGGER.info("Registering entities for " + LuckyLootBoxes.MOD_ID);
        FabricDefaultAttributeRegistry.register(ZOMBIE, ZombieEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SKELETON, SkeletonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CREEPER, CreeperEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ENDERMAN, EndermanEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VEX, VexEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(EVOKER, EvokerEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        LuckyLootBoxes.LOGGER.info("Registering natural spawn rules for 6 mobs");
        
        // Natural spawn for Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            ZOMBIE,
            10,
            1,
            3
        );

        // Natural spawn for Skeleton
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SKELETON,
            10,
            1,
            3
        );

        // Natural spawn for Creeper
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CREEPER,
            10,
            1,
            3
        );

        // Natural spawn for Enderman
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            ENDERMAN,
            10,
            1,
            3
        );

        // Natural spawn for Vex
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VEX,
            10,
            1,
            3
        );

        // Natural spawn for Evoker
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            EVOKER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            SKELETON,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CREEPER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            ENDERMAN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            VEX,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            EVOKER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}