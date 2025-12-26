package com.modgen.cheesyblocks;

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
    public static Item CHEESE_SWORD;
    public static Item CHEESE_HELMET;
    public static Item CHEESE_CHESTPLATE;
    public static Item CHEESE_LEGGINGS;
    public static Item CHEESE_BOOTS;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(CheesyBlocks.MOD_ID, name);
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
        CheesyBlocks.LOGGER.info("Registering items for " + CheesyBlocks.MOD_ID);
        CHEESE_SWORD = registerItem("cheese_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(500).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CHEESE_HELMET = registerItem("cheese_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(50));
        CHEESE_CHESTPLATE = registerItem("cheese_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(80));
        CHEESE_LEGGINGS = registerItem("cheese_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(70));
        CHEESE_BOOTS = registerItem("cheese_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(60));
    }
    
    public static Item getFirstItem() {
        return CHEESE_SWORD != null ? CHEESE_SWORD : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_SWORD != null) entries.add(CHEESE_SWORD);
        if (CHEESE_HELMET != null) entries.add(CHEESE_HELMET);
        if (CHEESE_CHESTPLATE != null) entries.add(CHEESE_CHESTPLATE);
        if (CHEESE_LEGGINGS != null) entries.add(CHEESE_LEGGINGS);
        if (CHEESE_BOOTS != null) entries.add(CHEESE_BOOTS);
    }
}