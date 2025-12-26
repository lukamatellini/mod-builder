package com.modgen.abyssawakensisanepic;

import com.modgen.abyssawakensisanepic.engine.ModGenEngine;
import com.modgen.abyssawakensisanepic.engine.BuildPlanValidator;
import com.modgen.abyssawakensisanepic.command.ModGenCommand;
import com.modgen.abyssawakensisanepic.engine.QuestEngine;
import com.modgen.abyssawakensisanepic.engine.NPCManager;
import com.modgen.abyssawakensisanepic.engine.StructureRegistry;
import com.modgen.abyssawakensisanepic.engine.TradingSystem;
import com.modgen.abyssawakensisanepic.engine.ReputationSystem;
import com.modgen.abyssawakensisanepic.network.ModNetworking;
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

public class AbyssAwakensIsAnEpicAdventure implements ModInitializer {
    public static final String MOD_ID = "abyssawakensisanepic";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier ITEM_GROUP_ID = Identifier.of(MOD_ID, "main");
    
    // Engine instances - ONLY fields for enabled systems
    public static ModGenEngine ENGINE;
    public static BuildPlanValidator VALIDATOR;
    public static QuestEngine QUEST_ENGINE;
    public static NPCManager NPC_MANAGER;
    public static StructureRegistry STRUCTURE_REGISTRY;
    public static TradingSystem TRADING_SYSTEM;
    public static ReputationSystem REPUTATION_SYSTEM;

    @Override
    public void onInitialize() {
        LOGGER.info("╔════════════════════════════════════════╗");
        LOGGER.info("║  Abyss Awakens is an epic adventure    ║");
        LOGGER.info("║  Loading... (Fabric 1.21.x)            ║");
        LOGGER.info("╚════════════════════════════════════════╝");
        
        // Initialize engine and validator - ONLY enabled systems
        ENGINE = new ModGenEngine();
        VALIDATOR = new BuildPlanValidator();
        QUEST_ENGINE = new QuestEngine();
        NPC_MANAGER = new NPCManager();
        STRUCTURE_REGISTRY = new StructureRegistry();
        TRADING_SYSTEM = new TradingSystem();
        REPUTATION_SYSTEM = new ReputationSystem();
        
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
        LOGGER.info("  ✓ Registered 7 mobs + 4 NPC types");

        // Register structures
        ModStructures.registerStructures();
        LOGGER.info("  ✓ Registered 7 structures");

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
                13,
                7,
                7,
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

        LOGGER.info("Abyss Awakens is an epic adventure initialized successfully!");
    }
}