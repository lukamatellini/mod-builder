package com.modgen.swiftstridetrails;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(250).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SwiftstrideTrails.MOD_ID, name), item);
    }

    public static void registerItems() {
        SwiftstrideTrails.LOGGER.info("Registering items for " + SwiftstrideTrails.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return SWIFTSTRIDE_BOOTS;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(SWIFTSTRIDE_BOOTS);
    }
}