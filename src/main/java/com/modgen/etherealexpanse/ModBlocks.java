package com.modgen.etherealexpanse;

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
    public static Block GRAVITY_ANCHOR;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(EtherealExpanse.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        EtherealExpanse.LOGGER.info("Registering blocks for " + EtherealExpanse.MOD_ID);
        VOIDSTONE = registerBlock("voidstone", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(4f)
            .resistance(8f)
            .requiresTool()
            .luminance(state -> 3)
            .sounds(BlockSoundGroup.STONE));
        ETHEREAL_CRYSTAL_ORE = registerBlock("ethereal_crystal_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(7f)
            .resistance(10f)
            .requiresTool()
            .sounds(BlockSoundGroup.STONE));
        GRAVITY_ANCHOR = registerBlock("gravity_anchor", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(3f)
            .resistance(6f)
            .requiresTool()
            .sounds(BlockSoundGroup.METAL));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOIDSTONE != null) entries.add(VOIDSTONE.asItem());
        if (ETHEREAL_CRYSTAL_ORE != null) entries.add(ETHEREAL_CRYSTAL_ORE.asItem());
        if (GRAVITY_ANCHOR != null) entries.add(GRAVITY_ANCHOR.asItem());
    }
}