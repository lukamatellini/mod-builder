package com.modgen.gemstoneodyssey;

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
import com.modgen.gemstoneodyssey.ModItems;
import com.modgen.gemstoneodyssey.ModBlocks;
import com.modgen.gemstoneodyssey.entity.ModEntities;
import com.modgen.gemstoneodyssey.ModStructures;
import com.modgen.gemstoneodyssey.ModNPCs;
import com.modgen.gemstoneodyssey.ModQuests;
import com.modgen.gemstoneodyssey.ModDimensions;

public class GemstoneOdyssey implements ModInitializer {
    public static final String MOD_ID = "gemstoneodyssey";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    // Creative tab - MINECRAFT 1.21.x: Use Identifier.of() instead of deprecated new Identifier()
    public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, 
        Identifier.of(MOD_ID, "main")
    );

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Gemstone Odyssey");
        
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
        
        LOGGER.info("Gemstone Odyssey initialized successfully!");
    }
}