package com.modgen.luckylootboxes;

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
    public static Item IRON_PICKAXE;
    public static Item IRON_AXE;
    public static Item IRON_HELMET;
    public static Item IRON_CHESTPLATE;
    public static Item IRON_LEGGINGS;
    public static Item IRON_BOOTS;
    public static Item BOW;
    public static Item DIAMOND_SWORD;
    public static Item DIAMOND_HELMET;
    public static Item DIAMOND_CHESTPLATE;
    public static Item DIAMOND_LEGGINGS;
    public static Item DIAMOND_BOOTS;
    public static Item ENCHANTED_DIAMOND_HELMET;
    public static Item ENCHANTED_DIAMOND_CHESTPLATE;
    public static Item ENCHANTED_DIAMOND_LEGGINGS;
    public static Item ENCHANTED_DIAMOND_BOOTS;
    public static Item VEX;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyLootBoxes.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyLootBoxes.LOGGER.info("Registering items for " + LuckyLootBoxes.MOD_ID);
        IRON_PICKAXE = registerItem("iron_pickaxe", PickaxeItem::new, new Item.Settings().maxDamage(250).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        IRON_AXE = registerItem("iron_axe", AxeItem::new, new Item.Settings().maxDamage(250).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5.0f, -3.0f)));
        IRON_HELMET = registerItem("iron_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(165));
        IRON_CHESTPLATE = registerItem("iron_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(240));
        IRON_LEGGINGS = registerItem("iron_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(225));
        IRON_BOOTS = registerItem("iron_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(195));
        BOW = registerItem("bow", BowItem::new, new Item.Settings().maxDamage(384));
        DIAMOND_SWORD = registerItem("diamond_sword", SwordItem::new, new Item.Settings().maxDamage(1561).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        DIAMOND_HELMET = registerItem("diamond_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(363));
        DIAMOND_CHESTPLATE = registerItem("diamond_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(528));
        DIAMOND_LEGGINGS = registerItem("diamond_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(495));
        DIAMOND_BOOTS = registerItem("diamond_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(429));
        ENCHANTED_DIAMOND_HELMET = registerItem("enchanted_diamond_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(363).rarity(Rarity.RARE));
        ENCHANTED_DIAMOND_CHESTPLATE = registerItem("enchanted_diamond_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(528).rarity(Rarity.RARE));
        ENCHANTED_DIAMOND_LEGGINGS = registerItem("enchanted_diamond_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(495).rarity(Rarity.RARE));
        ENCHANTED_DIAMOND_BOOTS = registerItem("enchanted_diamond_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(429).rarity(Rarity.RARE));
        VEX = registerItem("vex", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return IRON_PICKAXE != null ? IRON_PICKAXE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (IRON_PICKAXE != null) entries.add(IRON_PICKAXE);
        if (IRON_AXE != null) entries.add(IRON_AXE);
        if (IRON_HELMET != null) entries.add(IRON_HELMET);
        if (IRON_CHESTPLATE != null) entries.add(IRON_CHESTPLATE);
        if (IRON_LEGGINGS != null) entries.add(IRON_LEGGINGS);
        if (IRON_BOOTS != null) entries.add(IRON_BOOTS);
        if (BOW != null) entries.add(BOW);
        if (DIAMOND_SWORD != null) entries.add(DIAMOND_SWORD);
        if (DIAMOND_HELMET != null) entries.add(DIAMOND_HELMET);
        if (DIAMOND_CHESTPLATE != null) entries.add(DIAMOND_CHESTPLATE);
        if (DIAMOND_LEGGINGS != null) entries.add(DIAMOND_LEGGINGS);
        if (DIAMOND_BOOTS != null) entries.add(DIAMOND_BOOTS);
        if (ENCHANTED_DIAMOND_HELMET != null) entries.add(ENCHANTED_DIAMOND_HELMET);
        if (ENCHANTED_DIAMOND_CHESTPLATE != null) entries.add(ENCHANTED_DIAMOND_CHESTPLATE);
        if (ENCHANTED_DIAMOND_LEGGINGS != null) entries.add(ENCHANTED_DIAMOND_LEGGINGS);
        if (ENCHANTED_DIAMOND_BOOTS != null) entries.add(ENCHANTED_DIAMOND_BOOTS);
        if (VEX != null) entries.add(VEX);
    }
}