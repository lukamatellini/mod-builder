package com.modgen.thunderclaprod.network;

import com.modgen.thunderclaprod.ThunderclapRod;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Server-side networking - NO CLIENT IMPORTS
 * All client handling is in src/client/java
 */
public class ModNetworking {
    
    // === SERVER-SIDE REGISTRATION ===
    public static void registerServerPackets() {
        // Register S2C packet types (server sends to client)
        PayloadTypeRegistry.playS2C().register(ModPackets.ProgressBarUpdatePayload.ID, ModPackets.ProgressBarUpdatePayload.CODEC);
        
        // Register C2S packet types (client sends to server)


        
        ThunderclapRod.LOGGER.info("Registered server networking");
    }
    
    // === SEND METHODS (Server -> Client) ===

    /**
     * Send progress bar update
     */
    public static void sendProgressBarUpdate(ServerPlayerEntity player, String barId, String label, 
                                             float progress, int color, int durationTicks) {
        ServerPlayNetworking.send(player, new ModPackets.ProgressBarUpdatePayload(barId, label, progress, color, durationTicks));
    }
}