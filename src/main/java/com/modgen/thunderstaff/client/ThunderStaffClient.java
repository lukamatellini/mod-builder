package com.modgen.thunderstaff.client;

import com.modgen.thunderstaff.ThunderStaff;
import com.modgen.thunderstaff.network.ModNetworking;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ThunderStaffClient implements ClientModInitializer {
    
    @Override
    public void onInitializeClient() {
        ThunderStaff.LOGGER.info("Initializing Thunder Staff client...");
        
        // Register client-side networking
        ModNetworking.registerClientPackets();
        
        ThunderStaff.LOGGER.info("Thunder Staff client initialized");
    }
}