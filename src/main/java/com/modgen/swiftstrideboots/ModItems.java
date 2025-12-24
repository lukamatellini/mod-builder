package com.modgen.swiftstrideboots;

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
    public static Item SWIFTSTRIDE_BOOTS;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(SwiftstrideBoots.MOD_ID, name);
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
        SwiftstrideBoots.LOGGER.info("Registering items for " + SwiftstrideBoots.MOD_ID);
        SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(400).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return SWIFTSTRIDE_BOOTS != null ? SWIFTSTRIDE_BOOTS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SWIFTSTRIDE_BOOTS != null) entries.add(SWIFTSTRIDE_BOOTS);
    }
}