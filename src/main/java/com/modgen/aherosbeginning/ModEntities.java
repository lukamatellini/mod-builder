package com.modgen.aherosbeginning;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import com.modgen.aherosbeginning.entity.VoidWispEntity;
import com.modgen.aherosbeginning.entity.CrystalGolemEntity;
import com.modgen.aherosbeginning.entity.CrystalGuardianEntity;
import com.modgen.aherosbeginning.entity.VoidOverlordBossEntity;
import com.modgen.aherosbeginning.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<VoidWispEntity> VOID_WISP = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AHerosBeginning.MOD_ID, "void_wisp"),
        EntityType.Builder.create(VoidWispEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AHerosBeginning.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGuardianEntity> CRYSTAL_GUARDIAN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AHerosBeginning.MOD_ID, "crystal_guardian"),
        EntityType.Builder.create(CrystalGuardianEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VoidOverlordBossEntity> VOID_OVERLORD = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AHerosBeginning.MOD_ID, "void_overlord"),
        EntityType.Builder.create(VoidOverlordBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AHerosBeginning.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        AHerosBeginning.LOGGER.info("Registering entities for " + AHerosBeginning.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOID_WISP, VoidWispEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GUARDIAN, CrystalGuardianEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VOID_OVERLORD, VoidOverlordBossEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
        
        // === NATURAL MOB SPAWNING ===
        AHerosBeginning.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Void Wisp
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOID_WISP,
            10,
            1,
            3
        );

        // Natural spawn for Crystal Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CRYSTAL_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Crystal Guardian
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CRYSTAL_GUARDIAN,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            VOID_WISP,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CRYSTAL_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CRYSTAL_GUARDIAN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}