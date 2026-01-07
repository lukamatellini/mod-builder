package com.modgen.aetherfellarmory;

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

// Custom block class imports
import com.modgen.aetherfellarmory.block.LuckyBlockBlock;

public class ModBlocks {
    // DEFERRED REGISTRATION: Fields initialized in registerBlocks()
    public static Block RUBY_ORE;
    public static Block RUBY_BLOCK;
    public static Block SAPPHIRE_ORE;
    public static Block MAGIC_CRYSTAL_BLOCK;
    public static Block LUCKY_BLOCK;
    public static Block ANCIENT_RUNE_BLOCK;
    public static Block DRAGON_NEST_BLOCK;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(AetherfellArmory.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        AetherfellArmory.LOGGER.info("Registering blocks for " + AetherfellArmory.MOD_ID);
        RUBY_ORE = registerBlock("ruby_ore", 
            Block::new, 
            AbstractBlock.Settings.create()
            .hardness(8f)
            .resistance(45f)
            .sounds(BlockSoundGroup.STONE));
        RUBY_BLOCK = registerBlock("ruby_block", 
            Block::new, 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(30f)
            .sounds(BlockSoundGroup.STONE));
        SAPPHIRE_ORE = registerBlock("sapphire_ore", 
            Block::new, 
            AbstractBlock.Settings.create()
            .hardness(7f)
            .resistance(40f)
            .sounds(BlockSoundGroup.STONE));
        MAGIC_CRYSTAL_BLOCK = registerBlock("magic_crystal_block", 
            Block::new, 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(15f)
            .luminance(state -> 12)
            .sounds(BlockSoundGroup.STONE));
        LUCKY_BLOCK = registerBlock("lucky_block", 
            LuckyBlockBlock::new, 
            AbstractBlock.Settings.create()
            .hardness(1f)
            .resistance(1f)
            .sounds(BlockSoundGroup.STONE));
        ANCIENT_RUNE_BLOCK = registerBlock("ancient_rune_block", 
            Block::new, 
            AbstractBlock.Settings.create()
            .hardness(10f)
            .resistance(1200f)
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.STONE));
        DRAGON_NEST_BLOCK = registerBlock("dragon_nest_block", 
            Block::new, 
            AbstractBlock.Settings.create()
            .hardness(50f)
            .resistance(1200f)
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static Item getFirstBlockItem() {
        return RUBY_ORE.asItem();
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RUBY_ORE != null) entries.add(RUBY_ORE.asItem());
        if (RUBY_BLOCK != null) entries.add(RUBY_BLOCK.asItem());
        if (SAPPHIRE_ORE != null) entries.add(SAPPHIRE_ORE.asItem());
        if (MAGIC_CRYSTAL_BLOCK != null) entries.add(MAGIC_CRYSTAL_BLOCK.asItem());
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK.asItem());
        if (ANCIENT_RUNE_BLOCK != null) entries.add(ANCIENT_RUNE_BLOCK.asItem());
        if (DRAGON_NEST_BLOCK != null) entries.add(DRAGON_NEST_BLOCK.asItem());
    }
}