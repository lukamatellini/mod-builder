package com.modgen.luckyblocks;


import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
    public static Item RANDOM_SELECTION_FROM_LOOT_TABLE;
    public static Item VOID_ESSENCE;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyBlocks.MOD_ID, name);
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
        LuckyBlocks.LOGGER.info("Registering items for " + LuckyBlocks.MOD_ID);
        RANDOM_SELECTION_FROM_LOOT_TABLE = registerItem("random_selection_from_loot_table", Item::new, new Item.Settings().rarity(Rarity.RARE));
        VOID_ESSENCE = registerItem("void_essence", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return RANDOM_SELECTION_FROM_LOOT_TABLE != null ? RANDOM_SELECTION_FROM_LOOT_TABLE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RANDOM_SELECTION_FROM_LOOT_TABLE != null) entries.add(RANDOM_SELECTION_FROM_LOOT_TABLE);
        if (VOID_ESSENCE != null) entries.add(VOID_ESSENCE);
    }
}