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

import com.modgen.luckysurprises.item.LuckyBlockItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item LUCKY_BLOCK;

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
        LUCKY_BLOCK = registerItem("lucky_block", LuckyBlockItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK != null ? LUCKY_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK);
    }
}