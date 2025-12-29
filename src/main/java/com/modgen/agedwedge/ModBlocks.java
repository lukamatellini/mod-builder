package com.modgen.agedwedge;

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
    public static Block CHEESE_BLOCK;
    public static Block MODCHEESE_BLOCK;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(AgedWedge.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        AgedWedge.LOGGER.info("Registering blocks for " + AgedWedge.MOD_ID);
        CHEESE_BLOCK = registerBlock("cheese_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(0.5f)
            .resistance(0.5f)
            .sounds(BlockSoundGroup.STONE));
        MODCHEESE_BLOCK = registerBlock("modcheese_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(1.5f)
            .resistance(6f)
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_BLOCK != null) entries.add(CHEESE_BLOCK.asItem());
        if (MODCHEESE_BLOCK != null) entries.add(MODCHEESE_BLOCK.asItem());
    }
}