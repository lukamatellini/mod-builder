package com.modgen.swiftstriders;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item VELOCITY_BOOTS;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SwiftStriders.MOD_ID, name));
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
        SwiftStriders.LOGGER.info("Registering items for " + SwiftStriders.MOD_ID);
        VELOCITY_BOOTS = registerItem("velocity_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return VELOCITY_BOOTS != null ? VELOCITY_BOOTS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VELOCITY_BOOTS != null) entries.add(VELOCITY_BOOTS);
    }
}