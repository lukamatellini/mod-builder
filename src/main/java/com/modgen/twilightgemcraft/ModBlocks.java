package com.modgen.twilightgemcraft;

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
    public static Block AETHERIUM_ORE;
    public static Block AETHERIUM_BLOCK;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(TwilightGemcraft.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        TwilightGemcraft.LOGGER.info("Registering blocks for " + TwilightGemcraft.MOD_ID);
        AETHERIUM_ORE = registerBlock("aetherium_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(3f)
            .sounds(BlockSoundGroup.STONE));
        AETHERIUM_BLOCK = registerBlock("aetherium_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(6f)
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static Item getFirstBlockItem() {
        return AETHERIUM_ORE.asItem();
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (AETHERIUM_ORE != null) entries.add(AETHERIUM_ORE.asItem());
        if (AETHERIUM_BLOCK != null) entries.add(AETHERIUM_BLOCK.asItem());
    }
}