package com.modgen.swiftstridesteps;

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

import com.modgen.swiftstridesteps.item.SwiftstrideBootsItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item SWIFTSTRIDE_BOOTS;
    public static Item SWIFTSTRIDE_FEATHER;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SwiftstrideSteps.MOD_ID, name));
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
        SwiftstrideSteps.LOGGER.info("Registering items for " + SwiftstrideSteps.MOD_ID);
        SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", SwiftstrideBootsItem::new, new Item.Settings().maxCount(1).maxDamage(250).rarity(Rarity.RARE));
        SWIFTSTRIDE_FEATHER = registerItem("swiftstride_feather", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return SWIFTSTRIDE_BOOTS != null ? SWIFTSTRIDE_BOOTS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SWIFTSTRIDE_BOOTS != null) entries.add(SWIFTSTRIDE_BOOTS);
        if (SWIFTSTRIDE_FEATHER != null) entries.add(SWIFTSTRIDE_FEATHER);
    }
}