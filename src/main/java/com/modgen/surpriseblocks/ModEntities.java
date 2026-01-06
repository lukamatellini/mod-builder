package com.modgen.surpriseblocks;

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
import com.modgen.surpriseblocks.entity.UnluckyGoblinEntity;
import com.modgen.surpriseblocks.entity.WormEntity;
import com.modgen.surpriseblocks.entity.JapaneseSumoWrestlersThatAttackTillKillThemEntity;


public class ModEntities {
    public static final EntityType<UnluckyGoblinEntity> UNLUCKY_GOBLIN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SurpriseBlocks.MOD_ID, "unlucky_goblin"),
        EntityType.Builder.create(UnluckyGoblinEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<WormEntity> WORM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SurpriseBlocks.MOD_ID, "worm"),
        EntityType.Builder.create(WormEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<JapaneseSumoWrestlersThatAttackTillKillThemEntity> JAPANESE_SUMO_WRESTLERS_THAT_ATTACK_TILL_KILL_THEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SurpriseBlocks.MOD_ID, "japanese_sumo_wrestlers_that_attack_till_kill_them"),
        EntityType.Builder.create(JapaneseSumoWrestlersThatAttackTillKillThemEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        SurpriseBlocks.LOGGER.info("Registering entities for " + SurpriseBlocks.MOD_ID);
        FabricDefaultAttributeRegistry.register(UNLUCKY_GOBLIN, UnluckyGoblinEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(WORM, WormEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(JAPANESE_SUMO_WRESTLERS_THAT_ATTACK_TILL_KILL_THEM, JapaneseSumoWrestlersThatAttackTillKillThemEntity.createMobAttributes());

        
        // === NATURAL MOB SPAWNING ===
        SurpriseBlocks.LOGGER.info("Registering natural spawn rules for 1 mobs");
        
        // Natural spawn for Unlucky Goblin
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            UNLUCKY_GOBLIN,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            UNLUCKY_GOBLIN,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}