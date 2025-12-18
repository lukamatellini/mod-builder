package com.modgen.bananablaster.client;

import com.modgen.bananablaster.BananaBlaster;
import com.modgen.bananablaster.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BananaBlasterClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        BananaBlaster.LOGGER.info("Initializing Banana Blaster client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        BananaBlaster.LOGGER.info("Banana Blaster client initialized");
    }
}