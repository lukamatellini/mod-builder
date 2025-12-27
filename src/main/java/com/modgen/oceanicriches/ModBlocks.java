package com.modgen.oceanicriches;

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
    public static Block AQUAMARINE_ORE;

    /**
     * Minecraft 1.21.0-1.21.1 Block Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of(OceanicRiches.MOD_ID, name);
        Block block = factory.apply(settings);
        Registry.register(Registries.BLOCK, id, block);
        
        // Register BlockItem for inventory
        BlockItem blockItem = new BlockItem(block, new Item.Settings());
        Registry.register(Registries.ITEM, id, blockItem);
        
        return block;
    }

    public static void registerBlocks() {
        OceanicRiches.LOGGER.info("Registering blocks for " + OceanicRiches.MOD_ID);
        AQUAMARINE_ORE = registerBlock("aquamarine_ore", 
            settings -> new Block(settings), 
            AbstractBlock.Settings.create()
            .hardness(7f)
            .resistance(6f)
            .requiresTool()
            .luminance(state -> 7)
            .sounds(BlockSoundGroup.STONE));
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (AQUAMARINE_ORE != null) entries.add(AQUAMARINE_ORE.asItem());
    }
}