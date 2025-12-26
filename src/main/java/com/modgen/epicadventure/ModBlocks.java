package com.modgen.epicadventure;

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
    public static Block VOID_STONE;
    public static Block CORRUPTED_GRASS;
    public static Block CRYSTAL_ORE;
    public static Block ABYSSAL_WATER;
    public static Block VOID_PORTAL_FRAME;
    public static Block CRYSTAL_FORGE_BLOCK;
    public static Block LORE_TABLET;
    public static Block BOSS_ALTAR;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(EpicAdventure.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        EpicAdventure.LOGGER.info("Registering blocks for " + EpicAdventure.MOD_ID);
        VOID_STONE = registerBlock("void_stone", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(6f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        CORRUPTED_GRASS = registerBlock("corrupted_grass", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(0.6f)
            .resistance(0.6f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        CRYSTAL_ORE = registerBlock("crystal_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(3f)
            .requiresTool()
            .luminance(state -> 7)
            .sounds(BlockSoundGroup.STONE));
        ABYSSAL_WATER = registerBlock("abyssal_water", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(100f)
            .resistance(100f)
            .requiresTool()
            .sounds(BlockSoundGroup.GLASS));
        VOID_PORTAL_FRAME = registerBlock("void_portal_frame", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(1200f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL));
        CRYSTAL_FORGE_BLOCK = registerBlock("crystal_forge_block", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(6f)
            .requiresTool()
            .luminance(state -> 10)
            .sounds(BlockSoundGroup.METAL));
        LORE_TABLET = registerBlock("lore_tablet", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(1.5f)
            .resistance(3f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        BOSS_ALTAR = registerBlock("boss_altar", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(1200f)
            .requiresTool()
            .luminance(state -> 5)
            .sounds(BlockSoundGroup.METAL));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_STONE != null) entries.add(VOID_STONE.asItem());
        if (CORRUPTED_GRASS != null) entries.add(CORRUPTED_GRASS.asItem());
        if (CRYSTAL_ORE != null) entries.add(CRYSTAL_ORE.asItem());
        if (ABYSSAL_WATER != null) entries.add(ABYSSAL_WATER.asItem());
        if (VOID_PORTAL_FRAME != null) entries.add(VOID_PORTAL_FRAME.asItem());
        if (CRYSTAL_FORGE_BLOCK != null) entries.add(CRYSTAL_FORGE_BLOCK.asItem());
        if (LORE_TABLET != null) entries.add(LORE_TABLET.asItem());
        if (BOSS_ALTAR != null) entries.add(BOSS_ALTAR.asItem());
    }
}