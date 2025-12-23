package com.modgen.bananablaster;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.bananablaster.item.BananaWandItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item BANANA_WAND;
    public static Item BANANA;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BananaBlaster.MOD_ID, name));
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
        BananaBlaster.LOGGER.info("Registering items for " + BananaBlaster.MOD_ID);
        BANANA_WAND = registerItem("banana_wand", BananaWandItem::new, new Item.Settings().maxCount(1).maxDamage(128).rarity(Rarity.UNCOMMON));
        BANANA = registerItem("banana", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
    }
    
    public static Item getFirstItem() {
        return BANANA_WAND != null ? BANANA_WAND : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (BANANA_WAND != null) entries.add(BANANA_WAND);
        if (BANANA != null) entries.add(BANANA);
    }
}