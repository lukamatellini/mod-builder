package com.modgen.slipperypeel.client;

import com.modgen.slipperypeel.SlipperyPeel;
import com.modgen.slipperypeel.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SlipperyPeelClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        SlipperyPeel.LOGGER.info("Initializing Slippery Peel client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        SlipperyPeel.LOGGER.info("Slippery Peel client initialized");
    }
}