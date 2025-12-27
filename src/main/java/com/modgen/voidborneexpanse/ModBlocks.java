package com.modgen.voidborneexpanse;

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
    public static Block VOIDSTONE;
    public static Block ETHEREAL_CRYSTAL_ORE;
    public static Block GRAVITY_ANCHOR_BLOCK;
    public static Block WEIGHTLESS_GRASS_BLOCK;
    public static Block VOID_SHROOM;
    public static Block ETHEREAL_WOOD_LOG;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(VoidborneExpanse.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        VoidborneExpanse.LOGGER.info("Registering blocks for " + VoidborneExpanse.MOD_ID);
        VOIDSTONE = registerBlock("voidstone", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(6f)
            .requiresTool()
            .luminance(state -> 3)
            .sounds(BlockSoundGroup.STONE));
        ETHEREAL_CRYSTAL_ORE = registerBlock("ethereal_crystal_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(10f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        GRAVITY_ANCHOR_BLOCK = registerBlock("gravity_anchor_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(4f)
            .resistance(8f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL));
        WEIGHTLESS_GRASS_BLOCK = registerBlock("weightless_grass_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(0.5f)
            .resistance(0.5f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        VOID_SHROOM = registerBlock("void_shroom", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(6f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        ETHEREAL_WOOD_LOG = registerBlock("ethereal_wood_log", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(2f)
            .resistance(2f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOIDSTONE != null) entries.add(VOIDSTONE.asItem());
        if (ETHEREAL_CRYSTAL_ORE != null) entries.add(ETHEREAL_CRYSTAL_ORE.asItem());
        if (GRAVITY_ANCHOR_BLOCK != null) entries.add(GRAVITY_ANCHOR_BLOCK.asItem());
        if (WEIGHTLESS_GRASS_BLOCK != null) entries.add(WEIGHTLESS_GRASS_BLOCK.asItem());
        if (VOID_SHROOM != null) entries.add(VOID_SHROOM.asItem());
        if (ETHEREAL_WOOD_LOG != null) entries.add(ETHEREAL_WOOD_LOG.asItem());
    }
}