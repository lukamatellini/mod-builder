package com.modgen.luckyblocks;


import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ArmorItem;
import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item LUCKY_DUST;
    public static Item LUCKY_PICKAXE;
    public static Item LUCKY_SWORD;
    public static Item LUCKY_HELMET;
    public static Item LUCKY_CHESTPLATE;
    public static Item LUCKY_LEGGINGS;
    public static Item LUCKY_BOOTS;
    public static Item RANDOMLY_DROPS_ITEMS;
    public static Item SPAWNS_MOBS;
    public static Item OR_TRIGGERS_EVENTS;
    public static Item REFINED_INGOT;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyBlocks.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyBlocks.LOGGER.info("Registering items for " + LuckyBlocks.MOD_ID);
        LUCKY_DUST = registerItem("lucky_dust", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        LUCKY_PICKAXE = registerItem("lucky_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(1500).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        LUCKY_SWORD = registerItem("lucky_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(1800).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        LUCKY_HELMET = registerItem("lucky_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(300).rarity(Rarity.RARE));
        LUCKY_CHESTPLATE = registerItem("lucky_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(450).rarity(Rarity.RARE));
        LUCKY_LEGGINGS = registerItem("lucky_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(400).rarity(Rarity.RARE));
        LUCKY_BOOTS = registerItem("lucky_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(350).rarity(Rarity.RARE));
        RANDOMLY_DROPS_ITEMS = registerItem("randomly_drops_items", Item::new, new Item.Settings().rarity(Rarity.EPIC));
        SPAWNS_MOBS = registerItem("spawns_mobs", Item::new, new Item.Settings().rarity(Rarity.EPIC));
        OR_TRIGGERS_EVENTS = registerItem("or_triggers_events", Item::new, new Item.Settings().rarity(Rarity.EPIC));
        REFINED_INGOT = registerItem("refined_ingot", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_DUST != null ? LUCKY_DUST : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_DUST != null) entries.add(LUCKY_DUST);
        if (LUCKY_PICKAXE != null) entries.add(LUCKY_PICKAXE);
        if (LUCKY_SWORD != null) entries.add(LUCKY_SWORD);
        if (LUCKY_HELMET != null) entries.add(LUCKY_HELMET);
        if (LUCKY_CHESTPLATE != null) entries.add(LUCKY_CHESTPLATE);
        if (LUCKY_LEGGINGS != null) entries.add(LUCKY_LEGGINGS);
        if (LUCKY_BOOTS != null) entries.add(LUCKY_BOOTS);
        if (RANDOMLY_DROPS_ITEMS != null) entries.add(RANDOMLY_DROPS_ITEMS);
        if (SPAWNS_MOBS != null) entries.add(SPAWNS_MOBS);
        if (OR_TRIGGERS_EVENTS != null) entries.add(OR_TRIGGERS_EVENTS);
        if (REFINED_INGOT != null) entries.add(REFINED_INGOT);
    }
}