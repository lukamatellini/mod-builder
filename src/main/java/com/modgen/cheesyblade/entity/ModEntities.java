package com.modgen.cheesyblade.entity;

import com.modgen.cheesyblade.CheesyBlade;
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
import com.modgen.cheesyblade.entity.CheeseGolemEntity;
import com.modgen.cheesyblade.entity.HungryMouseEntity;

public class ModEntities {
    public static final EntityType<CheeseGolemEntity> CHEESE_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(CheesyBlade.MOD_ID, "cheese_golem"),
        EntityType.Builder.create(CheeseGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<HungryMouseEntity> HUNGRY_MOUSE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(CheesyBlade.MOD_ID, "hungry_mouse"),
        EntityType.Builder.create(HungryMouseEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        CheesyBlade.LOGGER.info("Registering entities for " + CheesyBlade.MOD_ID);
        FabricDefaultAttributeRegistry.register(CHEESE_GOLEM, CheeseGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(HUNGRY_MOUSE, HungryMouseEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        CheesyBlade.LOGGER.info("Registering natural spawn rules for 2 mobs");
        
        // Natural spawn for Cheese Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            CHEESE_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Hungry Mouse
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.CREATURE,
            HUNGRY_MOUSE,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            CHEESE_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );

        SpawnRestriction.register(
            HUNGRY_MOUSE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}