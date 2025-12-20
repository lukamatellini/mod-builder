package com.modgen.thunderstaff;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item LIGHTNING_WAND = registerItem("lightning_wand", new Item(new Item.Settings().maxCount(1).maxDamage(100).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ThunderStaff.MOD_ID, name), item);
    }

    public static void registerItems() {
        ThunderStaff.LOGGER.info("Registering items for " + ThunderStaff.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return LIGHTNING_WAND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(LIGHTNING_WAND);
    }
}