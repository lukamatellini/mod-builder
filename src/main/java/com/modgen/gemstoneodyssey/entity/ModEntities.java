package com.modgen.gemstoneodyssey.entity;

import com.modgen.gemstoneodyssey.GemstoneOdyssey;
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
import com.modgen.gemstoneodyssey.entity.FrostElementalEntity;
import com.modgen.gemstoneodyssey.entity.ShadowWolfEntity;
import com.modgen.gemstoneodyssey.entity.CrystalGolemEntity;
import com.modgen.gemstoneodyssey.entity.AncientDragonEntity;
import com.modgen.gemstoneodyssey.entity.FireElementalEntity;
import com.modgen.gemstoneodyssey.entity.UnicornEntity;
import com.modgen.gemstoneodyssey.entity.PirateEntity;
import com.modgen.gemstoneodyssey.entity.BenevolentFloatingCreatureEntity;

public class ModEntities {
    public static final EntityType<FrostElementalEntity> FROST_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "frost_elemental"),
        EntityType.Builder.create(FrostElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowWolfEntity> SHADOW_WOLF = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "shadow_wolf"),
        EntityType.Builder.create(ShadowWolfEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<AncientDragonEntity> ANCIENT_DRAGON = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "ancient_dragon"),
        EntityType.Builder.create(AncientDragonEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<FireElementalEntity> FIRE_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "fire_elemental"),
        EntityType.Builder.create(FireElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<UnicornEntity> UNICORN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "unicorn"),
        EntityType.Builder.create(UnicornEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<PirateEntity> PIRATE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "pirate"),
        EntityType.Builder.create(PirateEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<BenevolentFloatingCreatureEntity> BENEVOLENT_FLOATING_CREATURE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "benevolent_floating_creature"),
        EntityType.Builder.create(BenevolentFloatingCreatureEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        GemstoneOdyssey.LOGGER.info("Registering entities for " + GemstoneOdyssey.MOD_ID);
        FabricDefaultAttributeRegistry.register(FROST_ELEMENTAL, FrostElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_WOLF, ShadowWolfEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ANCIENT_DRAGON, AncientDragonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(FIRE_ELEMENTAL, FireElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(UNICORN, UnicornEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(PIRATE, PirateEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(BENEVOLENT_FLOATING_CREATURE, BenevolentFloatingCreatureEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        GemstoneOdyssey.LOGGER.info("Registering natural spawn rules for 8 mobs");
        
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
            ANCIENT_DRAGON,
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

        // Natural spawn for Unicorn
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            UNICORN,
            10,
            1,
            3
        );

        // Natural spawn for Pirate
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            PIRATE,
            10,
            1,
            3
        );

        // Natural spawn for Benevolent Floating Creature
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            BENEVOLENT_FLOATING_CREATURE,
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
            ANCIENT_DRAGON,
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
            UNICORN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            PIRATE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            BENEVOLENT_FLOATING_CREATURE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}