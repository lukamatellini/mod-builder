package com.modgen.swiftstrideboots;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.swiftstrideboots.entity.VelocityWeaverEntity;


public class ModEntities {
    public static final EntityType<VelocityWeaverEntity> VELOCITY_WEAVER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(SwiftstrideBoots.MOD_ID, "velocity_weaver"),
        EntityType.Builder.create(VelocityWeaverEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        SwiftstrideBoots.LOGGER.info("Registering entities for " + SwiftstrideBoots.MOD_ID);
        FabricDefaultAttributeRegistry.register(VELOCITY_WEAVER, VelocityWeaverEntity.createAttributes());

    }
}