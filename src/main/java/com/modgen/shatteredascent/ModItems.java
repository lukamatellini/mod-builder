package com.modgen.shatteredascent;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import java.util.function.Function;
import com.modgen.shatteredascent.ModItemsA;
import com.modgen.shatteredascent.ModItemsB;

/**
 * ModItems - Coordinator class for chunked item registration
 * Items are split across 2 classes to avoid method size limits
 */
public class ModItems {
    
    public static void registerItems() {
        ShatteredAscent.LOGGER.info("Registering items for " + ShatteredAscent.MOD_ID + " (17 items in 2 chunks)");
        ModItemsA.registerItems();
        ModItemsB.registerItems();
    }
    
    public static Item getFirstItem() {
        return ModItemsA.VOID_HELMET != null ? ModItemsA.VOID_HELMET : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ModItemsA.VOID_HELMET != null) entries.add(ModItemsA.VOID_HELMET);
        if (ModItemsA.VOID_CHESTPLATE != null) entries.add(ModItemsA.VOID_CHESTPLATE);
        if (ModItemsA.VOID_LEGGINGS != null) entries.add(ModItemsA.VOID_LEGGINGS);
        if (ModItemsA.VOID_BOOTS != null) entries.add(ModItemsA.VOID_BOOTS);
        if (ModItemsA.SHARDBREAKER_SWORD != null) entries.add(ModItemsA.SHARDBREAKER_SWORD);
        if (ModItemsA.CRYSTAL_STAFF != null) entries.add(ModItemsA.CRYSTAL_STAFF);
        if (ModItemsA.ABYSSAL_PICKAXE != null) entries.add(ModItemsA.ABYSSAL_PICKAXE);
        if (ModItemsA.SOUL_ORB != null) entries.add(ModItemsA.SOUL_ORB);
        if (ModItemsA.VOID_INGOT != null) entries.add(ModItemsA.VOID_INGOT);
        if (ModItemsA.CRYSTAL_SHARD != null) entries.add(ModItemsA.CRYSTAL_SHARD);
        if (ModItemsA.ABYSSAL_ALLOY != null) entries.add(ModItemsA.ABYSSAL_ALLOY);
        if (ModItemsA.VOID_STICK != null) entries.add(ModItemsA.VOID_STICK);
        if (ModItemsA.SHATTERED_SOUL != null) entries.add(ModItemsA.SHATTERED_SOUL);
        if (ModItemsA.ELDER_SHARD != null) entries.add(ModItemsA.ELDER_SHARD);
        if (ModItemsA.VOID_PLANKS != null) entries.add(ModItemsA.VOID_PLANKS);
        if (ModItemsB.WARP_STONE != null) entries.add(ModItemsB.WARP_STONE);
        if (ModItemsB.THE_SHATTERED_REALM_PORTAL_IGNITER != null) entries.add(ModItemsB.THE_SHATTERED_REALM_PORTAL_IGNITER);
    }
    
    // Shared registration helper for chunk classes
    static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ShatteredAscent.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }
}