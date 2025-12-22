package com.modgen.boltstaff;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.boltstaff.item.ThunderWandItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item THUNDER_WAND;

    /**
     * Minecraft 1.21.x Item Registration Pattern
     * CRITICAL: Item.Settings.registryKey() MUST be called BEFORE Item construction
     * This factory pattern ensures the registry key is set on settings before the item is created
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(BoltStaff.MOD_ID, name));
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
        BoltStaff.LOGGER.info("Registering items for " + BoltStaff.MOD_ID);
        THUNDER_WAND = registerItem("thunder_wand", ThunderWandItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return THUNDER_WAND != null ? THUNDER_WAND : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (THUNDER_WAND != null) entries.add(THUNDER_WAND);
    }
}