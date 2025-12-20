package com.modgen.arcaneessentials;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import com.modgen.arcaneessentials.entity.DeepLurkerEntity;


public class ModEntities {
    public static final EntityType<DeepLurkerEntity> DEEP_LURKER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ArcaneEssentials.MOD_ID, "deep_lurker"),
        EntityType.Builder.create(DeepLurkerEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        ArcaneEssentials.LOGGER.info("Registering entities for " + ArcaneEssentials.MOD_ID);
        FabricDefaultAttributeRegistry.register(DEEP_LURKER, DeepLurkerEntity.createAttributes());

    }
}