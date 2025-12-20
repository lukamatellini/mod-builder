package com.modgen.festivechests;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item CHRISTMAS_PRESENT_BLOCK = registerItem("christmas_present_block", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(FestiveChests.MOD_ID, name), item);
    }

    public static void registerItems() {
        FestiveChests.LOGGER.info("Registering items for " + FestiveChests.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return CHRISTMAS_PRESENT_BLOCK;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(CHRISTMAS_PRESENT_BLOCK);
    }
}