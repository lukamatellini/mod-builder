package com.modgen.stormforgedsky;


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

import com.modgen.stormforgedsky.item.StormWandItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item STORM_WAND;
    public static Item HEAVENLY_ORB;
    public static Item STORM_ESSENCE;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(StormforgedSky.MOD_ID, name);
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
        StormforgedSky.LOGGER.info("Registering items for " + StormforgedSky.MOD_ID);
        STORM_WAND = registerItem("storm_wand", StormWandItem::new, new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.RARE));
        HEAVENLY_ORB = registerItem("heavenly_orb", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        STORM_ESSENCE = registerItem("storm_essence", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return STORM_WAND != null ? STORM_WAND : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (STORM_WAND != null) entries.add(STORM_WAND);
        if (HEAVENLY_ORB != null) entries.add(HEAVENLY_ORB);
        if (STORM_ESSENCE != null) entries.add(STORM_ESSENCE);
    }
}