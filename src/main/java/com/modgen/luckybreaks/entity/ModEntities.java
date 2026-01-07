package com.modgen.luckybreaks.entity;

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
import com.modgen.luckybreaks.entity.ZombieIronArmorEntity;
import com.modgen.luckybreaks.entity.SkeletonEnchantedBowEntity;
import com.modgen.luckybreaks.entity.SpiderSkeletonRiderEntity;
import com.modgen.luckybreaks.entity.SpiderWitherSkeletonRiderEntity;

public class ModEntities {
    public static final EntityType<ZombieIronArmorEntity> ZOMBIE_IRON_ARMOR = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyBreaks.MOD_ID, "zombie_iron_armor"),
        EntityType.Builder.create(ZombieIronArmorEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<SkeletonEnchantedBowEntity> SKELETON_ENCHANTED_BOW = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyBreaks.MOD_ID, "skeleton_enchanted_bow"),
        EntityType.Builder.create(SkeletonEnchantedBowEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<SpiderSkeletonRiderEntity> SPIDER_SKELETON_RIDER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyBreaks.MOD_ID, "spider_skeleton_rider"),
        EntityType.Builder.create(SpiderSkeletonRiderEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<SpiderWitherSkeletonRiderEntity> SPIDER_WITHER_SKELETON_RIDER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyBreaks.MOD_ID, "spider_wither_skeleton_rider"),
        EntityType.Builder.create(SpiderWitherSkeletonRiderEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        LuckyBreaks.LOGGER.info("Registering entities for " + LuckyBreaks.MOD_ID);
        FabricDefaultAttributeRegistry.register(ZOMBIE_IRON_ARMOR, ZombieIronArmorEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SKELETON_ENCHANTED_BOW, SkeletonEnchantedBowEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SPIDER_SKELETON_RIDER, SpiderSkeletonRiderEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SPIDER_WITHER_SKELETON_RIDER, SpiderWitherSkeletonRiderEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        LuckyBreaks.LOGGER.info("Registering natural spawn rules for 4 mobs");
        
        // Natural spawn for Zombie (Iron Armor)
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            ZOMBIE_IRON_ARMOR,
            10,
            1,
            3
        );

        // Natural spawn for Skeleton (Enchanted Bow)
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SKELETON_ENCHANTED_BOW,
            10,
            1,
            3
        );

        // Natural spawn for Spider (Skeleton Rider)
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SPIDER_SKELETON_RIDER,
            10,
            1,
            3
        );

        // Natural spawn for Spider (Wither Skeleton Rider)
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SPIDER_WITHER_SKELETON_RIDER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            ZOMBIE_IRON_ARMOR,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            SKELETON_ENCHANTED_BOW,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            SPIDER_SKELETON_RIDER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            SPIDER_WITHER_SKELETON_RIDER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}