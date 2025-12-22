package com.modgen.solidcheese;

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
    public static Item CHEESE_BLOCK;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SolidCheese.MOD_ID, name));
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        SolidCheese.LOGGER.info("Registering items for " + SolidCheese.MOD_ID);
        CHEESE_BLOCK = registerItem("cheese_block", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return CHEESE_BLOCK != null ? CHEESE_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_BLOCK != null) entries.add(CHEESE_BLOCK);
    }
}