package com.modgen.aetherfellarmory.entity;

import com.modgen.aetherfellarmory.AetherfellArmory;
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
import com.modgen.aetherfellarmory.entity.FrostElementalEntity;
import com.modgen.aetherfellarmory.entity.ShadowWolfEntity;
import com.modgen.aetherfellarmory.entity.CrystalGolemEntity;
import com.modgen.aetherfellarmory.entity.AncientDragonBossBossEntity;

public class ModEntities {
    public static final EntityType<FrostElementalEntity> FROST_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetherfellArmory.MOD_ID, "frost_elemental"),
        EntityType.Builder.create(FrostElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowWolfEntity> SHADOW_WOLF = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetherfellArmory.MOD_ID, "shadow_wolf"),
        EntityType.Builder.create(ShadowWolfEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetherfellArmory.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<AncientDragonBossBossEntity> ANCIENT_DRAGON_BOSS = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetherfellArmory.MOD_ID, "ancient_dragon_boss"),
        EntityType.Builder.create(AncientDragonBossBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.9f, 2.7f)
            .build()
    );

    public static void registerEntities() {
        AetherfellArmory.LOGGER.info("Registering entities for " + AetherfellArmory.MOD_ID);
        FabricDefaultAttributeRegistry.register(FROST_ELEMENTAL, FrostElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_WOLF, ShadowWolfEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ANCIENT_DRAGON_BOSS, AncientDragonBossBossEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        AetherfellArmory.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Frost Elemental
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            FROST_ELEMENTAL,
            10,
            1,
            3
        );

        // Natural spawn for Shadow Wolf
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SHADOW_WOLF,
            10,
            1,
            3
        );

        // Natural spawn for Crystal Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            CRYSTAL_GOLEM,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            FROST_ELEMENTAL,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            SHADOW_WOLF,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CRYSTAL_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}