package com.modgen.romanlegions;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.romanlegions.entity.LegionaryNpcEntity;
import com.modgen.romanlegions.entity.BarbarianWarriorEntity;
import com.modgen.romanlegions.entity.BarbarianBruteEntity;
import com.modgen.romanlegions.entity.BarbarianShamanEntity;
import com.modgen.romanlegions.entity.ModGenNPCEntity;

public class ModEntities {
    public static final EntityType<LegionaryNpcEntity> LEGIONARY_NPC = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanLegions.MOD_ID, "legionary_npc"),
        EntityType.Builder.create(LegionaryNpcEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<BarbarianWarriorEntity> BARBARIAN_WARRIOR = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanLegions.MOD_ID, "barbarian_warrior"),
        EntityType.Builder.create(BarbarianWarriorEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<BarbarianBruteEntity> BARBARIAN_BRUTE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanLegions.MOD_ID, "barbarian_brute"),
        EntityType.Builder.create(BarbarianBruteEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<BarbarianShamanEntity> BARBARIAN_SHAMAN = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanLegions.MOD_ID, "barbarian_shaman"),
        EntityType.Builder.create(BarbarianShamanEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    // NPC Entity Type - for spawning via /modgen spawnnpc
    public static final EntityType<ModGenNPCEntity> NPC_ENTITY_TYPE = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanLegions.MOD_ID, "npc"),
        EntityType.Builder.create(ModGenNPCEntity::new, SpawnGroup.MISC)
            .dimensions(0.6f, 1.95f)
            .build()
    );

    public static void registerEntities() {
        RomanLegions.LOGGER.info("Registering entities for " + RomanLegions.MOD_ID);
        FabricDefaultAttributeRegistry.register(LEGIONARY_NPC, LegionaryNpcEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BARBARIAN_WARRIOR, BarbarianWarriorEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BARBARIAN_BRUTE, BarbarianBruteEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(BARBARIAN_SHAMAN, BarbarianShamanEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(NPC_ENTITY_TYPE, ModGenNPCEntity.createAttributes());
    }
}