package com.modgen.epicadventure;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.util.Rarity;

import com.modgen.epicadventure.item.AbyssalVoidPortalIgniterItem;

/**
 * ModItemsB - Item registration chunk 2 of 2
 * Contains 3 items
 */
public class ModItemsB {
    // Item declarations
    public static Item CRYSTAL_LEGGINGS;
    public static Item CRYSTAL_BOOTS;
    public static Item ABYSSAL_VOID_PORTAL_IGNITER;

    public static void registerItems() {
        CRYSTAL_LEGGINGS = ModItems.registerItem("crystal_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC));
        CRYSTAL_BOOTS = ModItems.registerItem("crystal_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(700).rarity(Rarity.EPIC));
        ABYSSAL_VOID_PORTAL_IGNITER = ModItems.registerItem("abyssal_void_portal_igniter", AbyssalVoidPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
}