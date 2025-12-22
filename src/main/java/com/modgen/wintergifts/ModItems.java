package com.modgen.wintergifts;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    public static final Item CHRISTMAS_PRESENT_ITEM = registerItem("christmas_present_item", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(WinterGifts.MOD_ID, name), item);
    }

    public static void registerItems() {
        WinterGifts.LOGGER.info("Registering items for " + WinterGifts.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return CHRISTMAS_PRESENT_ITEM;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(CHRISTMAS_PRESENT_ITEM);
    }
}