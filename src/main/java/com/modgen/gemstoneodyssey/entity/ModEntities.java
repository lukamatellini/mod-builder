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
import com.modgen.gemstoneodyssey.entity.GloomyGhoulEntity;
import com.modgen.gemstoneodyssey.entity.IceElementalEntity;
import com.modgen.gemstoneodyssey.entity.BlazeElementalEntity;
import com.modgen.gemstoneodyssey.entity.VoidfishEntity;
import com.modgen.gemstoneodyssey.entity.SkyGolemEntity;
import com.modgen.gemstoneodyssey.entity.IgnisTheAncientDragonEntity;
import com.modgen.gemstoneodyssey.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<GloomyGhoulEntity> GLOOMY_GHOUL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "gloomy_ghoul"),
        EntityType.Builder.create(GloomyGhoulEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<IceElementalEntity> ICE_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "ice_elemental"),
        EntityType.Builder.create(IceElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<BlazeElementalEntity> BLAZE_ELEMENTAL = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "blaze_elemental"),
        EntityType.Builder.create(BlazeElementalEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VoidfishEntity> VOIDFISH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "voidfish"),
        EntityType.Builder.create(VoidfishEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<SkyGolemEntity> SKY_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "sky_golem"),
        EntityType.Builder.create(SkyGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<IgnisTheAncientDragonEntity> IGNIS_THE_ANCIENT_DRAGON = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "ignis_the_ancient_dragon"),
        EntityType.Builder.create(IgnisTheAncientDragonEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );
    // === NPC Entity Type ===
    // CRITICAL: This MUST exist when client code references ModEntities.NPC_ENTITY_TYPE
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(GemstoneOdyssey.MOD_ID, "modgen_npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        GemstoneOdyssey.LOGGER.info("Registering entities for " + GemstoneOdyssey.MOD_ID);
        FabricDefaultAttributeRegistry.register(GLOOMY_GHOUL, GloomyGhoulEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ICE_ELEMENTAL, IceElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(BLAZE_ELEMENTAL, BlazeElementalEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VOIDFISH, VoidfishEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SKY_GOLEM, SkyGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(IGNIS_THE_ANCIENT_DRAGON, IgnisTheAncientDragonEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createNPCAttributes());
        
        // === NATURAL MOB SPAWNING ===
        GemstoneOdyssey.LOGGER.info("Registering natural spawn rules for 6 mobs");
        
        // Natural spawn for Gloomy Ghoul
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            GLOOMY_GHOUL,
            10,
            1,
            3
        );

        // Natural spawn for Ice Elemental
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            ICE_ELEMENTAL,
            10,
            1,
            3
        );

        // Natural spawn for Blaze Elemental
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            BLAZE_ELEMENTAL,
            10,
            1,
            3
        );

        // Natural spawn for Voidfish
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            VOIDFISH,
            10,
            1,
            3
        );

        // Natural spawn for Sky Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            SKY_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Ignis, the Ancient Dragon
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            IGNIS_THE_ANCIENT_DRAGON,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            GLOOMY_GHOUL,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            ICE_ELEMENTAL,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            BLAZE_ELEMENTAL,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            VOIDFISH,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            SKY_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            IGNIS_THE_ANCIENT_DRAGON,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}