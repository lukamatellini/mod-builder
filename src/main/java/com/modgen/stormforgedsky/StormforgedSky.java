package com.modgen.stormforgedsky;

import com.modgen.stormforgedsky.engine.ModGenEngine;
import com.modgen.stormforgedsky.engine.BuildPlanValidator;
import com.modgen.stormforgedsky.command.ModGenCommand;
import com.modgen.stormforgedsky.engine.QuestEngine;
import com.modgen.stormforgedsky.engine.StructureRegistry;
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

public class StormforgedSky implements ModInitializer {
    public static final String MOD_ID = "stormforgedsky";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier ITEM_GROUP_ID = Identifier.of(MOD_ID, "main");
    
    // Engine instances - ONLY fields for enabled systems
    public static ModGenEngine ENGINE;
    public static BuildPlanValidator VALIDATOR;
    public static QuestEngine QUEST_ENGINE;
    public static StructureRegistry STRUCTURE_REGISTRY;

    @Override
    public void onInitialize() {
        LOGGER.info("╔════════════════════════════════════════╗");
        LOGGER.info("║  Stormforged Sky                       ║");
        LOGGER.info("║  Loading... (Fabric 1.21.x)            ║");
        LOGGER.info("╚════════════════════════════════════════╝");
        
        // Initialize engine and validator - ONLY enabled systems
        ENGINE = new ModGenEngine();
        VALIDATOR = new BuildPlanValidator();
        QUEST_ENGINE = new QuestEngine();
        STRUCTURE_REGISTRY = new StructureRegistry();
        
        // Print enabled modules from build plan
        VALIDATOR.printEnabledModules();
        
        // Register sounds
        ModSounds.registerSounds();
        

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
        LOGGER.info("  ✓ Registered 3 items");

        // Register entities (mobs + NPCs)
        ModEntities.registerEntities();
        LOGGER.info("  ✓ Registered 1 mobs + 0 NPC types");

        // Register structures
        ModStructures.registerStructures();
        LOGGER.info("  ✓ Registered 1 structures");


        // Server lifecycle events
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            int questCount = QUEST_ENGINE.loadQuestsFromResources(server);
            int npcCount = 0;
            
            // VALIDATE AGAINST BUILD PLAN - SINGLE SOURCE OF TRUTH
            VALIDATOR.validate(
                questCount,
                npcCount,
                3,
                1,
                1,
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

        LOGGER.info("Stormforged Sky initialized successfully!");
    }
}