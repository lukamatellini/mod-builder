package com.modgen.chilldelights;

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
    public static Item ICE_CREAM_BASE;
    public static Item VANILLA_ICE_CREAM;
    public static Item CHOCOLATE_ICE_CREAM;
    public static Item STRAWBERRY_ICE_CREAM;
    public static Item MINT_CHOCOLATE_CHIP_ICE_CREAM;
    public static Item DOUGH;
    public static Item COOKIE_DOUGH_ICE_CREAM;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ChillDelights.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        ChillDelights.LOGGER.info("Registering items for " + ChillDelights.MOD_ID);
        ICE_CREAM_BASE = registerItem("ice_cream_base", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        VANILLA_ICE_CREAM = registerItem("vanilla_ice_cream", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHOCOLATE_ICE_CREAM = registerItem("chocolate_ice_cream", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        STRAWBERRY_ICE_CREAM = registerItem("strawberry_ice_cream", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        MINT_CHOCOLATE_CHIP_ICE_CREAM = registerItem("mint_chocolate_chip_ice_cream", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        DOUGH = registerItem("dough", Item::new, new Item.Settings().rarity(Rarity.COMMON));
        COOKIE_DOUGH_ICE_CREAM = registerItem("cookie_dough_ice_cream", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
    }
    
    public static Item getFirstItem() {
        return ICE_CREAM_BASE != null ? ICE_CREAM_BASE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ICE_CREAM_BASE != null) entries.add(ICE_CREAM_BASE);
        if (VANILLA_ICE_CREAM != null) entries.add(VANILLA_ICE_CREAM);
        if (CHOCOLATE_ICE_CREAM != null) entries.add(CHOCOLATE_ICE_CREAM);
        if (STRAWBERRY_ICE_CREAM != null) entries.add(STRAWBERRY_ICE_CREAM);
        if (MINT_CHOCOLATE_CHIP_ICE_CREAM != null) entries.add(MINT_CHOCOLATE_CHIP_ICE_CREAM);
        if (DOUGH != null) entries.add(DOUGH);
        if (COOKIE_DOUGH_ICE_CREAM != null) entries.add(COOKIE_DOUGH_ICE_CREAM);
    }
}