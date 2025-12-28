package com.modgen.swiftfootboots;


import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ArmorItem;
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
    public static Item SWIFTFOOT_BOOTS;
    public static Item SWIFT_INGOT;
    public static Item SWIFT_GEM;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(SwiftfootBoots.MOD_ID, name);
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
        SwiftfootBoots.LOGGER.info("Registering items for " + SwiftfootBoots.MOD_ID);
        SWIFTFOOT_BOOTS = registerItem("swiftfoot_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(396).rarity(Rarity.RARE));
        SWIFT_INGOT = registerItem("swift_ingot", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        SWIFT_GEM = registerItem("swift_gem", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return SWIFTFOOT_BOOTS != null ? SWIFTFOOT_BOOTS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SWIFTFOOT_BOOTS != null) entries.add(SWIFTFOOT_BOOTS);
        if (SWIFT_INGOT != null) entries.add(SWIFT_INGOT);
        if (SWIFT_GEM != null) entries.add(SWIFT_GEM);
    }
}