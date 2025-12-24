package com.modgen.fortuneblocks;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item LUCKY_BLOCK_ITEM;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(FortuneBlocks.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        FortuneBlocks.LOGGER.info("Registering items for " + FortuneBlocks.MOD_ID);
        LUCKY_BLOCK_ITEM = registerItem("lucky_block_item", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK_ITEM != null ? LUCKY_BLOCK_ITEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK_ITEM != null) entries.add(LUCKY_BLOCK_ITEM);
    }
}