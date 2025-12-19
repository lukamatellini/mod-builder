package com.modgen.thunderstrikewand.client;

import com.modgen.thunderstrikewand.ThunderstrikeWand;
import com.modgen.thunderstrikewand.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ThunderstrikeWandClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        ThunderstrikeWand.LOGGER.info("Initializing Thunderstrike Wand client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        ThunderstrikeWand.LOGGER.info("Thunderstrike Wand client initialized");
    }
}