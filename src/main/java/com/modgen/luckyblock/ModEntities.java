package com.modgen.luckyblock;

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
import com.modgen.luckyblock.entity.LuckyZombieEntity;


public class ModEntities {
    public static final EntityType<LuckyZombieEntity> LUCKY_ZOMBIE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyBlock.MOD_ID, "lucky_zombie"),
        EntityType.Builder.create(LuckyZombieEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        LuckyBlock.LOGGER.info("Registering entities for " + LuckyBlock.MOD_ID);
        FabricDefaultAttributeRegistry.register(LUCKY_ZOMBIE, LuckyZombieEntity.createMobAttributes());

        
        // === NATURAL MOB SPAWNING ===
        LuckyBlock.LOGGER.info("Registering natural spawn rules for 1 mobs");
        
        // Natural spawn for Lucky Zombie
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            LUCKY_ZOMBIE,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            LUCKY_ZOMBIE,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}