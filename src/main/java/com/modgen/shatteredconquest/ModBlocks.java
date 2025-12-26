package com.modgen.shatteredconquest;

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
    public static Block VOID_ORE;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(ShatteredConquest.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        ShatteredConquest.LOGGER.info("Registering blocks for " + ShatteredConquest.MOD_ID);
        VOID_STONE = registerBlock("void_stone", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(5f)
            .resistance(10f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        VOID_ORE = registerBlock("void_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(7f)
            .resistance(12f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_STONE != null) entries.add(VOID_STONE.asItem());
        if (VOID_ORE != null) entries.add(VOID_ORE.asItem());
    }
}