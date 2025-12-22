package com.modgen.stormstaff;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.stormstaff.item.MagicWandItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item MAGIC_WAND;

    /**
     * Minecraft 1.21.x Item Registration Pattern
     * CRITICAL: Item.Settings.registryKey() MUST be called BEFORE Item construction
     * This factory pattern ensures the registry key is set on settings before the item is created
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(StormStaff.MOD_ID, name));
        Item item = factory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        StormStaff.LOGGER.info("Registering items for " + StormStaff.MOD_ID);
        MAGIC_WAND = registerItem("magic_wand", MagicWandItem::new, new Item.Settings().maxCount(1).maxDamage(250).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return MAGIC_WAND != null ? MAGIC_WAND : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (MAGIC_WAND != null) entries.add(MAGIC_WAND);
    }
}