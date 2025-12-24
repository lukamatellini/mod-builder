package com.modgen.shatteredascent;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.util.Rarity;

import com.modgen.shatteredascent.item.ShardbreakerSwordItem;
import com.modgen.shatteredascent.item.CrystalStaffItem;
import com.modgen.shatteredascent.item.SoulOrbItem;

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
    public static Item VOID_INGOT;
    public static Item CRYSTAL_SHARD;
    public static Item ABYSSAL_ALLOY;
    public static Item VOID_STICK;
    public static Item SHATTERED_SOUL;
    public static Item ELDER_SHARD;
    public static Item VOID_PLANKS;

    public static void registerItems() {
        VOID_HELMET = ModItems.registerItem("void_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(600).rarity(Rarity.EPIC));
        VOID_CHESTPLATE = ModItems.registerItem("void_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(800).rarity(Rarity.EPIC));
        VOID_LEGGINGS = ModItems.registerItem("void_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(700).rarity(Rarity.EPIC));
        VOID_BOOTS = ModItems.registerItem("void_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.EPIC));
        SHARDBREAKER_SWORD = ModItems.registerItem("shardbreaker_sword", ShardbreakerSwordItem::new, new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.EPIC));
        CRYSTAL_STAFF = ModItems.registerItem("crystal_staff", CrystalStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
        ABYSSAL_PICKAXE = ModItems.registerItem("abyssal_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1200).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        SOUL_ORB = ModItems.registerItem("soul_orb", SoulOrbItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_INGOT = ModItems.registerItem("void_ingot", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        CRYSTAL_SHARD = ModItems.registerItem("crystal_shard", Item::new, new Item.Settings().maxDamage(500));
        ABYSSAL_ALLOY = ModItems.registerItem("abyssal_alloy", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_STICK = ModItems.registerItem("void_stick", Item::new, new Item.Settings().maxDamage(500));
        SHATTERED_SOUL = ModItems.registerItem("shattered_soul", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ELDER_SHARD = ModItems.registerItem("elder_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        VOID_PLANKS = ModItems.registerItem("void_planks", Item::new, new Item.Settings().maxDamage(500));
    }
}