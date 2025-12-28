package com.modgen.stormcallersrod;


import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.stormcallersrod.item.LightningWandItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item POWER_SHARD;
    public static Item LIGHTNING_WAND;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(StormcallersRod.MOD_ID, name);
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
        StormcallersRod.LOGGER.info("Registering items for " + StormcallersRod.MOD_ID);
        POWER_SHARD = registerItem("power_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        LIGHTNING_WAND = registerItem("lightning_wand", LightningWandItem::new, new Item.Settings().maxCount(1).maxDamage(1561).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return POWER_SHARD != null ? POWER_SHARD : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (POWER_SHARD != null) entries.add(POWER_SHARD);
        if (LIGHTNING_WAND != null) entries.add(LIGHTNING_WAND);
    }
}