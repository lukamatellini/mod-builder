package com.modgen.gemstoneodyssey;

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
    public static Item RUBY;
    public static Item SAPPHIRE;
    public static Item RUBY_SWORD;
    public static Item SAPPHIRE_STAFF;
    public static Item RUBY_HELMET;
    public static Item RUBY_CHESTPLATE;
    public static Item RUBY_LEGGINGS;
    public static Item RUBY_BOOTS;
    public static Item SUNPETAL_CAKE;
    public static Item DRAGONFIRE_STEW;
    public static Item VOIDFISH_SKEWER;
    public static Item RUBY_INGOT;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(GemstoneOdyssey.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        GemstoneOdyssey.LOGGER.info("Registering items for " + GemstoneOdyssey.MOD_ID);
        RUBY = registerItem("ruby", Item::new);
        SAPPHIRE = registerItem("sapphire", Item::new);
        RUBY_SWORD = registerItem("ruby_sword", Item::new, new Item.Settings().maxCount(1).maxDamage(2500));
        SAPPHIRE_STAFF = registerItem("sapphire_staff", Item::new, new Item.Settings().maxCount(1).maxDamage(1500));
        RUBY_HELMET = registerItem("ruby_helmet", Item::new, new Item.Settings().maxCount(1).maxDamage(400));
        RUBY_CHESTPLATE = registerItem("ruby_chestplate", Item::new, new Item.Settings().maxCount(1).maxDamage(580));
        RUBY_LEGGINGS = registerItem("ruby_leggings", Item::new, new Item.Settings().maxCount(1).maxDamage(550));
        RUBY_BOOTS = registerItem("ruby_boots", Item::new, new Item.Settings().maxCount(1).maxDamage(350));
        SUNPETAL_CAKE = registerItem("sunpetal_cake", Item::new, new Item.Settings().maxCount(1));
        DRAGONFIRE_STEW = registerItem("dragonfire_stew", Item::new, new Item.Settings().maxCount(1));
        VOIDFISH_SKEWER = registerItem("voidfish_skewer", Item::new);
        RUBY_INGOT = registerItem("ruby_ingot", Item::new);
    }
    
    public static Item getFirstItem() {
        return RUBY != null ? RUBY : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RUBY != null) entries.add(RUBY);
        if (SAPPHIRE != null) entries.add(SAPPHIRE);
        if (RUBY_SWORD != null) entries.add(RUBY_SWORD);
        if (SAPPHIRE_STAFF != null) entries.add(SAPPHIRE_STAFF);
        if (RUBY_HELMET != null) entries.add(RUBY_HELMET);
        if (RUBY_CHESTPLATE != null) entries.add(RUBY_CHESTPLATE);
        if (RUBY_LEGGINGS != null) entries.add(RUBY_LEGGINGS);
        if (RUBY_BOOTS != null) entries.add(RUBY_BOOTS);
        if (SUNPETAL_CAKE != null) entries.add(SUNPETAL_CAKE);
        if (DRAGONFIRE_STEW != null) entries.add(DRAGONFIRE_STEW);
        if (VOIDFISH_SKEWER != null) entries.add(VOIDFISH_SKEWER);
        if (RUBY_INGOT != null) entries.add(RUBY_INGOT);
    }
}