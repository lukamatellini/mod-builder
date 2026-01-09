package com.modgen.twilightgemcraft.entity;

import com.modgen.twilightgemcraft.TwilightGemcraft;
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
import com.modgen.twilightgemcraft.entity.NightProwlerEntity;

public class ModEntities {
    public static final EntityType<NightProwlerEntity> NIGHT_PROWLER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(TwilightGemcraft.MOD_ID, "night_prowler"),
        EntityType.Builder.create(NightProwlerEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static void registerEntities() {
        TwilightGemcraft.LOGGER.info("Registering entities for " + TwilightGemcraft.MOD_ID);
        FabricDefaultAttributeRegistry.register(NIGHT_PROWLER, NightProwlerEntity.createMobAttributes());
        
        // === NATURAL MOB SPAWNING ===
        TwilightGemcraft.LOGGER.info("Registering natural spawn rules for 1 mobs");
        
        // Natural spawn for Night Prowler
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            NIGHT_PROWLER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            NIGHT_PROWLER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}