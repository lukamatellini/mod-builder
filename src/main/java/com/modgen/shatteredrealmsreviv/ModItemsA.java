package com.modgen.shatteredrealmsreviv;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.util.Rarity;

import com.modgen.shatteredrealmsreviv.item.ShardbreakerSwordItem;
import com.modgen.shatteredrealmsreviv.item.CrystalStaffItem;
import com.modgen.shatteredrealmsreviv.item.SoulOrbItem;

/**
 * ModItemsA - Item registration chunk 1 of 2
 * Contains 15 items
 */
public class ModItemsA {
    // Item declarations
    public static Item VOID_HELMET;
    public static Item VOID_CHESTPLATE;
    public static Item VOID_LEGGINGS;
    public static Item VOID_BOOTS;
    public static Item SHARDBREAKER_SWORD;
    public static Item CRYSTAL_STAFF;
    public static Item ABYSSAL_PICKAXE;
    public static Item SOUL_ORB;
    public static Item VOID_SHARD;
    public static Item VOID_TEAR;
    public static Item GREATER_VOID_TEAR;
    public static Item SHARDBREAKER_CORE;
    public static Item LARGE_CRYSTAL;
    public static Item ABYSSAL_SHARD;
    public static Item HEART_OF_THE_VOID;

    public static void registerItems() {
        VOID_HELMET = ModItems.registerItem("void_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.RARE));
        VOID_CHESTPLATE = ModItems.registerItem("void_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(400).rarity(Rarity.RARE));
        VOID_LEGGINGS = ModItems.registerItem("void_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(350).rarity(Rarity.RARE));
        VOID_BOOTS = ModItems.registerItem("void_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.RARE));
        SHARDBREAKER_SWORD = ModItems.registerItem("shardbreaker_sword", ShardbreakerSwordItem::new, new Item.Settings().maxCount(1).maxDamage(800).rarity(Rarity.EPIC));
        CRYSTAL_STAFF = ModItems.registerItem("crystal_staff", CrystalStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
        ABYSSAL_PICKAXE = ModItems.registerItem("abyssal_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1200).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        SOUL_ORB = ModItems.registerItem("soul_orb", SoulOrbItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_SHARD = ModItems.registerItem("void_shard", Item::new, new Item.Settings().maxDamage(500));
        VOID_TEAR = ModItems.registerItem("void_tear", Item::new, new Item.Settings().maxDamage(500));
        GREATER_VOID_TEAR = ModItems.registerItem("greater_void_tear", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        SHARDBREAKER_CORE = ModItems.registerItem("shardbreaker_core", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        LARGE_CRYSTAL = ModItems.registerItem("large_crystal", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ABYSSAL_SHARD = ModItems.registerItem("abyssal_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        HEART_OF_THE_VOID = ModItems.registerItem("heart_of_the_void", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
    }
}