package com.modgen.voidechoes;

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
import com.modgen.voidechoes.entity.VoidlingEntity;
import com.modgen.voidechoes.entity.EchoBatEntity;


public class ModEntities {
    public static final EntityType<VoidlingEntity> VOIDLING = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidEchoes.MOD_ID, "voidling"),
        EntityType.Builder.create(VoidlingEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<EchoBatEntity> ECHO_BAT = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidEchoes.MOD_ID, "echo_bat"),
        EntityType.Builder.create(EchoBatEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        VoidEchoes.LOGGER.info("Registering entities for " + VoidEchoes.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOIDLING, VoidlingEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ECHO_BAT, EchoBatEntity.createAttributes());

        
        // === NATURAL MOB SPAWNING ===
        VoidEchoes.LOGGER.info("Registering natural spawn rules for 2 mobs");
        
        // Natural spawn for Voidling
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOIDLING,
            10,
            1,
            3
        );

        // Natural spawn for Echo Bat
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            ECHO_BAT,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            VOIDLING,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            ECHO_BAT,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}