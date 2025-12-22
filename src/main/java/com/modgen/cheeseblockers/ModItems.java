package com.modgen.cheeseblockers;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Declare without initialization to avoid
    // NullPointerException during static init (Item id not set)
    public static Item CHEESE_SLICE;
    public static Item SALT;
    public static Item BLOCK_OF_CHEESE;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(CheeseBlockers.MOD_ID, name), item);
    }

    public static void registerItems() {
        CheeseBlockers.LOGGER.info("Registering items for " + CheeseBlockers.MOD_ID);
        // Initialize items HERE after registry is ready
        CHEESE_SLICE = registerItem("cheese_slice", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build())));
        SALT = registerItem("salt", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
        BLOCK_OF_CHEESE = registerItem("block_of_cheese", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    }
    
    public static Item getFirstItem() {
        // Safe: only called after registerItems()
        return CHEESE_SLICE != null ? CHEESE_SLICE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        // Null-check each item in case registration order varies
        if (CHEESE_SLICE != null) entries.add(CHEESE_SLICE);
        if (SALT != null) entries.add(SALT);
        if (BLOCK_OF_CHEESE != null) entries.add(BLOCK_OF_CHEESE);
    }
}