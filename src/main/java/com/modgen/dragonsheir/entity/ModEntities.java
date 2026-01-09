package com.modgen.dragonsheir.entity;

import com.modgen.dragonsheir.DragonsHeir;
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
import com.modgen.dragonsheir.entity.FrostElementalEntity;
import com.modgen.dragonsheir.entity.ShadowWolfEntity;
import com.modgen.dragonsheir.entity.CrystalGolemEntity;
import com.modgen.dragonsheir.entity.AncientDragonBossEntity;
import com.modgen.dragonsheir.entity.DragonlingEntity;
import com.modgen.dragonsheir.entity.FireElementalEntity;
import com.modgen.dragonsheir.entity.ScorpionEntity;
import com.modgen.dragonsheir.entity.UnicornEntity;

public class ModEntities {
    public static final EntityType<FrostElementalEntity> FROST_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "frost_elemental"),
        EntityType.Builder.create(FrostElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowWolfEntity> SHADOW_WOLF = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "shadow_wolf"),
        EntityType.Builder.create(ShadowWolfEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<AncientDragonBossEntity> ANCIENT_DRAGON_BOSS = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "ancient_dragon_boss"),
        EntityType.Builder.create(AncientDragonBossEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<DragonlingEntity> DRAGONLING = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "dragonling"),
        EntityType.Builder.create(DragonlingEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<FireElementalEntity> FIRE_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "fire_elemental"),
        EntityType.Builder.create(FireElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ScorpionEntity> SCORPION = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "scorpion"),
        EntityType.Builder.create(ScorpionEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<UnicornEntity> UNICORN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(DragonsHeir.MOD_ID, "unicorn"),
        EntityType.Builder.create(UnicornEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        DragonsHeir.LOGGER.info("Registering entities for " + DragonsHeir.MOD_ID);
        FabricDefaultAttributeRegistry.register(FROST_ELEMENTAL, FrostElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_WOLF, ShadowWolfEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ANCIENT_DRAGON_BOSS, AncientDragonBossEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(DRAGONLING, DragonlingEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(FIRE_ELEMENTAL, FireElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SCORPION, ScorpionEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(UNICORN, UnicornEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        DragonsHeir.LOGGER.info("Registering natural spawn rules for 8 mobs");
        
        // Natural spawn for Frost Elemental
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            FROST_ELEMENTAL,
            10,
            1,
            3
        );

        // Natural spawn for Shadow Wolf
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            SHADOW_WOLF,
            10,
            1,
            3
        );

        // Natural spawn for Crystal Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            CRYSTAL_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Ancient Dragon
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            ANCIENT_DRAGON_BOSS,
            10,
            1,
            3
        );

        // Natural spawn for Dragonling
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            DRAGONLING,
            10,
            1,
            3
        );

        // Natural spawn for Fire Elemental
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            FIRE_ELEMENTAL,
            10,
            1,
            3
        );

        // Natural spawn for Scorpion
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            SCORPION,
            10,
            1,
            3
        );

        // Natural spawn for Unicorn
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            UNICORN,
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
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            CRYSTAL_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            ANCIENT_DRAGON_BOSS,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            DRAGONLING,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            FIRE_ELEMENTAL,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            SCORPION,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            UNICORN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}