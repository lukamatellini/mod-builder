package com.modgen.swiftstrideboots;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item SWIFTSTEP_BOOTS = registerItem("swiftstep_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(200).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SwiftstrideBoots.MOD_ID, name), item);
    }

    public static void registerItems() {
        SwiftstrideBoots.LOGGER.info("Registering items for " + SwiftstrideBoots.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return SWIFTSTEP_BOOTS;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(SWIFTSTEP_BOOTS);
    }
}