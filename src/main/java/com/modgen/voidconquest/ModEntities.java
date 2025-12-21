package com.modgen.voidconquest;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.voidconquest.entity.VoidWraithBossEntity;
import com.modgen.voidconquest.entity.CrystalGolemEntity;
import com.modgen.voidconquest.entity.ShadowStalkerEntity;
import com.modgen.voidconquest.entity.VoidLeechEntity;
import com.modgen.voidconquest.entity.CorruptedVillagerEntity;
import com.modgen.voidconquest.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<VoidWraithBossEntity> VOID_WRAITH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidConquest.MOD_ID, "void_wraith"),
        EntityType.Builder.create(VoidWraithBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidConquest.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowStalkerEntity> SHADOW_STALKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidConquest.MOD_ID, "shadow_stalker"),
        EntityType.Builder.create(ShadowStalkerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VoidLeechEntity> VOID_LEECH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidConquest.MOD_ID, "void_leech"),
        EntityType.Builder.create(VoidLeechEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<CorruptedVillagerEntity> CORRUPTED_VILLAGER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidConquest.MOD_ID, "corrupted_villager"),
        EntityType.Builder.create(CorruptedVillagerEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(VoidConquest.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        VoidConquest.LOGGER.info("Registering entities for " + VoidConquest.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOID_WRAITH, VoidWraithBossEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_STALKER, ShadowStalkerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(VOID_LEECH, VoidLeechEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CORRUPTED_VILLAGER, CorruptedVillagerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
    }
}