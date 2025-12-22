package com.modgen.rubydepths;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item RUBY_GEM;
    public static Item RUBY_PICKAXE;
    public static Item RUBY_AXE;
    public static Item RUBY_SHOVEL;
    public static Item RUBY_SWORD;
    public static Item RUBY_HOE;
    public static Item RUBY_HELMET;
    public static Item RUBY_CHESTPLATE;
    public static Item RUBY_LEGGINGS;
    public static Item RUBY_BOOTS;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RubyDepths.MOD_ID, name));
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        RubyDepths.LOGGER.info("Registering items for " + RubyDepths.MOD_ID);
        RUBY_GEM = registerItem("ruby_gem", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        RUBY_PICKAXE = registerItem("ruby_pickaxe", PickaxeItem::new, new Item.Settings().Settings().maxCount(1).maxDamage(1800).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        RUBY_AXE = registerItem("ruby_axe", AxeItem::new, new Item.Settings().Settings().maxCount(1).maxDamage(1800).rarity(Rarity.RARE).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 5.0f, -3.0f)));
        RUBY_SHOVEL = registerItem("ruby_shovel", Item::new, new Item.Settings().maxDamage(1800).rarity(Rarity.RARE));
        RUBY_SWORD = registerItem("ruby_sword", SwordItem::new, new Item.Settings().Settings().maxCount(1).maxDamage(1800).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        RUBY_HOE = registerItem("ruby_hoe", Item::new, new Item.Settings().maxDamage(1800).rarity(Rarity.RARE));
        RUBY_HELMET = registerItem("ruby_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().Settings().maxCount(1).maxDamage(264).rarity(Rarity.RARE));
        RUBY_CHESTPLATE = registerItem("ruby_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().Settings().maxCount(1).maxDamage(384).rarity(Rarity.RARE));
        RUBY_LEGGINGS = registerItem("ruby_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().Settings().maxCount(1).maxDamage(360).rarity(Rarity.RARE));
        RUBY_BOOTS = registerItem("ruby_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().Settings().maxCount(1).maxDamage(312).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return RUBY_GEM != null ? RUBY_GEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RUBY_GEM != null) entries.add(RUBY_GEM);
        if (RUBY_PICKAXE != null) entries.add(RUBY_PICKAXE);
        if (RUBY_AXE != null) entries.add(RUBY_AXE);
        if (RUBY_SHOVEL != null) entries.add(RUBY_SHOVEL);
        if (RUBY_SWORD != null) entries.add(RUBY_SWORD);
        if (RUBY_HOE != null) entries.add(RUBY_HOE);
        if (RUBY_HELMET != null) entries.add(RUBY_HELMET);
        if (RUBY_CHESTPLATE != null) entries.add(RUBY_CHESTPLATE);
        if (RUBY_LEGGINGS != null) entries.add(RUBY_LEGGINGS);
        if (RUBY_BOOTS != null) entries.add(RUBY_BOOTS);
    }
}