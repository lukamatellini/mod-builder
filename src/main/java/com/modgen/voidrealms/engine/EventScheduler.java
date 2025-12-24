package com.modgen.voidrealms.engine;

import com.modgen.voidrealms.VoidRealms;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

/**
 * Event Scheduler - Manages timed events, world events, and scheduled tasks
 * Tick-based system for maximum control over timing
 */
public class EventScheduler {
    private static final Logger LOGGER = LoggerFactory.getLogger("voidrealms/scheduler");
    
    // Event definitions loaded at startup
    private final Map<String, EventDefinition> eventDefinitions = new ConcurrentHashMap<>();
    
    // Active scheduled tasks
    private final Map<String, ScheduledTask> scheduledTasks = new ConcurrentHashMap<>();
    
    // Active world events
    private final Map<String, ActiveWorldEvent> activeEvents = new ConcurrentHashMap<>();
    
    // Server tick counter
    private long currentTick = 0;
    
    public EventScheduler() {
        registerEventDefinitions();
    }
    
    private void registerEventDefinitions() {
        eventDefinitions.put("void_invasion", new EventDefinition(
            "void_invasion",
            "Void Invasion",
            "wave",
            6000,
            6000
        ));
        eventDefinitions.put("crystal_night", new EventDefinition(
            "crystal_night",
            "Crystal Night",
            "survival",
            6000,
            6000
        ));
        LOGGER.info("Registered {} event definitions", eventDefinitions.size());
    }
    
    public void registerTickListener() {
        ServerTickEvents.END_SERVER_TICK.register(this::onServerTick);
        LOGGER.info("Event scheduler tick listener registered");
    }
    
    private void onServerTick(MinecraftServer server) {
        currentTick++;
        
        // Process scheduled tasks
        List<String> completedTasks = new ArrayList<>();
        for (var entry : scheduledTasks.entrySet()) {
            ScheduledTask task = entry.getValue();
            if (currentTick >= task.executeAtTick) {
                try {
                    task.action.accept(server);
                    if (task.repeating) {
                        task.executeAtTick = currentTick + task.intervalTicks;
                    } else {
                        completedTasks.add(entry.getKey());
                    }
                } catch (Exception e) {
                    LOGGER.error("Error executing scheduled task {}: {}", entry.getKey(), e.getMessage());
                    completedTasks.add(entry.getKey());
                }
            }
        }
        completedTasks.forEach(scheduledTasks::remove);
        
        // Process active world events
        List<String> endedEvents = new ArrayList<>();
        for (var entry : activeEvents.entrySet()) {
            ActiveWorldEvent event = entry.getValue();
            if (currentTick >= event.endTick) {
                endEvent(server, entry.getKey());
                endedEvents.add(entry.getKey());
            } else {
                tickEvent(server, event);
            }
        }
        endedEvents.forEach(activeEvents::remove);
        
        // Check for automatic event triggers
        for (var def : eventDefinitions.values()) {
            if (def.type.equals("periodic") && currentTick % def.intervalTicks == 0) {
                startEvent(server, def.id);
            }
        }
    }
    
    /**
     * Schedule a one-time task to execute after a delay
     */
    public void scheduleTask(String taskId, int delayTicks, Consumer<MinecraftServer> action) {
        scheduledTasks.put(taskId, new ScheduledTask(
            currentTick + delayTicks,
            delayTicks,
            false,
            action
        ));
        LOGGER.info("Scheduled one-time task: {} (in {} ticks)", taskId, delayTicks);
    }
    
    /**
     * Schedule a repeating task
     */
    public void scheduleRepeatingTask(String taskId, int intervalTicks, Consumer<MinecraftServer> action) {
        scheduledTasks.put(taskId, new ScheduledTask(
            currentTick + intervalTicks,
            intervalTicks,
            true,
            action
        ));
        LOGGER.info("Scheduled repeating task: {} (every {} ticks)", taskId, intervalTicks);
    }
    
    /**
     * Cancel a scheduled task
     */
    public void cancelTask(String taskId) {
        if (scheduledTasks.remove(taskId) != null) {
            LOGGER.info("Cancelled scheduled task: {}", taskId);
        }
    }
    
