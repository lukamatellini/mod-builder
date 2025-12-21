package com.modgen.voidconquest.engine;

import com.modgen.voidconquest.VoidConquest;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * World Event Manager - Handles large-scale world events
 * Coordinates with EventScheduler for timing, manages event state
 */
public class WorldEventManager {
    private static final Logger LOGGER = LoggerFactory.getLogger("voidconquest/world-events");
    
    // Active event modifiers
    private double mobSpawnMultiplier = 1.0;
    private double lootMultiplier = 1.0;
    private double xpMultiplier = 1.0;
    private boolean bloodMoonActive = false;
    private boolean blessingActive = false;
    
    public void setMobSpawnMultiplier(double multiplier) {
        this.mobSpawnMultiplier = multiplier;
        LOGGER.info("Mob spawn multiplier set to: {}", multiplier);
    }
    
    public void setLootMultiplier(double multiplier) {
        this.lootMultiplier = multiplier;
        LOGGER.info("Loot multiplier set to: {}", multiplier);
    }
    
    public void setXpMultiplier(double multiplier) {
        this.xpMultiplier = multiplier;
        LOGGER.info("XP multiplier set to: {}", multiplier);
    }
    
    public double getMobSpawnMultiplier() { return mobSpawnMultiplier; }
    public double getLootMultiplier() { return lootMultiplier; }
    public double getXpMultiplier() { return xpMultiplier; }
    
    public void activateBloodMoon(MinecraftServer server) {
        bloodMoonActive = true;
        mobSpawnMultiplier = 2.0;
        
        for (ServerWorld world : server.getWorlds()) {
            // Set to night
            world.setTimeOfDay(13000);
        }
        
        broadcastMessage(server, "§4§l☠ The Blood Moon rises... ☠");
        LOGGER.info("Blood Moon activated");
    }
    
    public void deactivateBloodMoon(MinecraftServer server) {
        bloodMoonActive = false;
        mobSpawnMultiplier = 1.0;
        broadcastMessage(server, "§7The Blood Moon fades...");
        LOGGER.info("Blood Moon deactivated");
    }
    
    public void activateBlessing(MinecraftServer server) {
        blessingActive = true;
        xpMultiplier = 2.0;
        lootMultiplier = 1.5;
        broadcastMessage(server, "§e§l✦ A divine blessing washes over the land! ✦");
        LOGGER.info("Blessing activated");
    }
    
    public void deactivateBlessing(MinecraftServer server) {
        blessingActive = false;
        xpMultiplier = 1.0;
        lootMultiplier = 1.0;
        broadcastMessage(server, "§7The blessing fades...");
        LOGGER.info("Blessing deactivated");
    }
    
    public boolean isBloodMoonActive() { return bloodMoonActive; }
    public boolean isBlessingActive() { return blessingActive; }
    
    /**
     * Spawn event-specific mobs around players
     */
    public void spawnEventMobs(MinecraftServer server, String mobType, int count) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            ServerWorld world = player.getServerWorld();
            
            for (int i = 0; i < count; i++) {
                double angle = world.random.nextDouble() * Math.PI * 2;
                double distance = 10 + world.random.nextDouble() * 20;
                int x = (int) (player.getX() + Math.cos(angle) * distance);
                int z = (int) (player.getZ() + Math.sin(angle) * distance);
                int y = world.getTopY(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, x, z);
                
                BlockPos spawnPos = new BlockPos(x, y, z);
                // Spawn logic would go here based on mobType
            }
        }
    }
    
    /**
     * Broadcast a message to all players
     */
    public void broadcastMessage(MinecraftServer server, String message) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.sendMessage(Text.literal(message), false);
        }
    }
    
    /**
     * Broadcast an action bar message
     */
    public void broadcastActionBar(MinecraftServer server, String message) {
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.sendMessage(Text.literal(message), true);
        }
    }
    
    /**
     * Get active event status for display
     */
    public List<String> getActiveEventStatus() {
        List<String> status = new ArrayList<>();
        if (bloodMoonActive) status.add("Blood Moon");
        if (blessingActive) status.add("Divine Blessing");
        if (mobSpawnMultiplier != 1.0) status.add("Mob x" + mobSpawnMultiplier);
        if (lootMultiplier != 1.0) status.add("Loot x" + lootMultiplier);
        if (xpMultiplier != 1.0) status.add("XP x" + xpMultiplier);
        return status;
    }
}