package com.modgen.stormcaster.client;

import com.modgen.stormcaster.StormCaster;
import com.modgen.stormcaster.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class StormCasterClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        StormCaster.LOGGER.info("Initializing Storm Caster client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        StormCaster.LOGGER.info("Storm Caster client initialized");
    }
}