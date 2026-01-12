package com.modgen.cheesycraft;

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
    public static Block AGED_CHEESE_BLOCK;
    public static Block CHEESE_ORE;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(Cheesycraft.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        Cheesycraft.LOGGER.info("Registering blocks for " + Cheesycraft.MOD_ID);
        CHEESE_BLOCK = registerBlock("cheese_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(1.5f)
            .resistance(1.5f)
            .sounds(BlockSoundGroup.STONE));
        AGED_CHEESE_BLOCK = registerBlock("aged_cheese_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(2f)
            .resistance(2f)
            .sounds(BlockSoundGroup.STONE));
        CHEESE_ORE = registerBlock("cheese_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(3f)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static Item getFirstBlockItem() {
        return CHEESE_BLOCK.asItem();
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_BLOCK != null) entries.add(CHEESE_BLOCK.asItem());
        if (AGED_CHEESE_BLOCK != null) entries.add(AGED_CHEESE_BLOCK.asItem());
        if (CHEESE_ORE != null) entries.add(CHEESE_ORE.asItem());
    }
}