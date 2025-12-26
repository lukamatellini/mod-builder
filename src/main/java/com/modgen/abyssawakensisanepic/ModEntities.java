package com.modgen.abyssawakensisanepic;

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
import com.modgen.abyssawakensisanepic.entity.VoidCrawlerEntity;
import com.modgen.abyssawakensisanepic.entity.ShadowWraithEntity;
import com.modgen.abyssawakensisanepic.entity.CrystalGolemEntity;
import com.modgen.abyssawakensisanepic.entity.AbyssalLurkerEntity;
import com.modgen.abyssawakensisanepic.entity.CorruptedVillagerEntity;
import com.modgen.abyssawakensisanepic.entity.TheVoidKingBossEntity;
import com.modgen.abyssawakensisanepic.entity.VoidCommanderEntity;
import com.modgen.abyssawakensisanepic.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<VoidCrawlerEntity> VOID_CRAWLER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "void_crawler"),
        EntityType.Builder.create(VoidCrawlerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowWraithEntity> SHADOW_WRAITH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "shadow_wraith"),
        EntityType.Builder.create(ShadowWraithEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<AbyssalLurkerEntity> ABYSSAL_LURKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "abyssal_lurker"),
        EntityType.Builder.create(AbyssalLurkerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CorruptedVillagerEntity> CORRUPTED_VILLAGER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "corrupted_villager"),
        EntityType.Builder.create(CorruptedVillagerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<TheVoidKingBossEntity> THE_VOID_KING = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "the_void_king"),
        EntityType.Builder.create(TheVoidKingBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<VoidCommanderEntity> VOID_COMMANDER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "void_commander"),
        EntityType.Builder.create(VoidCommanderEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        AbyssAwakensIsAnEpicAdventure.LOGGER.info("Registering entities for " + AbyssAwakensIsAnEpicAdventure.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOID_CRAWLER, VoidCrawlerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_WRAITH, ShadowWraithEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(ABYSSAL_LURKER, AbyssalLurkerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(CORRUPTED_VILLAGER, CorruptedVillagerEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(THE_VOID_KING, TheVoidKingBossEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(VOID_COMMANDER, VoidCommanderEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
        
        // === NATURAL MOB SPAWNING ===
        AbyssAwakensIsAnEpicAdventure.LOGGER.info("Registering natural spawn rules for 6 mobs");
        
        // Natural spawn for Void Crawler
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOID_CRAWLER,
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

        // Natural spawn for Crystal Golem
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CRYSTAL_GOLEM,
            10,
            1,
            3
        );

        // Natural spawn for Abyssal Lurker
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            ABYSSAL_LURKER,
            10,
            1,
            3
        );

        // Natural spawn for Corrupted Villager
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            CORRUPTED_VILLAGER,
            10,
            1,
            3
        );

        // Natural spawn for Void Commander
        BiomeModifications.addSpawn(
            BiomeSelectors.tag(net.minecraft.registry.tag.BiomeTags.IS_FOREST),
            SpawnGroup.MONSTER,
            VOID_COMMANDER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            VOID_CRAWLER,
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

        SpawnRestriction.register(
            CRYSTAL_GOLEM,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            ABYSSAL_LURKER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            CORRUPTED_VILLAGER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );

        SpawnRestriction.register(
            VOID_COMMANDER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            HostileEntity::canSpawnInDark
        );
    }
}