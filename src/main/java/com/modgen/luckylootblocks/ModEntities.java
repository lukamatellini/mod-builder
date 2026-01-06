package com.modgen.luckylootblocks;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import com.modgen.luckylootblocks.entity.WormEntity;
import com.modgen.luckylootblocks.entity.JapaneseSumoWresteersEntity;


public class ModEntities {
    public static final EntityType<WormEntity> WORM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "worm"),
        EntityType.Builder.create(WormEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<JapaneseSumoWresteersEntity> JAPANESE_SUMO_WRESTEERS = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(LuckyLootBlocks.MOD_ID, "japanese_sumo_wresteers"),
        EntityType.Builder.create(JapaneseSumoWresteersEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        LuckyLootBlocks.LOGGER.info("Registering entities for " + LuckyLootBlocks.MOD_ID);
        FabricDefaultAttributeRegistry.register(WORM, WormEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(JAPANESE_SUMO_WRESTEERS, JapaneseSumoWresteersEntity.createMobAttributes());

        
        // No mobs configured for natural spawning
    }
}