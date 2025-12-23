package com.modgen.aetheriaascendant;

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
import com.modgen.aetheriaascendant.entity.AetherGolemEntity;
import com.modgen.aetheriaascendant.entity.CloudSerpentEntity;
import com.modgen.aetheriaascendant.entity.CelestialGuardianBossEntity;
import com.modgen.aetheriaascendant.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<AetherGolemEntity> AETHER_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetheriaAscendant.MOD_ID, "aether_golem"),
        EntityType.Builder.create(AetherGolemEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(AetheriaAscendant.MOD_ID, "aether_golem")))
    );

    public static final EntityType<CloudSerpentEntity> CLOUD_SERPENT = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetheriaAscendant.MOD_ID, "cloud_serpent"),
        EntityType.Builder.create(CloudSerpentEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(AetheriaAscendant.MOD_ID, "cloud_serpent")))
    );

    public static final EntityType<CelestialGuardianBossEntity> CELESTIAL_GUARDIAN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetheriaAscendant.MOD_ID, "celestial_guardian"),
        EntityType.Builder.create(CelestialGuardianBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(AetheriaAscendant.MOD_ID, "celestial_guardian")))
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AetheriaAscendant.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(AetheriaAscendant.MOD_ID, "npc")))
    );

    public static void registerEntities() {
        AetheriaAscendant.LOGGER.info("Registering entities for " + AetheriaAscendant.MOD_ID);
        FabricDefaultAttributeRegistry.register(AETHER_GOLEM, AetherGolemEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CLOUD_SERPENT, CloudSerpentEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CELESTIAL_GUARDIAN, CelestialGuardianBossEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
        
        // === NATURAL MOB SPAWNING ===
        AetheriaAscendant.LOGGER.info("Registering natural spawn rules for 2 mobs");
        
        // Natural spawn for Aether Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            AETHER_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Cloud Serpent
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CLOUD_SERPENT,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            AETHER_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CLOUD_SERPENT,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}