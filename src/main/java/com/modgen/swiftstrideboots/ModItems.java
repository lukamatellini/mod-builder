package com.modgen.swiftstrideboots;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.EPIC)));
    public static final Item ENCHANTED_LEATHER = registerItem("enchanted_leather", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    public static final Item SWIFT_GEM = registerItem("swift_gem", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SwiftstrideBoots.MOD_ID, name), item);
    }

    public static void registerItems() {
        SwiftstrideBoots.LOGGER.info("Registering items for " + SwiftstrideBoots.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return SWIFTSTRIDE_BOOTS;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(SWIFTSTRIDE_BOOTS);
        entries.add(ENCHANTED_LEATHER);
        entries.add(SWIFT_GEM);
    }
}