    /**
     * Start a world event by ID
     */
    public boolean startEvent(MinecraftServer server, String eventId) {
        EventDefinition def = eventDefinitions.get(eventId);
        if (def == null) {
            LOGGER.warn("Unknown event ID: {}", eventId);
            return false;
        }
        
        if (activeEvents.containsKey(eventId)) {
            LOGGER.info("Event {} already active", eventId);
            return false;
        }
        
        ActiveWorldEvent event = new ActiveWorldEvent(def, currentTick + def.durationTicks);
        activeEvents.put(eventId, event);
        
        // Announce event start
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.sendMessage(Text.literal("§6✦ Event Started: §e" + def.name + " §6✦"), false);
            player.getWorld().playSound(null, player.getBlockPos(),
                SoundEvents.ENTITY_ENDER_DRAGON_GROWL, SoundCategory.MASTER, 0.5f, 1.0f);
        }
        
        LOGGER.info("Started world event: {} (duration: {} ticks)", eventId, def.durationTicks);
        return true;
    }
    
    /**
     * End a world event
     */
    public void endEvent(MinecraftServer server, String eventId) {
        ActiveWorldEvent event = activeEvents.get(eventId);
        if (event == null) return;
        
        // Announce event end
        for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
            player.sendMessage(Text.literal("§7✦ Event Ended: §f" + event.definition.name + " §7✦"), false);
        }
        
        LOGGER.info("Ended world event: {}", eventId);
    }
    
    private void tickEvent(MinecraftServer server, ActiveWorldEvent event) {
        // Apply event effects based on type
        switch (event.definition.type) {
            case "blood_moon":
                // Increased mob spawns, hostile mobs stronger
                for (ServerWorld world : server.getWorlds()) {
                    if (world.isNight() && world.random.nextInt(100) < 10) {
                        // Could spawn additional hostile mobs here
                    }
                }
                break;
            case "blessing":
                // Give players buff effects
                if (currentTick % 200 == 0) { // Every 10 seconds
                    for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 220, 0));
                    }
                }
                break;
            case "storm":
                // Weather + occasional lightning
                for (ServerWorld world : server.getWorlds()) {
                    if (!world.isRaining()) {
                        world.setWeather(0, 1200, true, true);
                    }
                }
                break;
            case "invasion":
                // Spawn event-specific mobs
                if (currentTick % 100 == 0) {
                    for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                        player.sendMessage(Text.literal("§c§oThe invasion intensifies..."), true);
                    }
                }
                break;
        }
    }
    
    public boolean isEventActive(String eventId) {
        return activeEvents.containsKey(eventId);
    }
    
    public Collection<String> getActiveEventIds() {
        return new HashSet<>(activeEvents.keySet());
    }
    
    public int getEventTimeRemaining(String eventId) {
        ActiveWorldEvent event = activeEvents.get(eventId);
        if (event == null) return 0;
        return (int) Math.max(0, event.endTick - currentTick);
    }
    
    public long getCurrentTick() {
        return currentTick;
    }
    
    // Data classes
    public static class EventDefinition {
        public final String id;
        public final String name;
        public final String type;
        public final int intervalTicks;
        public final int durationTicks;
        
        public EventDefinition(String id, String name, String type, int intervalTicks, int durationTicks) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.intervalTicks = intervalTicks;
            this.durationTicks = durationTicks;
        }
    }
    
    private static class ScheduledTask {
        long executeAtTick;
        final int intervalTicks;
        final boolean repeating;
        final Consumer<MinecraftServer> action;
        
        ScheduledTask(long executeAtTick, int intervalTicks, boolean repeating, Consumer<MinecraftServer> action) {
            this.executeAtTick = executeAtTick;
            this.intervalTicks = intervalTicks;
            this.repeating = repeating;
            this.action = action;
        }
    }
    
    private static class ActiveWorldEvent {
        final EventDefinition definition;
        final long endTick;
        
        ActiveWorldEvent(EventDefinition definition, long endTick) {
            this.definition = definition;
            this.endTick = endTick;
        }
    }
}