package com.modgen.epicadventure;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import java.util.function.Function;
import com.modgen.epicadventure.ModItemsA;
import com.modgen.epicadventure.ModItemsB;

/**
 * ModItems - Coordinator class for chunked item registration
 * Items are split across 2 classes to avoid method size limits
 */
public class ModItems {
    
    public static void registerItems() {
        EpicAdventure.LOGGER.info("Registering items for " + EpicAdventure.MOD_ID + " (18 items in 2 chunks)");
        ModItemsA.registerItems();
        ModItemsB.registerItems();
    }
    
    public static Item getFirstItem() {
        return ModItemsA.VOID_SILK != null ? ModItemsA.VOID_SILK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ModItemsA.VOID_SILK != null) entries.add(ModItemsA.VOID_SILK);
        if (ModItemsA.WRAITH_ESSENCE != null) entries.add(ModItemsA.WRAITH_ESSENCE);
        if (ModItemsA.CRYSTAL_SHARD != null) entries.add(ModItemsA.CRYSTAL_SHARD);
        if (ModItemsA.ABYSSAL_SCALE != null) entries.add(ModItemsA.ABYSSAL_SCALE);
        if (ModItemsA.CORRUPTED_HEART != null) entries.add(ModItemsA.CORRUPTED_HEART);
        if (ModItemsA.ABYSSAL_COMPASS != null) entries.add(ModItemsA.ABYSSAL_COMPASS);
        if (ModItemsA.VOID_BLADE != null) entries.add(ModItemsA.VOID_BLADE);
        if (ModItemsA.CRYSTAL_PICKAXE != null) entries.add(ModItemsA.CRYSTAL_PICKAXE);
        if (ModItemsA.WRAITH_CLOAK != null) entries.add(ModItemsA.WRAITH_CLOAK);
        if (ModItemsA.VOID_KINGS_CROWN != null) entries.add(ModItemsA.VOID_KINGS_CROWN);
        if (ModItemsA.PURIFICATION_STAFF != null) entries.add(ModItemsA.PURIFICATION_STAFF);
        if (ModItemsA.POTION_OF_VOID_SIGHT != null) entries.add(ModItemsA.POTION_OF_VOID_SIGHT);
        if (ModItemsA.VOID_CATALYST != null) entries.add(ModItemsA.VOID_CATALYST);
        if (ModItemsA.CRYSTAL_HELMET != null) entries.add(ModItemsA.CRYSTAL_HELMET);
        if (ModItemsA.CRYSTAL_CHESTPLATE != null) entries.add(ModItemsA.CRYSTAL_CHESTPLATE);
        if (ModItemsB.CRYSTAL_LEGGINGS != null) entries.add(ModItemsB.CRYSTAL_LEGGINGS);
        if (ModItemsB.CRYSTAL_BOOTS != null) entries.add(ModItemsB.CRYSTAL_BOOTS);
        if (ModItemsB.ABYSSAL_VOID_PORTAL_IGNITER != null) entries.add(ModItemsB.ABYSSAL_VOID_PORTAL_IGNITER);
    }
    
    // Shared registration helper for chunk classes
    static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(EpicAdventure.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }
}