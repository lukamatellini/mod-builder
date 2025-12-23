package com.modgen.luckysurprises;

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
    public static Item LUCKY_SWORD;
    public static Item LUCKY_PICKAXE;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LuckySurprises.MOD_ID, name));
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
        LuckySurprises.LOGGER.info("Registering items for " + LuckySurprises.MOD_ID);
        LUCKY_SWORD = registerItem("lucky_sword", settings -> new SwordItem(ToolMaterial.DIAMOND, 3f, -2.4f, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.UNCOMMON));
        LUCKY_PICKAXE = registerItem("lucky_pickaxe", settings -> new PickaxeItem(ToolMaterial.DIAMOND, 1f, -2.8f, settings), new Item.Settings().maxCount(1).maxDamage(600).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_SWORD != null ? LUCKY_SWORD : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_SWORD != null) entries.add(LUCKY_SWORD);
        if (LUCKY_PICKAXE != null) entries.add(LUCKY_PICKAXE);
    }
}