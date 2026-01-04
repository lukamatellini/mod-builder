package com.modgen.speedboots.client;

import com.modgen.speedboots.network.ModPackets;
import com.modgen.speedboots.client.screen.ProgressBarHud;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

import java.util.stream.Collectors;

/**
 * Client-side networking handlers
 * MUST be in src/client/java - contains net.minecraft.client imports
 */
@Environment(EnvType.CLIENT)
public class ModClientNetworking {

    
    public static void registerClientPackets() {

        // Handle progress bar updates
        ClientPlayNetworking.registerGlobalReceiver(ModPackets.ProgressBarUpdatePayload.ID, (payload, context) -> {
            context.client().execute(() -> {
                ProgressBarHud.addProgressBar(
                    payload.barId(),
                    payload.label(),
                    payload.progress(),
                    payload.color(),
                    payload.durationTicks()
                );
            });
        });
    }
    
    // === SEND METHODS (Client -> Server) ===

}