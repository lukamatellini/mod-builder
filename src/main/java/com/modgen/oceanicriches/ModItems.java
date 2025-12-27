package com.modgen.oceanicriches;

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

import com.modgen.oceanicriches.item.AquamarineHoeItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item RAW_AQUAMARINE;
    public static Item AQUAMARINE_GEM;
    public static Item AQUAMARINE_INGOT;
    public static Item AQUAMARINE_PICKAXE;
    public static Item AQUAMARINE_AXE;
    public static Item AQUAMARINE_SHOVEL;
    public static Item AQUAMARINE_SWORD;
    public static Item AQUAMARINE_HOE;
    public static Item AQUAMARINE_HELMET;
    public static Item AQUAMARINE_CHESTPLATE;
    public static Item AQUAMARINE_LEGGINGS;
    public static Item AQUAMARINE_BOOTS;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(OceanicRiches.MOD_ID, name);
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
        OceanicRiches.LOGGER.info("Registering items for " + OceanicRiches.MOD_ID);
        RAW_AQUAMARINE = registerItem("raw_aquamarine", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        AQUAMARINE_GEM = registerItem("aquamarine_gem", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        AQUAMARINE_INGOT = registerItem("aquamarine_ingot", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        AQUAMARINE_PICKAXE = registerItem("aquamarine_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1800).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        AQUAMARINE_AXE = registerItem("aquamarine_axe", settings -> new AxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1800).rarity(Rarity.RARE).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5.0f, -3.0f)));
        AQUAMARINE_SHOVEL = registerItem("aquamarine_shovel", Item::new, new Item.Settings().maxDamage(1800).rarity(Rarity.RARE));
        AQUAMARINE_SWORD = registerItem("aquamarine_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(2000).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        AQUAMARINE_HOE = registerItem("aquamarine_hoe", AquamarineHoeItem::new, new Item.Settings().maxDamage(1500).rarity(Rarity.RARE));
        AQUAMARINE_HELMET = registerItem("aquamarine_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(400).rarity(Rarity.EPIC));
        AQUAMARINE_CHESTPLATE = registerItem("aquamarine_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(570).rarity(Rarity.EPIC));
        AQUAMARINE_LEGGINGS = registerItem("aquamarine_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(520).rarity(Rarity.EPIC));
        AQUAMARINE_BOOTS = registerItem("aquamarine_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(450).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return RAW_AQUAMARINE != null ? RAW_AQUAMARINE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RAW_AQUAMARINE != null) entries.add(RAW_AQUAMARINE);
        if (AQUAMARINE_GEM != null) entries.add(AQUAMARINE_GEM);
        if (AQUAMARINE_INGOT != null) entries.add(AQUAMARINE_INGOT);
        if (AQUAMARINE_PICKAXE != null) entries.add(AQUAMARINE_PICKAXE);
        if (AQUAMARINE_AXE != null) entries.add(AQUAMARINE_AXE);
        if (AQUAMARINE_SHOVEL != null) entries.add(AQUAMARINE_SHOVEL);
        if (AQUAMARINE_SWORD != null) entries.add(AQUAMARINE_SWORD);
        if (AQUAMARINE_HOE != null) entries.add(AQUAMARINE_HOE);
        if (AQUAMARINE_HELMET != null) entries.add(AQUAMARINE_HELMET);
        if (AQUAMARINE_CHESTPLATE != null) entries.add(AQUAMARINE_CHESTPLATE);
        if (AQUAMARINE_LEGGINGS != null) entries.add(AQUAMARINE_LEGGINGS);
        if (AQUAMARINE_BOOTS != null) entries.add(AQUAMARINE_BOOTS);
    }
}