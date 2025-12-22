package com.modgen.presentplunder;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.presentplunder.item.ChristmasPresentItem;

public class ModItems {
    // DEFERRED REGISTRATION: Declare without initialization to avoid
    // NullPointerException during static init (Item id not set)
    public static Item GOLDEN_CANDY_CANE;
    public static Item CHRISTMAS_PRESENT;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PresentPlunder.MOD_ID, name), item);
    }

    public static void registerItems() {
        PresentPlunder.LOGGER.info("Registering items for " + PresentPlunder.MOD_ID);
        // Initialize items HERE after registry is ready
        GOLDEN_CANDY_CANE = registerItem("golden_candy_cane", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build())));
        CHRISTMAS_PRESENT = registerItem("christmas_present", new ChristmasPresentItem(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    }
    
    public static Item getFirstItem() {
        // Safe: only called after registerItems()
        return GOLDEN_CANDY_CANE != null ? GOLDEN_CANDY_CANE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        // Null-check each item in case registration order varies
        if (GOLDEN_CANDY_CANE != null) entries.add(GOLDEN_CANDY_CANE);
        if (CHRISTMAS_PRESENT != null) entries.add(CHRISTMAS_PRESENT);
    }
}