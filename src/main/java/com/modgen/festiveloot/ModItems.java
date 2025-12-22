package com.modgen.festiveloot;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Declare without initialization to avoid
    // NullPointerException during static init (Item id not set)
    public static Item CANDY_CANE;

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FestiveLoot.MOD_ID, name), item);
    }

    public static void registerItems() {
        FestiveLoot.LOGGER.info("Registering items for " + FestiveLoot.MOD_ID);
        // Initialize items HERE after registry is ready
        CANDY_CANE = registerItem("candy_cane", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build())));
    }
    
    public static Item getFirstItem() {
        // Safe: only called after registerItems()
        return CANDY_CANE != null ? CANDY_CANE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        // Null-check each item in case registration order varies
        if (CANDY_CANE != null) entries.add(CANDY_CANE);
    }
}