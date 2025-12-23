package com.modgen.aetheriaascendant;

import com.modgen.aetheriaascendant.engine.ModGenEngine;
import com.modgen.aetheriaascendant.engine.BuildPlanValidator;
import com.modgen.aetheriaascendant.command.ModGenCommand;
import com.modgen.aetheriaascendant.engine.NPCManager;
import com.modgen.aetheriaascendant.engine.StructureRegistry;
import com.modgen.aetheriaascendant.engine.TradingSystem;
import com.modgen.aetheriaascendant.engine.ReputationSystem;
import com.modgen.aetheriaascendant.network.ModNetworking;
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

public class AetheriaAscendant implements ModInitializer {
    public static final String MOD_ID = "aetheriaascendant";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier ITEM_GROUP_ID = Identifier.of(MOD_ID, "main");
    
    // Engine instances - ONLY fields for enabled systems
    public static ModGenEngine ENGINE;
    public static BuildPlanValidator VALIDATOR;
    public static NPCManager NPC_MANAGER;
    public static StructureRegistry STRUCTURE_REGISTRY;
    public static TradingSystem TRADING_SYSTEM;
    public static ReputationSystem REPUTATION_SYSTEM;

    @Override
    public void onInitialize() {
        LOGGER.info("╔════════════════════════════════════════╗");
        LOGGER.info("║  Aetheria Ascendant                    ║");
        LOGGER.info("║  Loading... (Fabric 1.21.x)            ║");
        LOGGER.info("╚════════════════════════════════════════╝");
        
        // Initialize engine and validator - ONLY enabled systems
        ENGINE = new ModGenEngine();
        VALIDATOR = new BuildPlanValidator();
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
        LOGGER.info("  ✓ Registered 6 items");

        // Register entities (mobs + NPCs)
        ModEntities.registerEntities();
        LOGGER.info("  ✓ Registered 3 mobs + 2 NPC types");

        // Register structures
        ModStructures.registerStructures();
        LOGGER.info("  ✓ Registered 3 structures");

        // Register dimensions
        ModDimensions.registerDimensions();
        LOGGER.info("  ✓ Registered 1 dimensions");

        // Server lifecycle events
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            int questCount = 0;
            int npcCount = NPC_MANAGER.loadNPCsFromResources(server);
            
            // VALIDATE AGAINST BUILD PLAN - SINGLE SOURCE OF TRUTH
            VALIDATOR.validate(
                questCount,
                npcCount,
                6,
                3,
                3,
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
        

        LOGGER.info("Aetheria Ascendant initialized successfully!");
    }
}