package com.modgen.swiftstridetrails;

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
    public static Item ENCHANTED_LEATHER;
    public static Item SWIFTSTRIDE_BOOTS;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SwiftstrideTrails.MOD_ID, name));
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
        SwiftstrideTrails.LOGGER.info("Registering items for " + SwiftstrideTrails.MOD_ID);
        ENCHANTED_LEATHER = registerItem("enchanted_leather", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().Settings().maxCount(1).maxDamage(200).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return ENCHANTED_LEATHER != null ? ENCHANTED_LEATHER : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ENCHANTED_LEATHER != null) entries.add(ENCHANTED_LEATHER);
        if (SWIFTSTRIDE_BOOTS != null) entries.add(SWIFTSTRIDE_BOOTS);
    }
}