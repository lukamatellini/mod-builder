package com.modgen.shatteredconquest;

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
import com.modgen.shatteredconquest.entity.ShadowLordBossEntity;
import com.modgen.shatteredconquest.entity.CrystalGolemBossEntity;
import com.modgen.shatteredconquest.entity.VoidSerpentBossEntity;
import com.modgen.shatteredconquest.entity.ShadowMinionEntity;
import com.modgen.shatteredconquest.entity.VoidWalkerEntity;
import com.modgen.shatteredconquest.entity.VoidSerpentHatchlingEntity;
import com.modgen.shatteredconquest.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<ShadowLordBossEntity> SHADOW_LORD = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "shadow_lord"),
        EntityType.Builder.create(ShadowLordBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<CrystalGolemBossEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<VoidSerpentBossEntity> VOID_SERPENT = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "void_serpent"),
        EntityType.Builder.create(VoidSerpentBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<ShadowMinionEntity> SHADOW_MINION = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "shadow_minion"),
        EntityType.Builder.create(ShadowMinionEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VoidWalkerEntity> VOID_WALKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "void_walker"),
        EntityType.Builder.create(VoidWalkerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VoidSerpentHatchlingEntity> VOID_SERPENT_HATCHLING = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "void_serpent_hatchling"),
        EntityType.Builder.create(VoidSerpentHatchlingEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredConquest.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        ShatteredConquest.LOGGER.info("Registering entities for " + ShatteredConquest.MOD_ID);
        FabricDefaultAttributeRegistry.register(SHADOW_LORD, ShadowLordBossEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemBossEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VOID_SERPENT, VoidSerpentBossEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_MINION, ShadowMinionEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VOID_WALKER, VoidWalkerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VOID_SERPENT_HATCHLING, VoidSerpentHatchlingEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
        
        // === NATURAL MOB SPAWNING ===
        ShatteredConquest.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Shadow Minion
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SHADOW_MINION,
            10,
            1,
            3
        );

        // Natural spawn for Void Walker
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOID_WALKER,
            10,
            1,
            3
        );

        // Natural spawn for Void Serpent Hatchling
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOID_SERPENT_HATCHLING,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            SHADOW_MINION,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            VOID_WALKER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            VOID_SERPENT_HATCHLING,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}