package com.modgen.epicadventure;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.util.Rarity;

import com.modgen.epicadventure.item.PurificationStaffItem;

/**
 * ModItemsA - Item registration chunk 1 of 2
 * Contains 15 items
 */
public class ModItemsA {
    // Item declarations
    public static Item VOID_SILK;
    public static Item WRAITH_ESSENCE;
    public static Item CRYSTAL_SHARD;
    public static Item ABYSSAL_SCALE;
    public static Item CORRUPTED_HEART;
    public static Item ABYSSAL_COMPASS;
    public static Item VOID_BLADE;
    public static Item CRYSTAL_PICKAXE;
    public static Item WRAITH_CLOAK;
    public static Item VOID_KINGS_CROWN;
    public static Item PURIFICATION_STAFF;
    public static Item POTION_OF_VOID_SIGHT;
    public static Item VOID_CATALYST;
    public static Item CRYSTAL_HELMET;
    public static Item CRYSTAL_CHESTPLATE;

    public static void registerItems() {
        VOID_SILK = ModItems.registerItem("void_silk", Item::new, new Item.Settings().maxDamage(500));
        WRAITH_ESSENCE = ModItems.registerItem("wraith_essence", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        CRYSTAL_SHARD = ModItems.registerItem("crystal_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ABYSSAL_SCALE = ModItems.registerItem("abyssal_scale", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        CORRUPTED_HEART = ModItems.registerItem("corrupted_heart", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        ABYSSAL_COMPASS = ModItems.registerItem("abyssal_compass", Item::new, new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.EPIC));
        VOID_BLADE = ModItems.registerItem("void_blade", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(700).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 11, -2.4f)));
        CRYSTAL_PICKAXE = ModItems.registerItem("crystal_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 4, -2.8f)));
        WRAITH_CLOAK = ModItems.registerItem("wraith_cloak", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.EPIC));
        VOID_KINGS_CROWN = ModItems.registerItem("void_kings_crown", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(1200).rarity(Rarity.EPIC));
        PURIFICATION_STAFF = ModItems.registerItem("purification_staff", PurificationStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
        POTION_OF_VOID_SIGHT = ModItems.registerItem("potion_of_void_sight", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_CATALYST = ModItems.registerItem("void_catalyst", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        CRYSTAL_HELMET = ModItems.registerItem("crystal_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(800).rarity(Rarity.EPIC));
        CRYSTAL_CHESTPLATE = ModItems.registerItem("crystal_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(1100).rarity(Rarity.EPIC));
    }
}