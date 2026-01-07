package com.modgen.cheesyblade;

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
    public static Item CHEESE_SLICE;
    public static Item MOLDY_CHEESE;
    public static Item CHEESE_CURDS;
    public static Item CHEESE_ARMOR_HELMET;
    public static Item CHEESE_ARMOR_CHESTPLATE;
    public static Item CHEESE_ARMOR_LEGGINGS;
    public static Item CHEESE_ARMOR_BOOTS;
    public static Item X_CHEESE_SLICE;
    public static Item X_CHEESE_BLOCK;
    public static Item _1X_MOLDY_CHEESE;
    public static Item X_MOLDY_CHEESE;
    public static Item X_CHEESE_CURDS_SMELTS_INTO_CHEESE_CURDS;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(CheesyBlade.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        CheesyBlade.LOGGER.info("Registering items for " + CheesyBlade.MOD_ID);
        CHEESE_SWORD = registerItem("cheese_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(250).rarity(Rarity.UNCOMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CHEESE_SLICE = registerItem("cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        MOLDY_CHEESE = registerItem("moldy_cheese", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESE_CURDS = registerItem("cheese_curds", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESE_ARMOR_HELMET = registerItem("cheese_armor_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(120).rarity(Rarity.UNCOMMON));
        CHEESE_ARMOR_CHESTPLATE = registerItem("cheese_armor_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(180).rarity(Rarity.UNCOMMON));
        CHEESE_ARMOR_LEGGINGS = registerItem("cheese_armor_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(160).rarity(Rarity.UNCOMMON));
        CHEESE_ARMOR_BOOTS = registerItem("cheese_armor_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(130).rarity(Rarity.UNCOMMON));
        X_CHEESE_SLICE = registerItem("x_cheese_slice", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        X_CHEESE_BLOCK = registerItem("x_cheese_block", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        _1X_MOLDY_CHEESE = registerItem("1x_moldy_cheese", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        X_MOLDY_CHEESE = registerItem("x_moldy_cheese", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        X_CHEESE_CURDS_SMELTS_INTO_CHEESE_CURDS = registerItem("x_cheese_curds_smelts_into_cheese_curds", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return CHEESE_SWORD != null ? CHEESE_SWORD : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_SWORD != null) entries.add(CHEESE_SWORD);
        if (CHEESE_SLICE != null) entries.add(CHEESE_SLICE);
        if (MOLDY_CHEESE != null) entries.add(MOLDY_CHEESE);
        if (CHEESE_CURDS != null) entries.add(CHEESE_CURDS);
        if (CHEESE_ARMOR_HELMET != null) entries.add(CHEESE_ARMOR_HELMET);
        if (CHEESE_ARMOR_CHESTPLATE != null) entries.add(CHEESE_ARMOR_CHESTPLATE);
        if (CHEESE_ARMOR_LEGGINGS != null) entries.add(CHEESE_ARMOR_LEGGINGS);
        if (CHEESE_ARMOR_BOOTS != null) entries.add(CHEESE_ARMOR_BOOTS);
        if (X_CHEESE_SLICE != null) entries.add(X_CHEESE_SLICE);
        if (X_CHEESE_BLOCK != null) entries.add(X_CHEESE_BLOCK);
        if (_1X_MOLDY_CHEESE != null) entries.add(_1X_MOLDY_CHEESE);
        if (X_MOLDY_CHEESE != null) entries.add(X_MOLDY_CHEESE);
        if (X_CHEESE_CURDS_SMELTS_INTO_CHEESE_CURDS != null) entries.add(X_CHEESE_CURDS_SMELTS_INTO_CHEESE_CURDS);
    }
}