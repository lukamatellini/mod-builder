package com.modgen.shatteredrealms.engine;

import com.modgen.shatteredrealms.ShatteredRealms;
import net.minecraft.server.MinecraftServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ModGen Engine - Core runtime system for the mod
 * Handles cross-system coordination and state management
 */
public class ModGenEngine {
    private static final Logger LOGGER = LoggerFactory.getLogger("shatteredrealms/engine");
    
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
        LOGGER.info("Quest Engine: " + (ShatteredRealms.QUEST_ENGINE != null ? "OK" : "NULL"));
        LOGGER.info("NPC Manager: " + (ShatteredRealms.NPC_MANAGER != null ? "OK" : "NULL"));
        LOGGER.info("Trading System: " + (ShatteredRealms.TRADING_SYSTEM != null ? "OK" : "NULL"));
    }
}