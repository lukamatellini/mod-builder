package com.modgen.enhancedlava;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.enhancedlava.item.VolcanicPickaxeItem;
import net.minecraft.item.Items;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item RAW_LAVA_SHARD;
    public static Item LAVA_CRYSTAL;
    public static Item IGNITED_LAVA_SHARD;
    public static Item VOLCANIC_PICKAXE;
    public static Item VOLCANIC_SWORD;
    public static Item LAVA_INFUSED_APPLE;
    public static Item CRYSTAL_SHARD;
    public static Item HARDENED_LAVA_BLOCK;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(EnhancedLava.MOD_ID, name);
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
        EnhancedLava.LOGGER.info("Registering items for " + EnhancedLava.MOD_ID);
        RAW_LAVA_SHARD = registerItem("raw_lava_shard", Item::new, new Item.Settings().maxDamage(500));
        LAVA_CRYSTAL = registerItem("lava_crystal", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        IGNITED_LAVA_SHARD = registerItem("ignited_lava_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOLCANIC_PICKAXE = registerItem("volcanic_pickaxe", VolcanicPickaxeItem::new, new Item.Settings().maxCount(1).maxDamage(2000).rarity(Rarity.UNCOMMON));
        VOLCANIC_SWORD = registerItem("volcanic_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.UNCOMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        LAVA_INFUSED_APPLE = registerItem("lava_infused_apple", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CRYSTAL_SHARD = registerItem("crystal_shard", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        HARDENED_LAVA_BLOCK = registerItem("hardened_lava_block", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return RAW_LAVA_SHARD != null ? RAW_LAVA_SHARD : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RAW_LAVA_SHARD != null) entries.add(RAW_LAVA_SHARD);
        if (LAVA_CRYSTAL != null) entries.add(LAVA_CRYSTAL);
        if (IGNITED_LAVA_SHARD != null) entries.add(IGNITED_LAVA_SHARD);
        if (VOLCANIC_PICKAXE != null) entries.add(VOLCANIC_PICKAXE);
        if (VOLCANIC_SWORD != null) entries.add(VOLCANIC_SWORD);
        if (LAVA_INFUSED_APPLE != null) entries.add(LAVA_INFUSED_APPLE);
        if (CRYSTAL_SHARD != null) entries.add(CRYSTAL_SHARD);
        if (HARDENED_LAVA_BLOCK != null) entries.add(HARDENED_LAVA_BLOCK);
    }
}