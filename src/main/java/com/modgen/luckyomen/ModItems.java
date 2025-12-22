package com.modgen.luckyomen;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.luckyomen.item.CloverItem;

public class ModItems {
    public static final Item CLOVER = registerItem("clover", new CloverItem(new Item.Settings().maxDamage(500)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LuckyOmen.MOD_ID, name), item);
    }

    public static void registerItems() {
        LuckyOmen.LOGGER.info("Registering items for " + LuckyOmen.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return CLOVER;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(CLOVER);
    }
}