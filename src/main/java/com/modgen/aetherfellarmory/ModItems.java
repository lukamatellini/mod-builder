package com.modgen.aetherfellarmory;

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
    public static Item RUBY_INGOT;
    public static Item SAPPHIRE_SHARD;
    public static Item DRAGON_SCALE;
    public static Item MAGIC_PIZZA;
    public static Item FROST_BERRY;
    public static Item PHOENIX_FEATHER_CAKE;
    public static Item RUBY_HELMET;
    public static Item RUBY_CHESTPLATE;
    public static Item RUBY_LEGGINGS;
    public static Item RUBY_BOOTS;
    public static Item DRAGON_SLAYER_SWORD;
    public static Item THUNDER_STAFF;
    public static Item VOID_PICKAXE;
    public static Item VOID_INGOT;
    public static Item ICE;
    public static Item PACKED_ICE;
    public static Item RUBY_SHARD;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(AetherfellArmory.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        AetherfellArmory.LOGGER.info("Registering items for " + AetherfellArmory.MOD_ID);
        RUBY_INGOT = registerItem("ruby_ingot", Item::new, new Item.Settings().rarity(Rarity.RARE));
        SAPPHIRE_SHARD = registerItem("sapphire_shard", Item::new, new Item.Settings().rarity(Rarity.COMMON));
        DRAGON_SCALE = registerItem("dragon_scale", Item::new, new Item.Settings().rarity(Rarity.EPIC));
        MAGIC_PIZZA = registerItem("magic_pizza", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        FROST_BERRY = registerItem("frost_berry", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        PHOENIX_FEATHER_CAKE = registerItem("phoenix_feather_cake", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        RUBY_HELMET = registerItem("ruby_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(300).rarity(Rarity.RARE));
        RUBY_CHESTPLATE = registerItem("ruby_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(400).rarity(Rarity.RARE));
        RUBY_LEGGINGS = registerItem("ruby_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxDamage(350).rarity(Rarity.RARE));
        RUBY_BOOTS = registerItem("ruby_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxDamage(250).rarity(Rarity.RARE));
        DRAGON_SLAYER_SWORD = registerItem("dragon_slayer_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(1500).rarity(Rarity.COMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        THUNDER_STAFF = registerItem("thunder_staff", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        VOID_PICKAXE = registerItem("void_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(1000).rarity(Rarity.EPIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        VOID_INGOT = registerItem("void_ingot", Item::new, new Item.Settings().rarity(Rarity.RARE));
        ICE = registerItem("ice", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        PACKED_ICE = registerItem("packed_ice", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        RUBY_SHARD = registerItem("ruby_shard", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return RUBY_INGOT != null ? RUBY_INGOT : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RUBY_INGOT != null) entries.add(RUBY_INGOT);
        if (SAPPHIRE_SHARD != null) entries.add(SAPPHIRE_SHARD);
        if (DRAGON_SCALE != null) entries.add(DRAGON_SCALE);
        if (MAGIC_PIZZA != null) entries.add(MAGIC_PIZZA);
        if (FROST_BERRY != null) entries.add(FROST_BERRY);
        if (PHOENIX_FEATHER_CAKE != null) entries.add(PHOENIX_FEATHER_CAKE);
        if (RUBY_HELMET != null) entries.add(RUBY_HELMET);
        if (RUBY_CHESTPLATE != null) entries.add(RUBY_CHESTPLATE);
        if (RUBY_LEGGINGS != null) entries.add(RUBY_LEGGINGS);
        if (RUBY_BOOTS != null) entries.add(RUBY_BOOTS);
        if (DRAGON_SLAYER_SWORD != null) entries.add(DRAGON_SLAYER_SWORD);
        if (THUNDER_STAFF != null) entries.add(THUNDER_STAFF);
        if (VOID_PICKAXE != null) entries.add(VOID_PICKAXE);
        if (VOID_INGOT != null) entries.add(VOID_INGOT);
        if (ICE != null) entries.add(ICE);
        if (PACKED_ICE != null) entries.add(PACKED_ICE);
        if (RUBY_SHARD != null) entries.add(RUBY_SHARD);
    }
}