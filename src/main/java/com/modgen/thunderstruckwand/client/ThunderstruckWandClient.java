package com.modgen.thunderstruckwand.client;

import com.modgen.thunderstruckwand.ThunderstruckWand;
import com.modgen.thunderstruckwand.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ThunderstruckWandClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        ThunderstruckWand.LOGGER.info("Initializing Thunderstruck Wand client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        ThunderstruckWand.LOGGER.info("Thunderstruck Wand client initialized");
    }
}