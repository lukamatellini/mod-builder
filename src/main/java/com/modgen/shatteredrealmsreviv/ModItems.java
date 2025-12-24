package com.modgen.shatteredrealmsreviv;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import java.util.function.Function;
import com.modgen.shatteredrealmsreviv.ModItemsA;
import com.modgen.shatteredrealmsreviv.ModItemsB;

/**
 * ModItems - Coordinator class for chunked item registration
 * Items are split across 2 classes to avoid method size limits
 */
public class ModItems {
    
    public static void registerItems() {
        ShatteredRealmsRevival.LOGGER.info("Registering items for " + ShatteredRealmsRevival.MOD_ID + " (25 items in 2 chunks)");
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
        if (ModItemsA.VOID_SHARD != null) entries.add(ModItemsA.VOID_SHARD);
        if (ModItemsA.VOID_TEAR != null) entries.add(ModItemsA.VOID_TEAR);
        if (ModItemsA.GREATER_VOID_TEAR != null) entries.add(ModItemsA.GREATER_VOID_TEAR);
        if (ModItemsA.SHARDBREAKER_CORE != null) entries.add(ModItemsA.SHARDBREAKER_CORE);
        if (ModItemsA.LARGE_CRYSTAL != null) entries.add(ModItemsA.LARGE_CRYSTAL);
        if (ModItemsA.ABYSSAL_SHARD != null) entries.add(ModItemsA.ABYSSAL_SHARD);
        if (ModItemsA.HEART_OF_THE_VOID != null) entries.add(ModItemsA.HEART_OF_THE_VOID);
        if (ModItemsB.GEM_OF_THE_EMPRESS != null) entries.add(ModItemsB.GEM_OF_THE_EMPRESS);
        if (ModItemsB.RAW_CRYSTAL != null) entries.add(ModItemsB.RAW_CRYSTAL);
        if (ModItemsB.SHADOW_DUST != null) entries.add(ModItemsB.SHADOW_DUST);
        if (ModItemsB.ETHEREAL_THREAD != null) entries.add(ModItemsB.ETHEREAL_THREAD);
        if (ModItemsB.VOID_INGOT != null) entries.add(ModItemsB.VOID_INGOT);
        if (ModItemsB.CHARGED_CRYSTAL != null) entries.add(ModItemsB.CHARGED_CRYSTAL);
        if (ModItemsB.WARP_PEDESTAL != null) entries.add(ModItemsB.WARP_PEDESTAL);
        if (ModItemsB.VOID_ORE != null) entries.add(ModItemsB.VOID_ORE);
        if (ModItemsB.VOID_STONE != null) entries.add(ModItemsB.VOID_STONE);
        if (ModItemsB.CRYSTAL_ORE != null) entries.add(ModItemsB.CRYSTAL_ORE);
    }
    
    // Shared registration helper for chunk classes
    static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ShatteredRealmsRevival.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }
}