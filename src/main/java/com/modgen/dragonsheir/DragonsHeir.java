package com.modgen.dragonsheir;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.modgen.dragonsheir.ModItems;
import com.modgen.dragonsheir.ModBlocks;
import com.modgen.dragonsheir.entity.ModEntities;
import com.modgen.dragonsheir.ModStructures;
import com.modgen.dragonsheir.ModNPCs;
import com.modgen.dragonsheir.ModQuests;
import com.modgen.dragonsheir.ModDimensions;

public class DragonsHeir implements ModInitializer {
    public static final String MOD_ID = "dragonsheir";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Creative tab - MINECRAFT 1.21.x: Use Identifier.of() instead of deprecated new Identifier()
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, 
        Identifier.of(MOD_ID, "main")
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Dragons Heir");
        
        // Register items
        ModItems.registerItems();
        // Register blocks
        ModBlocks.registerBlocks();
        // Register entities
        ModEntities.registerEntities();
        // Register structures
        ModStructures.registerStructures();
        // Register NPCs
        ModNPCs.registerNPCs();
        // Register quests
        ModQuests.registerQuests();
        // Register dimensions
        ModDimensions.registerDimensions();
        
        // Register creative tab
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, 
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.getFirstItem()))
                .displayName(Text.translatable("itemGroup." + MOD_ID + ".main"))
                .entries((context, entries) -> {
                    ModItems.addToCreativeTab(entries);
                    ModBlocks.addToCreativeTab(entries);
                })
                .build()
        );
        
        LOGGER.info("Dragons Heir initialized successfully!");
    }
}