package com.modgen.stormcaller.client;

import com.modgen.stormcaller.StormCaller;
import com.modgen.stormcaller.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class StormCallerClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        StormCaller.LOGGER.info("Initializing Storm Caller client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        StormCaller.LOGGER.info("Storm Caller client initialized");
    }
}