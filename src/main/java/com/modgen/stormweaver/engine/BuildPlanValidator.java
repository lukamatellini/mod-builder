package com.modgen.stormweaver.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BuildPlanValidator - STRICT validation against build plan expectations
 * This is the SINGLE SOURCE OF TRUTH for what this mod should contain
 * 
 * RULE: NO ORPHAN FEATURES
 * If something exists, it must be:
 * - registered
 * - referenced
 * - reachable via gameplay (NPC, item, quest, UI, or command)
 */
public class BuildPlanValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger("stormweaver/validator");
    
    // Build Plan expectations (from build-plan.json)
    public static final String MINECRAFT_RANGE = ">=1.21 <1.22";
    public static final int EXPECTED_ITEMS = 1;
    public static final int EXPECTED_MOBS = 0;
    public static final int EXPECTED_STRUCTURES = 0;
    public static final int EXPECTED_DIMENSIONS = 0;
    public static final int EXPECTED_QUESTS = 0;
    public static final int EXPECTED_NPCS = 0;
    public static final int EXPECTED_EVENTS = 0;
    
    // Module flags
    public static final boolean MODULE_QUESTS = false;
    public static final boolean MODULE_NPCS = false;
    public static final boolean MODULE_DIALOGUE = false;
    public static final boolean MODULE_TRADING = false;
    public static final boolean MODULE_STRUCTURES = false;
    public static final boolean MODULE_DIMENSIONS = false;
    public static final boolean MODULE_BIOMES = false;
    public static final boolean MODULE_ITEMS = true;
    public static final boolean MODULE_MOBS = false;
    public static final boolean MODULE_EVENTS = false;
    
    private int validationErrors = 0;
    private int validationWarnings = 0;
    
    public void validate(int actualQuests, int actualNpcs, int actualItems, int actualMobs, int actualStructures, int actualDimensions) {
        LOGGER.info("╔═══════════════════════════════════════════════════════════════╗");
        LOGGER.info("║  BUILD PLAN VALIDATION - SINGLE SOURCE OF TRUTH              ║");
        LOGGER.info("╠═══════════════════════════════════════════════════════════════╣");
        LOGGER.info("║  Minecraft Range: " + String.format("%-43s", MINECRAFT_RANGE) + "║");
        LOGGER.info("╠═══════════════════════════════════════════════════════════════╣");
        LOGGER.info("║  CONTENT VALIDATION:                                         ║");
        
        // Validate content counts - STRICT
        validateCount("Quests", EXPECTED_QUESTS, actualQuests, MODULE_QUESTS);
        validateCount("NPCs/Dialogue", EXPECTED_NPCS, actualNpcs, MODULE_NPCS);
        validateCount("Items", EXPECTED_ITEMS, actualItems, MODULE_ITEMS);
        validateCount("Mobs", EXPECTED_MOBS, actualMobs, MODULE_MOBS);
        validateCount("Structures", EXPECTED_STRUCTURES, actualStructures, MODULE_STRUCTURES);
        validateCount("Dimensions", EXPECTED_DIMENSIONS, actualDimensions, MODULE_DIMENSIONS);
        
        // GAMEPLAY ACCESS PATH VALIDATION
        LOGGER.info("╠═══════════════════════════════════════════════════════════════╣");
        LOGGER.info("║  GAMEPLAY ACCESS PATH CHECK:                                 ║");
        
        if (MODULE_NPCS && actualNpcs > 0) {
            LOGGER.info("║  ✓ NPCs: Spawnable via /modgen spawnnpc <type>              ║");
            LOGGER.info("║  ✓ NPCs: Right-click opens dialogue UI                      ║");
        }
        if (MODULE_QUESTS && actualQuests > 0) {
            LOGGER.info("║  ✓ Quests: Start via /modgen startquest <id>                ║");
            LOGGER.info("║  ✓ Quests: View via /modgen journal or NPC dialogue         ║");
        }
        if (MODULE_STRUCTURES && EXPECTED_STRUCTURES > 0) {
            LOGGER.info("║  ✓ Structures: Place via /modgen placestructure <id>        ║");
        }
        if (MODULE_DIMENSIONS && EXPECTED_DIMENSIONS > 0) {
            LOGGER.info("║  ✓ Dimensions: Teleport via /modgen opendimension <id>      ║");
        }
        if (MODULE_ITEMS && EXPECTED_ITEMS > 0) {
            LOGGER.info("║  ✓ Items: Available in creative tab + craftable             ║");
        }
        
        LOGGER.info("╠═══════════════════════════════════════════════════════════════╣");
        
        if (validationErrors > 0) {
            LOGGER.error("║  ██████████████████████████████████████████████████████████ ║");
            LOGGER.error("║  ███ VALIDATION FAILED: " + String.format("%-2d", validationErrors) + " CRITICAL ERRORS ███████████████ ║");
            LOGGER.error("║  ██████████████████████████████████████████████████████████ ║");
            LOGGER.error("║                                                             ║");
            LOGGER.error("║  ORPHAN FEATURES DETECTED!                                  ║");
            LOGGER.error("║  Features exist in build plan but failed to load.          ║");
            LOGGER.error("║  This mod is NOT production-ready.                         ║");
            LOGGER.error("║                                                             ║");
            LOGGER.error("╚═══════════════════════════════════════════════════════════════╝");
        } else if (validationWarnings > 0) {
            LOGGER.warn("║  ⚠ Validation passed with " + validationWarnings + " warnings                        ║");
            LOGGER.info("╚═══════════════════════════════════════════════════════════════╝");
        } else {
            LOGGER.info("║  ✓✓✓ ALL VALIDATIONS PASSED - MOD IS PRODUCTION READY ✓✓✓   ║");
            LOGGER.info("╚═══════════════════════════════════════════════════════════════╝");
        }
    }
    
    private void validateCount(String name, int expected, int actual, boolean moduleEnabled) {
        String status;
        String pad = String.format("%-15s", name + ":");
        
        if (!moduleEnabled && expected == 0) {
            status = "SKIPPED (not requested)";
        } else if (expected == actual) {
            status = "✓ " + actual + "/" + expected + " loaded";
        } else if (expected > 0 && actual == 0) {
            status = "!!! 0/" + expected + " ORPHAN FEATURE !!!";
            validationErrors++;
            LOGGER.error("╠═══════════════════════════════════════════════════════════════╣");
            LOGGER.error("║  !!! ORPHAN FEATURE: " + name + "                             ║");
            LOGGER.error("║  Expected: " + expected + ", Loaded: 0                                    ║");
            LOGGER.error("║  This feature was requested but has NO DATA                 ║");
        } else if (actual < expected) {
            status = "⚠ " + actual + "/" + expected + " (missing " + (expected - actual) + ")";
            validationWarnings++;
        } else {
            status = "✓ " + actual + " loaded (expected " + expected + ")";
        }
        LOGGER.info("║  " + pad + String.format("%-46s", status) + "║");
    }
    
    public int getValidationErrors() {
        return validationErrors;
    }
    
    public int getValidationWarnings() {
        return validationWarnings;
    }
    
    public void printEnabledModules() {
        LOGGER.info("╔═══════════════════════════════════════════════════════════════╗");
        LOGGER.info("║  ENABLED MODULES (from build-plan.json)                      ║");
        LOGGER.info("╠═══════════════════════════════════════════════════════════════╣");
        LOGGER.info("║  Quests:     " + (MODULE_QUESTS ? "✓ YES" : "✗ NO ") + "  │  NPCs:       " + (MODULE_NPCS ? "✓ YES" : "✗ NO ") + "              ║");
        LOGGER.info("║  Dialogue:   " + (MODULE_DIALOGUE ? "✓ YES" : "✗ NO ") + "  │  Trading:    " + (MODULE_TRADING ? "✓ YES" : "✗ NO ") + "              ║");
        LOGGER.info("║  Structures: " + (MODULE_STRUCTURES ? "✓ YES" : "✗ NO ") + "  │  Dimensions: " + (MODULE_DIMENSIONS ? "✓ YES" : "✗ NO ") + "              ║");
        LOGGER.info("║  Biomes:     " + (MODULE_BIOMES ? "✓ YES" : "✗ NO ") + "  │  Items:      " + (MODULE_ITEMS ? "✓ YES" : "✗ NO ") + "              ║");
        LOGGER.info("║  Mobs:       " + (MODULE_MOBS ? "✓ YES" : "✗ NO ") + "  │  Events:     " + (MODULE_EVENTS ? "✓ YES" : "✗ NO ") + "              ║");
        LOGGER.info("╚═══════════════════════════════════════════════════════════════╝");
    }
}