package com.modgen.cheesycraft;

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
    public static Item CHEESE_SLICE;
    public static Item CHEESE_SWORD;
    public static Item CHEESE_PICKAXE;
    public static Item CHEESE_AXE;
    public static Item CHEESE_HELMET;
    public static Item CHEESE_CHESTPLATE;
    public static Item CHEESE_LEGGINGS;
    public static Item CHEESE_BOOTS;
    public static Item MOUSE_TRAP;
    public static Item COMMON_CHEESE_SLICE;
    public static Item RARE_STRING;
    public static Item RARE_POISON_GLAND;
    public static Item EPIC_CHEESE_BLOCK;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(Cheesycraft.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        Cheesycraft.LOGGER.info("Registering items for " + Cheesycraft.MOD_ID);
        CHEESE_SLICE = registerItem("cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESE_SWORD = registerItem("cheese_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(150).rarity(Rarity.COMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CHEESE_PICKAXE = registerItem("cheese_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(150).rarity(Rarity.COMMON).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        CHEESE_AXE = registerItem("cheese_axe", settings -> new AxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(150).rarity(Rarity.COMMON).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5.0f, -3.0f)));
        CHEESE_HELMET = registerItem("cheese_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(100).rarity(Rarity.COMMON));
        CHEESE_CHESTPLATE = registerItem("cheese_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(160).rarity(Rarity.COMMON));
        CHEESE_LEGGINGS = registerItem("cheese_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(140).rarity(Rarity.COMMON));
        CHEESE_BOOTS = registerItem("cheese_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(120).rarity(Rarity.COMMON));
        MOUSE_TRAP = registerItem("mouse_trap", Item::new, new Item.Settings().rarity(Rarity.COMMON));
        COMMON_CHEESE_SLICE = registerItem("common_cheese_slice", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        RARE_STRING = registerItem("rare_string", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        RARE_POISON_GLAND = registerItem("rare_poison_gland", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        EPIC_CHEESE_BLOCK = registerItem("epic_cheese_block", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return CHEESE_SLICE != null ? CHEESE_SLICE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_SLICE != null) entries.add(CHEESE_SLICE);
        if (CHEESE_SWORD != null) entries.add(CHEESE_SWORD);
        if (CHEESE_PICKAXE != null) entries.add(CHEESE_PICKAXE);
        if (CHEESE_AXE != null) entries.add(CHEESE_AXE);
        if (CHEESE_HELMET != null) entries.add(CHEESE_HELMET);
        if (CHEESE_CHESTPLATE != null) entries.add(CHEESE_CHESTPLATE);
        if (CHEESE_LEGGINGS != null) entries.add(CHEESE_LEGGINGS);
        if (CHEESE_BOOTS != null) entries.add(CHEESE_BOOTS);
        if (MOUSE_TRAP != null) entries.add(MOUSE_TRAP);
        if (COMMON_CHEESE_SLICE != null) entries.add(COMMON_CHEESE_SLICE);
        if (RARE_STRING != null) entries.add(RARE_STRING);
        if (RARE_POISON_GLAND != null) entries.add(RARE_POISON_GLAND);
        if (EPIC_CHEESE_BLOCK != null) entries.add(EPIC_CHEESE_BLOCK);
    }
}