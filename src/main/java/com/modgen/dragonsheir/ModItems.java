package com.modgen.dragonsheir;

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
    public static Item PHOENIX_FEATHER;
    public static Item RUBY_HELMET;
    public static Item RUBY_CHESTPLATE;
    public static Item RUBY_LEGGINGS;
    public static Item RUBY_BOOTS;
    public static Item DRAGON_SLAYER_SWORD;
    public static Item THUNDER_STAFF;
    public static Item VOID_PICKAXE;
    public static Item VOID_INGOT;
    public static Item RUBY_SHARD;
    public static Item MAGIC_CRYSTAL;
    public static Item VOID_DUST;
    public static Item VOID_IGNITER;
    public static Item SKY_CATALYST;
    public static Item PIRATE_TREASURE_CHEST_KEY;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(DragonsHeir.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        DragonsHeir.LOGGER.info("Registering items for " + DragonsHeir.MOD_ID);
        RUBY_INGOT = registerItem("ruby_ingot", Item::new);
        SAPPHIRE_SHARD = registerItem("sapphire_shard", Item::new);
        DRAGON_SCALE = registerItem("dragon_scale", Item::new);
        MAGIC_PIZZA = registerItem("magic_pizza", Item::new, new Item.Settings().maxCount(16));
        FROST_BERRY = registerItem("frost_berry", Item::new);
        PHOENIX_FEATHER_CAKE = registerItem("phoenix_feather_cake", Item::new, new Item.Settings().maxCount(1));
        PHOENIX_FEATHER = registerItem("phoenix_feather", Item::new);
        RUBY_HELMET = registerItem("ruby_helmet", Item::new, new Item.Settings().maxCount(1));
        RUBY_CHESTPLATE = registerItem("ruby_chestplate", Item::new, new Item.Settings().maxCount(1));
        RUBY_LEGGINGS = registerItem("ruby_leggings", Item::new, new Item.Settings().maxCount(1));
        RUBY_BOOTS = registerItem("ruby_boots", Item::new, new Item.Settings().maxCount(1));
        DRAGON_SLAYER_SWORD = registerItem("dragon_slayer_sword", Item::new, new Item.Settings().maxCount(1));
        THUNDER_STAFF = registerItem("thunder_staff", Item::new, new Item.Settings().maxCount(1));
        VOID_PICKAXE = registerItem("void_pickaxe", Item::new, new Item.Settings().maxCount(1));
        VOID_INGOT = registerItem("void_ingot", Item::new);
        RUBY_SHARD = registerItem("ruby_shard", Item::new);
        MAGIC_CRYSTAL = registerItem("magic_crystal", Item::new);
        VOID_DUST = registerItem("void_dust", Item::new);
        VOID_IGNITER = registerItem("void_igniter", Item::new, new Item.Settings().maxCount(1));
        SKY_CATALYST = registerItem("sky_catalyst", Item::new);
        PIRATE_TREASURE_CHEST_KEY = registerItem("pirate_treasure_chest_key", Item::new, new Item.Settings().maxCount(1));
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
        if (PHOENIX_FEATHER != null) entries.add(PHOENIX_FEATHER);
        if (RUBY_HELMET != null) entries.add(RUBY_HELMET);
        if (RUBY_CHESTPLATE != null) entries.add(RUBY_CHESTPLATE);
        if (RUBY_LEGGINGS != null) entries.add(RUBY_LEGGINGS);
        if (RUBY_BOOTS != null) entries.add(RUBY_BOOTS);
        if (DRAGON_SLAYER_SWORD != null) entries.add(DRAGON_SLAYER_SWORD);
        if (THUNDER_STAFF != null) entries.add(THUNDER_STAFF);
        if (VOID_PICKAXE != null) entries.add(VOID_PICKAXE);
        if (VOID_INGOT != null) entries.add(VOID_INGOT);
        if (RUBY_SHARD != null) entries.add(RUBY_SHARD);
        if (MAGIC_CRYSTAL != null) entries.add(MAGIC_CRYSTAL);
        if (VOID_DUST != null) entries.add(VOID_DUST);
        if (VOID_IGNITER != null) entries.add(VOID_IGNITER);
        if (SKY_CATALYST != null) entries.add(SKY_CATALYST);
        if (PIRATE_TREASURE_CHEST_KEY != null) entries.add(PIRATE_TREASURE_CHEST_KEY);
    }
}