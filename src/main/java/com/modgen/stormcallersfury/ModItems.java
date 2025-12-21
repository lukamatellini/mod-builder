package com.modgen.stormcallersfury;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.stormcallersfury.item.StormCallerWandItem;

public class ModItems {
    public static final Item STORM_CALLER_WAND = registerItem("storm_caller_wand", new StormCallerWandItem(new Item.Settings().maxCount(1).maxDamage(250).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StormcallersFury.MOD_ID, name), item);
    }

    public static void registerItems() {
        StormcallersFury.LOGGER.info("Registering items for " + StormcallersFury.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return STORM_CALLER_WAND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(STORM_CALLER_WAND);
    }
}