package com.modgen.shatteredrealmsreviv;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;


/**
 * ModItemsB - Item registration chunk 2 of 2
 * Contains 10 items
 */
public class ModItemsB {
    // Item declarations
    public static Item GEM_OF_THE_EMPRESS;
    public static Item RAW_CRYSTAL;
    public static Item SHADOW_DUST;
    public static Item ETHEREAL_THREAD;
    public static Item VOID_INGOT;
    public static Item CHARGED_CRYSTAL;
    public static Item WARP_PEDESTAL;
    public static Item VOID_ORE;
    public static Item VOID_STONE;
    public static Item CRYSTAL_ORE;

    public static void registerItems() {
        GEM_OF_THE_EMPRESS = ModItems.registerItem("gem_of_the_empress", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        RAW_CRYSTAL = ModItems.registerItem("raw_crystal", Item::new, new Item.Settings().maxDamage(500));
        SHADOW_DUST = ModItems.registerItem("shadow_dust", Item::new, new Item.Settings().maxDamage(500));
        ETHEREAL_THREAD = ModItems.registerItem("ethereal_thread", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_INGOT = ModItems.registerItem("void_ingot", Item::new, new Item.Settings().maxDamage(500));
        CHARGED_CRYSTAL = ModItems.registerItem("charged_crystal", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        WARP_PEDESTAL = ModItems.registerItem("warp_pedestal", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_ORE = ModItems.registerItem("void_ore", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_STONE = ModItems.registerItem("void_stone", Item::new, new Item.Settings().maxDamage(500));
        CRYSTAL_ORE = ModItems.registerItem("crystal_ore", Item::new, new Item.Settings().maxDamage(500));
    }
}