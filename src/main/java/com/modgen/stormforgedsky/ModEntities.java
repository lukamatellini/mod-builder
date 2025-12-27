package com.modgen.stormforgedsky;

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
import com.modgen.stormforgedsky.entity.SkyWatcherEntity;


public class ModEntities {
    public static final EntityType<SkyWatcherEntity> SKY_WATCHER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(StormforgedSky.MOD_ID, "sky_watcher"),
        EntityType.Builder.create(SkyWatcherEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        StormforgedSky.LOGGER.info("Registering entities for " + StormforgedSky.MOD_ID);
        FabricDefaultAttributeRegistry.register(SKY_WATCHER, SkyWatcherEntity.createMobAttributes());

        
        // === NATURAL MOB SPAWNING ===
        StormforgedSky.LOGGER.info("Registering natural spawn rules for 1 mobs");
        
        // Natural spawn for Sky Watcher
        BiomeModifications.addSpawn(
            BiomeSelectors.includeByKey(net.minecraft.registry.RegistryKey.of(net.minecraft.registry.RegistryKeys.BIOME, Identifier.of("minecraft", "plains"))),
            SpawnGroup.MONSTER,
            SKY_WATCHER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            SKY_WATCHER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}