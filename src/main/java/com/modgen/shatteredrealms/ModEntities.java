package com.modgen.shatteredrealms;

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
import com.modgen.shatteredrealms.entity.VoidWalkerEntity;
import com.modgen.shatteredrealms.entity.CrystalGolemEntity;
import com.modgen.shatteredrealms.entity.ShadowWraithEntity;
import com.modgen.shatteredrealms.entity.TheVoidTitanBossEntity;
import com.modgen.shatteredrealms.entity.CrystalEmpressBossEntity;
import com.modgen.shatteredrealms.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<VoidWalkerEntity> VOID_WALKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredRealms.MOD_ID, "void_walker"),
        EntityType.Builder.create(VoidWalkerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredRealms.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowWraithEntity> SHADOW_WRAITH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredRealms.MOD_ID, "shadow_wraith"),
        EntityType.Builder.create(ShadowWraithEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<TheVoidTitanBossEntity> THE_VOID_TITAN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredRealms.MOD_ID, "the_void_titan"),
        EntityType.Builder.create(TheVoidTitanBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<CrystalEmpressBossEntity> CRYSTAL_EMPRESS = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredRealms.MOD_ID, "crystal_empress"),
        EntityType.Builder.create(CrystalEmpressBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredRealms.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        ShatteredRealms.LOGGER.info("Registering entities for " + ShatteredRealms.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOID_WALKER, VoidWalkerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_WRAITH, ShadowWraithEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(THE_VOID_TITAN, TheVoidTitanBossEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_EMPRESS, CrystalEmpressBossEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
        
        // === NATURAL MOB SPAWNING ===
        ShatteredRealms.LOGGER.info("Registering natural spawn rules for 3 mobs");
        
        // Natural spawn for Void Walker
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOID_WALKER,
            10,
            1,
            3
        );

        // Natural spawn for Crystal Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CRYSTAL_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Shadow Wraith
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            SHADOW_WRAITH,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            VOID_WALKER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CRYSTAL_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            SHADOW_WRAITH,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}