package com.modgen.sumoundeadworms.entity;

import com.modgen.sumoundeadworms.SumoUndeadWorms;
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
import com.modgen.sumoundeadworms.entity.YokaiZombieEntity;
import com.modgen.sumoundeadworms.entity.BurrowingWormEntity;
import com.modgen.sumoundeadworms.entity.JapaneseSumoWrestlerEntity;

public class ModEntities {
    public static final EntityType<YokaiZombieEntity> YOKAI_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SumoUndeadWorms.MOD_ID, "yokai_zombie"),
        EntityType.Builder.create(YokaiZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<BurrowingWormEntity> BURROWING_WORM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SumoUndeadWorms.MOD_ID, "burrowing_worm"),
        EntityType.Builder.create(BurrowingWormEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<JapaneseSumoWrestlerEntity> JAPANESE_SUMO_WRESTLER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SumoUndeadWorms.MOD_ID, "japanese_sumo_wrestler"),
        EntityType.Builder.create(JapaneseSumoWrestlerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        SumoUndeadWorms.LOGGER.info("Registering entities for " + SumoUndeadWorms.MOD_ID);
        FabricDefaultAttributeRegistry.register(YOKAI_ZOMBIE, YokaiZombieEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(BURROWING_WORM, BurrowingWormEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(JAPANESE_SUMO_WRESTLER, JapaneseSumoWrestlerEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        SumoUndeadWorms.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Yokai Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            YOKAI_ZOMBIE,
            10,
            1,
            3
        );

        // Natural spawn for Burrowing Worm
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.MONSTER,
            BURROWING_WORM,
            10,
            1,
            3
        );

        // Natural spawn for Japanese Sumo Wrestler
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            JAPANESE_SUMO_WRESTLER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            YOKAI_ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            BURROWING_WORM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            JAPANESE_SUMO_WRESTLER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}