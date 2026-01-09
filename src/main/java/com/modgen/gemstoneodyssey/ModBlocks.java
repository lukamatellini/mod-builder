package com.modgen.gemstoneodyssey;

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
    public static Block RUBY_ORE;
    public static Block SAPPHIRE_ORE;
    public static Block GLOWING_CRYSTAL;
    public static Block OBSIDIAN_BRICK;
    public static Block SHADOWSTONE;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(GemstoneOdyssey.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        GemstoneOdyssey.LOGGER.info("Registering blocks for " + GemstoneOdyssey.MOD_ID);
        RUBY_ORE = registerBlock("ruby_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(3f)
            .sounds(BlockSoundGroup.STONE));
        SAPPHIRE_ORE = registerBlock("sapphire_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(3f)
            .sounds(BlockSoundGroup.STONE));
        GLOWING_CRYSTAL = registerBlock("glowing_crystal", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(1f)
            .resistance(1f)
            .sounds(BlockSoundGroup.STONE));
        OBSIDIAN_BRICK = registerBlock("obsidian_brick", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(50f)
            .resistance(1200f)
            .sounds(BlockSoundGroup.STONE));
        SHADOWSTONE = registerBlock("shadowstone", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(2f)
            .resistance(6f)
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static Item getFirstBlockItem() {
        return RUBY_ORE.asItem();
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RUBY_ORE != null) entries.add(RUBY_ORE.asItem());
        if (SAPPHIRE_ORE != null) entries.add(SAPPHIRE_ORE.asItem());
        if (GLOWING_CRYSTAL != null) entries.add(GLOWING_CRYSTAL.asItem());
        if (OBSIDIAN_BRICK != null) entries.add(OBSIDIAN_BRICK.asItem());
        if (SHADOWSTONE != null) entries.add(SHADOWSTONE.asItem());
    }
}