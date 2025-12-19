package com.modgen.romanempire;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.romanempire.entity.RomanLegionaryEntity;
import com.modgen.romanempire.entity.RomanCenturionEntity;
import com.modgen.romanempire.entity.RomanEmperorBossEntity;


public class ModEntities {
    public static final EntityType<RomanLegionaryEntity> ROMAN_LEGIONARY = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanEmpire.MOD_ID, "roman_legionary"),
        EntityType.Builder.create(RomanLegionaryEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<RomanCenturionEntity> ROMAN_CENTURION = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanEmpire.MOD_ID, "roman_centurion"),
        EntityType.Builder.create(RomanCenturionEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<RomanEmperorBossEntity> ROMAN_EMPEROR = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(RomanEmpire.MOD_ID, "roman_emperor"),
        EntityType.Builder.create(RomanEmperorBossEntity::new, SpawnGroup.MISC)
            .dimensions(0.8999999999999999f, 2.7f)
            .build()
    );


    public static void registerEntities() {
        RomanEmpire.LOGGER.info("Registering entities for " + RomanEmpire.MOD_ID);
        FabricDefaultAttributeRegistry.register(ROMAN_LEGIONARY, RomanLegionaryEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ROMAN_CENTURION, RomanCenturionEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(ROMAN_EMPEROR, RomanEmperorBossEntity.createAttributes());

    }
}