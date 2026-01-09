package com.modgen.twilightgemcraft;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item AETHERIUM_GEM;
    public static Item AETHERIUM_DUST;
    public static Item AETHERIUM_INGOT;
    public static Item AETHERIUM_HELMET;
    public static Item AETHERIUM_CHESTPLATE;
    public static Item AETHERIUM_LEGGINGS;
    public static Item AETHERIUM_BOOTS;
    public static Item AETHERIUM_SHARD;
    public static Item NIGHT_VISION_POTION;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(TwilightGemcraft.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        TwilightGemcraft.LOGGER.info("Registering items for " + TwilightGemcraft.MOD_ID);
        AETHERIUM_GEM = registerItem("aetherium_gem", Item::new);
        AETHERIUM_DUST = registerItem("aetherium_dust", Item::new);
        AETHERIUM_INGOT = registerItem("aetherium_ingot", Item::new);
        AETHERIUM_HELMET = registerItem("aetherium_helmet", Item::new, new Item.Settings().maxCount(1));
        AETHERIUM_CHESTPLATE = registerItem("aetherium_chestplate", Item::new, new Item.Settings().maxCount(1));
        AETHERIUM_LEGGINGS = registerItem("aetherium_leggings", Item::new, new Item.Settings().maxCount(1));
        AETHERIUM_BOOTS = registerItem("aetherium_boots", Item::new, new Item.Settings().maxCount(1));
        AETHERIUM_SHARD = registerItem("aetherium_shard", Item::new);
        NIGHT_VISION_POTION = registerItem("night_vision_potion", Item::new, new Item.Settings().maxCount(16));
    }
    
    public static Item getFirstItem() {
        return AETHERIUM_GEM != null ? AETHERIUM_GEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (AETHERIUM_GEM != null) entries.add(AETHERIUM_GEM);
        if (AETHERIUM_DUST != null) entries.add(AETHERIUM_DUST);
        if (AETHERIUM_INGOT != null) entries.add(AETHERIUM_INGOT);
        if (AETHERIUM_HELMET != null) entries.add(AETHERIUM_HELMET);
        if (AETHERIUM_CHESTPLATE != null) entries.add(AETHERIUM_CHESTPLATE);
        if (AETHERIUM_LEGGINGS != null) entries.add(AETHERIUM_LEGGINGS);
        if (AETHERIUM_BOOTS != null) entries.add(AETHERIUM_BOOTS);
        if (AETHERIUM_SHARD != null) entries.add(AETHERIUM_SHARD);
        if (NIGHT_VISION_POTION != null) entries.add(NIGHT_VISION_POTION);
    }
}