package com.modgen.romanempire;

import com.modgen.romanempire.engine.ModGenEngine;
import com.modgen.romanempire.engine.QuestEngine;
import com.modgen.romanempire.engine.NPCManager;
import com.modgen.romanempire.engine.StructureRegistry;
import com.modgen.romanempire.engine.BuildPlanValidator;
import com.modgen.romanempire.command.ModGenCommand;
import com.modgen.romanempire.network.ModNetworking;
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

public class RomanEmpire implements ModInitializer {
    public static final String MOD_ID = "romanempire";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier ITEM_GROUP_ID = Identifier.of(MOD_ID, "main");
    
    // Engine instances
    public static ModGenEngine ENGINE;
    public static QuestEngine QUEST_ENGINE;
    public static NPCManager NPC_MANAGER;
    public static BuildPlanValidator VALIDATOR;
    public static StructureRegistry STRUCTURE_REGISTRY;

    @Override
    public void onInitialize() {
        LOGGER.info("╔════════════════════════════════════════╗");
        LOGGER.info("║  Roman Empire                          ║");
        LOGGER.info("║  Loading... (Fabric 1.21.x)            ║");
        LOGGER.info("╚════════════════════════════════════════╝");
        
        // Initialize engine and validator
        ENGINE = new ModGenEngine();
        QUEST_ENGINE = new QuestEngine();
        NPC_MANAGER = new NPCManager();
        STRUCTURE_REGISTRY = new StructureRegistry();
        VALIDATOR = new BuildPlanValidator();
        
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
        LOGGER.info("  ✓ Registered 13 items");

        // Register entities (mobs + NPCs)
        ModEntities.registerEntities();
        LOGGER.info("  ✓ Registered 3 mobs + 0 NPC types");

        // Register structures
        ModStructures.registerStructures();
        LOGGER.info("  ✓ Registered 3 structures");


        // Server lifecycle events
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            // Load quest data from JSON
            int questCount = QUEST_ENGINE.loadQuestsFromResources(server);
            int npcCount = NPC_MANAGER.loadNPCsFromResources(server);
            
            // VALIDATE AGAINST BUILD PLAN - SINGLE SOURCE OF TRUTH
            VALIDATOR.validate(
                questCount,
                npcCount,
                13,
                3,
                3,
                0
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
        
        LOGGER.info("Roman Empire initialized successfully!");
    }
}