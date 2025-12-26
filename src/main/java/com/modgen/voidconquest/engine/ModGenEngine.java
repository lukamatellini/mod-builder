package com.modgen.voidconquest.engine;

import com.modgen.voidconquest.VoidConquest;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ModGen Engine - Core runtime system for the mod
 * Handles cross-system coordination and state management
 */
public class ModGenEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger("voidconquest/engine");
    
    private boolean initialized = false;
    
    public ModGenEngine() {
        LOGGER.info("ModGen Engine initializing...");
    }
    
    public void onServerStart(MinecraftServer server) {
        initialized = true;
        LOGGER.info("ModGen Engine ready");
    }
    
    public boolean isInitialized() {
        return initialized;
    }
    
    public void debug() {
        LOGGER.info("=== ModGen Engine Debug ===");
        LOGGER.info("Initialized: " + initialized);
        LOGGER.info("Quest Engine: " + (VoidConquest.QUEST_ENGINE != null ? "OK" : "NULL"));
        LOGGER.info("NPC Manager: " + (VoidConquest.NPC_MANAGER != null ? "OK" : "NULL"));
    }
}