package com.modgen.fortunesfolly;

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
import com.modgen.fortunesfolly.entity.LuckyChickenEntity;
import com.modgen.fortunesfolly.entity.LuckyPigEntity;
import com.modgen.fortunesfolly.entity.JapaneseSumoWrestelrsEntity;
import com.modgen.fortunesfolly.entity.WormsSpawnEntity;


public class ModEntities {
    public static final EntityType<LuckyChickenEntity> LUCKY_CHICKEN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(FortunesFolly.MOD_ID, "lucky_chicken"),
        EntityType.Builder.create(LuckyChickenEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<LuckyPigEntity> LUCKY_PIG = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(FortunesFolly.MOD_ID, "lucky_pig"),
        EntityType.Builder.create(LuckyPigEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<JapaneseSumoWrestelrsEntity> JAPANESE_SUMO_WRESTELRS = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(FortunesFolly.MOD_ID, "japanese_sumo_wrestelrs"),
        EntityType.Builder.create(JapaneseSumoWrestelrsEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<WormsSpawnEntity> WORMS_SPAWN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(FortunesFolly.MOD_ID, "worms_spawn"),
        EntityType.Builder.create(WormsSpawnEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        FortunesFolly.LOGGER.info("Registering entities for " + FortunesFolly.MOD_ID);
        FabricDefaultAttributeRegistry.register(LUCKY_CHICKEN, LuckyChickenEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(LUCKY_PIG, LuckyPigEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(JAPANESE_SUMO_WRESTELRS, JapaneseSumoWrestelrsEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(WORMS_SPAWN, WormsSpawnEntity.createMobAttributes());

        
        // === NATURAL MOB SPAWNING ===
        FortunesFolly.LOGGER.info("Registering natural spawn rules for 2 mobs");
        
        // Natural spawn for Lucky Chicken
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            LUCKY_CHICKEN,
            10,
            1,
            3
        );

        // Natural spawn for Lucky Pig
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            LUCKY_PIG,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            LUCKY_CHICKEN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            LUCKY_PIG,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}