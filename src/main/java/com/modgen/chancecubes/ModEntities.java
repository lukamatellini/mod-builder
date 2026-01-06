package com.modgen.chancecubes;

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
import com.modgen.chancecubes.entity.LuckyGoblinEntity;
import com.modgen.chancecubes.entity.UnluckyZombieEntity;


public class ModEntities {
    public static final EntityType<LuckyGoblinEntity> LUCKY_GOBLIN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ChanceCubes.MOD_ID, "lucky_goblin"),
        EntityType.Builder.create(LuckyGoblinEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<UnluckyZombieEntity> UNLUCKY_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ChanceCubes.MOD_ID, "unlucky_zombie"),
        EntityType.Builder.create(UnluckyZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        ChanceCubes.LOGGER.info("Registering entities for " + ChanceCubes.MOD_ID);
        FabricDefaultAttributeRegistry.register(LUCKY_GOBLIN, LuckyGoblinEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(UNLUCKY_ZOMBIE, UnluckyZombieEntity.createMobAttributes());

        
        // === NATURAL MOB SPAWNING ===
        ChanceCubes.LOGGER.info("Registering natural spawn rules for 2 mobs");
        
        // Natural spawn for Lucky Goblin
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            LUCKY_GOBLIN,
            10,
            1,
            3
        );

        // Natural spawn for Unlucky Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            UNLUCKY_ZOMBIE,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            LUCKY_GOBLIN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            UNLUCKY_ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}