package com.modgen.chancecubes;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import com.modgen.chancecubes.entity.WormEntity;
import com.modgen.chancecubes.entity.JapaenseSumoWrestlersThatAttackTheyEntity;


public class ModEntities {
    public static final EntityType<WormEntity> WORM = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ChanceCubes.MOD_ID, "worm"),
        EntityType.Builder.create(WormEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );

    public static final EntityType<JapaenseSumoWrestlersThatAttackTheyEntity> JAPAENSE_SUMO_WRESTLERS_THAT_ATTACK_THEY = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(ChanceCubes.MOD_ID, "japaense_sumo_wrestlers_that_attack_they"),
        EntityType.Builder.create(JapaenseSumoWrestlersThatAttackTheyEntity::new, SpawnGroup.MONSTER)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        ChanceCubes.LOGGER.info("Registering entities for " + ChanceCubes.MOD_ID);
        FabricDefaultAttributeRegistry.register(WORM, WormEntity.createMobAttributes());
        FabricDefaultAttributeRegistry.register(JAPAENSE_SUMO_WRESTLERS_THAT_ATTACK_THEY, JapaenseSumoWrestlersThatAttackTheyEntity.createMobAttributes());

        
        // No mobs configured for natural spawning
    }
}