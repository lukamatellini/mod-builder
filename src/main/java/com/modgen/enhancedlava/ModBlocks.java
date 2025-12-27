package com.modgen.enhancedlava;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // DEFERRED REGISTRATION: Fields initialized in registerBlocks()
    public static Block VOLCANIC_CORE;
    public static Block HARDENED_LAVA_BLOCK;
    public static Block LAVA_CRYSTAL_ORE;
    public static Block LAVA_BLOCK;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(EnhancedLava.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        EnhancedLava.LOGGER.info("Registering blocks for " + EnhancedLava.MOD_ID);
        VOLCANIC_CORE = registerBlock("volcanic_core", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(50f)
            .resistance(1200f)
            .requiresTool()
            .luminance(state -> 10)
            .sounds(BlockSoundGroup.METAL));
        HARDENED_LAVA_BLOCK = registerBlock("hardened_lava_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(60f)
            .resistance(200f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        LAVA_CRYSTAL_ORE = registerBlock("lava_crystal_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(10f)
            .resistance(15f)
            .requiresTool()
            .luminance(state -> 4)
            .sounds(BlockSoundGroup.STONE));
        LAVA_BLOCK = registerBlock("lava_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(100f)
            .resistance(100f)
            .requiresTool()
            .luminance(state -> 15)
            .sounds(BlockSoundGroup.GLASS));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOLCANIC_CORE != null) entries.add(VOLCANIC_CORE.asItem());
        if (HARDENED_LAVA_BLOCK != null) entries.add(HARDENED_LAVA_BLOCK.asItem());
        if (LAVA_CRYSTAL_ORE != null) entries.add(LAVA_CRYSTAL_ORE.asItem());
        if (LAVA_BLOCK != null) entries.add(LAVA_BLOCK.asItem());
    }
}