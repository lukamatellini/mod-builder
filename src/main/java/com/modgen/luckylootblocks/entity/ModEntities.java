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
import com.modgen.luckylootblocks.entity.ReinforcedZombieEntity;
import com.modgen.luckylootblocks.entity.ReinforcedSkeletonEntity;

public class ModEntities {
    public static final EntityType<ReinforcedZombieEntity> REINFORCED_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "reinforced_zombie"),
        EntityType.Builder.create(ReinforcedZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ReinforcedSkeletonEntity> REINFORCED_SKELETON = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "reinforced_skeleton"),
        EntityType.Builder.create(ReinforcedSkeletonEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        LuckyLootBlocks.LOGGER.info("Registering entities for " + LuckyLootBlocks.MOD_ID);
        FabricDefaultAttributeRegistry.register(REINFORCED_ZOMBIE, ReinforcedZombieEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(REINFORCED_SKELETON, ReinforcedSkeletonEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        LuckyLootBlocks.LOGGER.info("Registering natural spawn rules for 2 mobs");
        
        // Natural spawn for Reinforced Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            REINFORCED_ZOMBIE,
            10,
            1,
            3
        );

        // Natural spawn for Reinforced Skeleton
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            REINFORCED_SKELETON,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            REINFORCED_ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            REINFORCED_SKELETON,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}