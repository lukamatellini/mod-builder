package com.modgen.agedwedge;

import com.modgen.agedwedge.engine.ModGenEngine;
import com.modgen.agedwedge.engine.BuildPlanValidator;
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

public class AgedWedge implements ModInitializer {
    public static final String MOD_ID = "agedwedge";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    public static final Identifier ITEM_GROUP_ID = Identifier.of(MOD_ID, "main");
    
    // Engine instances - ONLY fields for enabled systems
    public static ModGenEngine ENGINE;
    public static BuildPlanValidator VALIDATOR;

    @Override
    public void onInitialize() {
        LOGGER.info("╔════════════════════════════════════════╗");
        LOGGER.info("║  Aged Wedge                            ║");
        LOGGER.info("║  Loading... (Fabric 1.21.x)            ║");
        LOGGER.info("╚════════════════════════════════════════╝");
        
        // Initialize engine and validator - ONLY enabled systems
        ENGINE = new ModGenEngine();
        VALIDATOR = new BuildPlanValidator();
        
        // Print enabled modules from build plan
        VALIDATOR.printEnabledModules();
        
        // Register sounds
        ModSounds.registerSounds();
        

        // No commands needed - minimal item-only mod

        




        // Server lifecycle events
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            int questCount = 0;
            int npcCount = 0;
            
            // VALIDATE AGAINST BUILD PLAN - SINGLE SOURCE OF TRUTH
            VALIDATOR.validate(
                questCount,
                npcCount,
                0,
                0,
                0,
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
        

        LOGGER.info("Aged Wedge initialized successfully!");
    }
}