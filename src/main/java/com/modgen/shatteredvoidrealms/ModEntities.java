package com.modgen.shatteredvoidrealms;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.shatteredvoidrealms.entity.VoidWraithBossEntity;
import com.modgen.shatteredvoidrealms.entity.CrystalGolemEntity;
import com.modgen.shatteredvoidrealms.entity.ShadowStalkerEntity;
import com.modgen.shatteredvoidrealms.entity.VoidLeechEntity;
import com.modgen.shatteredvoidrealms.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<VoidWraithBossEntity> VOID_WRAITH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredVoidRealms.MOD_ID, "void_wraith"),
        EntityType.Builder.create(VoidWraithBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );

    public static final EntityType<CrystalGolemEntity> CRYSTAL_GOLEM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredVoidRealms.MOD_ID, "crystal_golem"),
        EntityType.Builder.create(CrystalGolemEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<ShadowStalkerEntity> SHADOW_STALKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredVoidRealms.MOD_ID, "shadow_stalker"),
        EntityType.Builder.create(ShadowStalkerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<VoidLeechEntity> VOID_LEECH = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredVoidRealms.MOD_ID, "void_leech"),
        EntityType.Builder.create(VoidLeechEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ShatteredVoidRealms.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        ShatteredVoidRealms.LOGGER.info("Registering entities for " + ShatteredVoidRealms.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOID_WRAITH, VoidWraithBossEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(CRYSTAL_GOLEM, CrystalGolemEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(SHADOW_STALKER, ShadowStalkerEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(VOID_LEECH, VoidLeechEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
    }
}