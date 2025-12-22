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
    public static Item SWIFTSTRIDE_BOOTS;
    public static Item SWIFTSTONE_INGOT;
    public static Item RAW_SWIFTSTONE;
    public static Item SWIFTSTONE_BLOCK;

    /**
     * Minecraft 1.21.x Item Registration Pattern
     * CRITICAL: Item.Settings.registryKey() MUST be called BEFORE Item construction
     * This factory pattern ensures the registry key is set on settings before the item is created
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SwiftstrideTrails.MOD_ID, name));
        Item item = factory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        SwiftstrideTrails.LOGGER.info("Registering items for " + SwiftstrideTrails.MOD_ID);
        SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().Settings().maxCount(1).maxDamage(350).rarity(Rarity.RARE));
        SWIFTSTONE_INGOT = registerItem("swiftstone_ingot", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        RAW_SWIFTSTONE = registerItem("raw_swiftstone", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        SWIFTSTONE_BLOCK = registerItem("swiftstone_block", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return SWIFTSTRIDE_BOOTS != null ? SWIFTSTRIDE_BOOTS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SWIFTSTRIDE_BOOTS != null) entries.add(SWIFTSTRIDE_BOOTS);
        if (SWIFTSTONE_INGOT != null) entries.add(SWIFTSTONE_INGOT);
        if (RAW_SWIFTSTONE != null) entries.add(RAW_SWIFTSTONE);
        if (SWIFTSTONE_BLOCK != null) entries.add(SWIFTSTONE_BLOCK);
    }
}