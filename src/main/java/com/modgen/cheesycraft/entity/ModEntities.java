package com.modgen.cheesycraft.entity;

import com.modgen.cheesycraft.Cheesycraft;
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
import com.modgen.cheesycraft.entity.MouseEntity;
import com.modgen.cheesycraft.entity.RatEntity;
import com.modgen.cheesycraft.entity.CheesyGolemEntity;

public class ModEntities {
    public static final EntityType<MouseEntity> MOUSE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Cheesycraft.MOD_ID, "mouse"),
        EntityType.Builder.create(MouseEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<RatEntity> RAT = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Cheesycraft.MOD_ID, "rat"),
        EntityType.Builder.create(RatEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CheesyGolemEntity> CHEESY_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(Cheesycraft.MOD_ID, "cheesy_golem"),
        EntityType.Builder.create(CheesyGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        Cheesycraft.LOGGER.info("Registering entities for " + Cheesycraft.MOD_ID);
        FabricDefaultAttributeRegistry.register(MOUSE, MouseEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(RAT, RatEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CHEESY_GOLEM, CheesyGolemEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        Cheesycraft.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Mouse
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            MOUSE,
            10,
            1,
            3
        );

        // Natural spawn for Rat
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            RAT,
            10,
            1,
            3
        );

        // Natural spawn for Cheesy Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            CHEESY_GOLEM,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            MOUSE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            RAT,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CHEESY_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}