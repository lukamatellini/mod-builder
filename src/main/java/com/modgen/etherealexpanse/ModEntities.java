package com.modgen.etherealexpanse;

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
import com.modgen.etherealexpanse.entity.VoidGliderEntity;


public class ModEntities {
    public static final EntityType<VoidGliderEntity> VOID_GLIDER = Registry.register(
        Registries.ENTITY_TYPE,
        Identifier.of(EtherealExpanse.MOD_ID, "void_glider"),
        EntityType.Builder.create(VoidGliderEntity::new, SpawnGroup.CREATURE)
            .dimensions(0.6f, 1.8f)
            .build()
    );


    public static void registerEntities() {
        EtherealExpanse.LOGGER.info("Registering entities for " + EtherealExpanse.MOD_ID);
        FabricDefaultAttributeRegistry.register(VOID_GLIDER, VoidGliderEntity.createMobAttributes());

        
        // === NATURAL MOB SPAWNING ===
        EtherealExpanse.LOGGER.info("Registering natural spawn rules for 1 mobs");
        
        // Natural spawn for Void Glider
        BiomeModifications.addSpawn(
            BiomeSelectors.foundInOverworld(),
            SpawnGroup.CREATURE,
            VOID_GLIDER,
            10,
            1,
            3
        );
        
        // === SPAWN RESTRICTIONS ===
        SpawnRestriction.register(
            VOID_GLIDER,
            SpawnLocationTypes.ON_GROUND,
            Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
            MobEntity::canMobSpawn
        );
    }
}