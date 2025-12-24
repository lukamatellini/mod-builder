package com.modgen.shatteredrealmsreviv;

import com.modgen.shatteredrealmsreviv.engine.ModGenEngine;
import com.modgen.shatteredrealmsreviv.engine.BuildPlanValidator;
import com.modgen.shatteredrealmsreviv.command.ModGenCommand;
import com.modgen.shatteredrealmsreviv.engine.QuestEngine;
import com.modgen.shatteredrealmsreviv.engine.NPCManager;
import com.modgen.shatteredrealmsreviv.engine.StructureRegistry;
import com.modgen.shatteredrealmsreviv.network.ModNetworking;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShatteredRealmsRevival implements ModInitializer {
    public static final String MOD_ID = "shatteredrealmsreviv";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier ITEM_GROUP_ID = Identifier.of(MOD_ID, "main");
    
    // Engine instances - ONLY fields for enabled systems
    public static ModGenEngine ENGINE;
    public static BuildPlanValidator VALIDATOR;
    public static QuestEngine QUEST_ENGINE;
    public static NPCManager NPC_MANAGER;
    public static StructureRegistry STRUCTURE_REGISTRY;

    @Override
    public void onInitialize() {
        LOGGER.info("╔════════════════════════════════════════╗");
        LOGGER.info("║  Shattered Realms Revival              ║");
        LOGGER.info("║  Loading... (Fabric 1.21.x)            ║");
        LOGGER.info("╚════════════════════════════════════════╝");
        
        // Initialize engine and validator - ONLY enabled systems
        ENGINE = new ModGenEngine();
        VALIDATOR = new BuildPlanValidator();
        QUEST_ENGINE = new QuestEngine();
        NPC_MANAGER = new NPCManager();
        STRUCTURE_REGISTRY = new StructureRegistry();
        
        // Print enabled modules from build plan
        VALIDATOR.printEnabledModules();
        
        // Register sounds
        ModSounds.registerSounds();
        
        // Register server-side networking
        ModNetworking.registerServerPackets();

        // Register commands
        ModGenCommand.register();

        
        // Register items
        ModItems.registerItems();
        
        // Register creative tab
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_ID, 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.getFirstItem()))
                .displayName(Text.translatable("itemGroup." + MOD_ID + ".main"))
                .entries((context, entries) -> ModItems.addToCreativeTab(entries))
                .build()
        );
        LOGGER.info("  ✓ Registered 25 items");

        // Register entities (mobs + NPCs)
        ModEntities.registerEntities();
        LOGGER.info("  ✓ Registered 5 mobs + 3 NPC types");

        // Register structures
        ModStructures.registerStructures();
        LOGGER.info("  ✓ Registered 5 structures");

        // Register dimensions
        ModDimensions.registerDimensions();
        LOGGER.info("  ✓ Registered 1 dimensions");

        // Server lifecycle events
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            int questCount = QUEST_ENGINE.loadQuestsFromResources(server);
            int npcCount = NPC_MANAGER.loadNPCsFromResources(server);
            
            // VALIDATE AGAINST BUILD PLAN - SINGLE SOURCE OF TRUTH
            VALIDATOR.validate(
                questCount,
                npcCount,
                25,
                5,
                5,
                1
            );
            
            // FAIL LOUDLY if critical validation errors
            if (VALIDATOR.getValidationErrors() > 0) {
                LOGGER.error("╔════════════════════════════════════════════════════╗");
                LOGGER.error("║  !!! MOD VALIDATION FAILED !!!                     ║");
                LOGGER.error("║  Features exist in build plan but failed to load  ║");
                LOGGER.error("║  Check logs above for ORPHAN FEATURE errors       ║");
                LOGGER.error("╚════════════════════════════════════════════════════╝");
            }
        });
        
        // Save quest state on shutdown
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            QUEST_ENGINE.saveAllPlayerStates(server);
            LOGGER.info("Saved all player quest states");
        });

        LOGGER.info("Shattered Realms Revival initialized successfully!");
    }
}