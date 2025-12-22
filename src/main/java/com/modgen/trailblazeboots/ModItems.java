package com.modgen.trailblazeboots;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.item.equipment.EquipmentType;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item SPEEDWALKER_BOOTS;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TrailblazeBoots.MOD_ID, name));
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
        TrailblazeBoots.LOGGER.info("Registering items for " + TrailblazeBoots.MOD_ID);
        SPEEDWALKER_BOOTS = registerItem("speedwalker_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentType.BOOTS, settings), new Item.Settings().Settings().maxCount(1).maxDamage(350).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return SPEEDWALKER_BOOTS != null ? SPEEDWALKER_BOOTS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SPEEDWALKER_BOOTS != null) entries.add(SPEEDWALKER_BOOTS);
    }
}