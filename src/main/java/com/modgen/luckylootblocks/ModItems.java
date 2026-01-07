package com.modgen.luckylootblocks;

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
    public static Item LUCKY_BLOCK;
    public static Item CHANCE_WOLVES;
    public static Item CHANCE_COOKED_BEEF;
    public static Item BAKED_POTATOES;
    public static Item CHANCE_REGENERATION_II_10S;
    public static Item CHANCE_DIRT;
    public static Item CHANCE_FEATHERS;
    public static Item CHANCE_FLINT;
    public static Item CHANCE_RANDOM_DYE;
    public static Item CHANCE_ZOMBIES;
    public static Item CHANCE_SKELETONS;
    public static Item CHANCE_1_CREEPER;
    public static Item CHANCE_EXPLOSION;
    public static Item CHANCE_POISON_I_5S;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyLootBlocks.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyLootBlocks.LOGGER.info("Registering items for " + LuckyLootBlocks.MOD_ID);
        LUCKY_BLOCK = registerItem("lucky_block", Item::new, new Item.Settings().rarity(Rarity.RARE));
        CHANCE_WOLVES = registerItem("chance_wolves", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_COOKED_BEEF = registerItem("chance_cooked_beef", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        BAKED_POTATOES = registerItem("baked_potatoes", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_REGENERATION_II_10S = registerItem("chance_regeneration_ii_10s", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_DIRT = registerItem("chance_dirt", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_FEATHERS = registerItem("chance_feathers", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_FLINT = registerItem("chance_flint", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_RANDOM_DYE = registerItem("chance_random_dye", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_ZOMBIES = registerItem("chance_zombies", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_SKELETONS = registerItem("chance_skeletons", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_1_CREEPER = registerItem("chance_1_creeper", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_EXPLOSION = registerItem("chance_explosion", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CHANCE_POISON_I_5S = registerItem("chance_poison_i_5s", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK != null ? LUCKY_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK);
        if (CHANCE_WOLVES != null) entries.add(CHANCE_WOLVES);
        if (CHANCE_COOKED_BEEF != null) entries.add(CHANCE_COOKED_BEEF);
        if (BAKED_POTATOES != null) entries.add(BAKED_POTATOES);
        if (CHANCE_REGENERATION_II_10S != null) entries.add(CHANCE_REGENERATION_II_10S);
        if (CHANCE_DIRT != null) entries.add(CHANCE_DIRT);
        if (CHANCE_FEATHERS != null) entries.add(CHANCE_FEATHERS);
        if (CHANCE_FLINT != null) entries.add(CHANCE_FLINT);
        if (CHANCE_RANDOM_DYE != null) entries.add(CHANCE_RANDOM_DYE);
        if (CHANCE_ZOMBIES != null) entries.add(CHANCE_ZOMBIES);
        if (CHANCE_SKELETONS != null) entries.add(CHANCE_SKELETONS);
        if (CHANCE_1_CREEPER != null) entries.add(CHANCE_1_CREEPER);
        if (CHANCE_EXPLOSION != null) entries.add(CHANCE_EXPLOSION);
        if (CHANCE_POISON_I_5S != null) entries.add(CHANCE_POISON_I_5S);
    }
}