package com.modgen.strengthi;


import net.minecraft.item.Item;
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
import net.minecraft.item.Items;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item CHEESE_SLICE;
    public static Item MELTED_CHEESE;
    public static Item AGED_CHEESE;
    public static Item CHEESE_PICKAXE;
    public static Item CHEESE_SWORD;
    public static Item CHEESE_HELMET;
    public static Item CHEESE_CHESTPLATE;
    public static Item CHEESE_LEGGINGS;
    public static Item CHEESE_BOOTS;
    public static Item CHEESE_BLOCK;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(StrengthI.MOD_ID, name);
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
        StrengthI.LOGGER.info("Registering items for " + StrengthI.MOD_ID);
        CHEESE_SLICE = registerItem("cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        MELTED_CHEESE = registerItem("melted_cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        AGED_CHEESE = registerItem("aged_cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESE_PICKAXE = registerItem("cheese_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(100).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        CHEESE_SWORD = registerItem("cheese_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(120).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CHEESE_HELMET = registerItem("cheese_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(80));
        CHEESE_CHESTPLATE = registerItem("cheese_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(110));
        CHEESE_LEGGINGS = registerItem("cheese_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(100));
        CHEESE_BOOTS = registerItem("cheese_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(70));
        CHEESE_BLOCK = registerItem("cheese_block", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return CHEESE_SLICE != null ? CHEESE_SLICE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_SLICE != null) entries.add(CHEESE_SLICE);
        if (MELTED_CHEESE != null) entries.add(MELTED_CHEESE);
        if (AGED_CHEESE != null) entries.add(AGED_CHEESE);
        if (CHEESE_PICKAXE != null) entries.add(CHEESE_PICKAXE);
        if (CHEESE_SWORD != null) entries.add(CHEESE_SWORD);
        if (CHEESE_HELMET != null) entries.add(CHEESE_HELMET);
        if (CHEESE_CHESTPLATE != null) entries.add(CHEESE_CHESTPLATE);
        if (CHEESE_LEGGINGS != null) entries.add(CHEESE_LEGGINGS);
        if (CHEESE_BOOTS != null) entries.add(CHEESE_BOOTS);
        if (CHEESE_BLOCK != null) entries.add(CHEESE_BLOCK);
    }
}