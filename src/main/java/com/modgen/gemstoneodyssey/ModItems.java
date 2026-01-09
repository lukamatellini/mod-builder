package com.modgen.gemstoneodyssey;

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
    public static Item RUBY_INGOT;
    public static Item SAPPHIRE_SHARD;
    public static Item DRAGON_SCALE;
    public static Item MAGIC_PIZZA;
    public static Item FROST_BERRY;
    public static Item PHOENIX_FEATHER_CAKE;
    public static Item RUBY_HELMET;
    public static Item RUBY_CHESTPLATE;
    public static Item RUBY_LEGGINGS;
    public static Item RUBY_BOOTS;
    public static Item DRAGON_SLAYER_SWORD;
    public static Item THUNDER_STAFF;
    public static Item VOID_PICKAXE;
    public static Item RUBY_PICKAXE;
    public static Item RUBY_AXE;
    public static Item RUBY_SHOVEL;
    public static Item RUBY_HOE;
    public static Item RUBY_SWORD;
    public static Item VOID_GEM;
    public static Item SKY_CRYSTAL;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(GemstoneOdyssey.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        GemstoneOdyssey.LOGGER.info("Registering items for " + GemstoneOdyssey.MOD_ID);
        RUBY_INGOT = registerItem("ruby_ingot", Item::new);
        SAPPHIRE_SHARD = registerItem("sapphire_shard", Item::new);
        DRAGON_SCALE = registerItem("dragon_scale", Item::new);
        MAGIC_PIZZA = registerItem("magic_pizza", Item::new, new Item.Settings().maxCount(16));
        FROST_BERRY = registerItem("frost_berry", Item::new);
        PHOENIX_FEATHER_CAKE = registerItem("phoenix_feather_cake", Item::new, new Item.Settings().maxCount(1));
        RUBY_HELMET = registerItem("ruby_helmet", Item::new, new Item.Settings().maxCount(1));
        RUBY_CHESTPLATE = registerItem("ruby_chestplate", Item::new, new Item.Settings().maxCount(1));
        RUBY_LEGGINGS = registerItem("ruby_leggings", Item::new, new Item.Settings().maxCount(1));
        RUBY_BOOTS = registerItem("ruby_boots", Item::new, new Item.Settings().maxCount(1));
        DRAGON_SLAYER_SWORD = registerItem("dragon_slayer_sword", Item::new, new Item.Settings().maxCount(1));
        THUNDER_STAFF = registerItem("thunder_staff", Item::new, new Item.Settings().maxCount(1));
        VOID_PICKAXE = registerItem("void_pickaxe", Item::new, new Item.Settings().maxCount(1));
        RUBY_PICKAXE = registerItem("ruby_pickaxe", Item::new, new Item.Settings().maxCount(1));
        RUBY_AXE = registerItem("ruby_axe", Item::new, new Item.Settings().maxCount(1));
        RUBY_SHOVEL = registerItem("ruby_shovel", Item::new, new Item.Settings().maxCount(1));
        RUBY_HOE = registerItem("ruby_hoe", Item::new, new Item.Settings().maxCount(1));
        RUBY_SWORD = registerItem("ruby_sword", Item::new, new Item.Settings().maxCount(1));
        VOID_GEM = registerItem("void_gem", Item::new);
        SKY_CRYSTAL = registerItem("sky_crystal", Item::new);
    }
    
    public static Item getFirstItem() {
        return RUBY_INGOT != null ? RUBY_INGOT : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RUBY_INGOT != null) entries.add(RUBY_INGOT);
        if (SAPPHIRE_SHARD != null) entries.add(SAPPHIRE_SHARD);
        if (DRAGON_SCALE != null) entries.add(DRAGON_SCALE);
        if (MAGIC_PIZZA != null) entries.add(MAGIC_PIZZA);
        if (FROST_BERRY != null) entries.add(FROST_BERRY);
        if (PHOENIX_FEATHER_CAKE != null) entries.add(PHOENIX_FEATHER_CAKE);
        if (RUBY_HELMET != null) entries.add(RUBY_HELMET);
        if (RUBY_CHESTPLATE != null) entries.add(RUBY_CHESTPLATE);
        if (RUBY_LEGGINGS != null) entries.add(RUBY_LEGGINGS);
        if (RUBY_BOOTS != null) entries.add(RUBY_BOOTS);
        if (DRAGON_SLAYER_SWORD != null) entries.add(DRAGON_SLAYER_SWORD);
        if (THUNDER_STAFF != null) entries.add(THUNDER_STAFF);
        if (VOID_PICKAXE != null) entries.add(VOID_PICKAXE);
        if (RUBY_PICKAXE != null) entries.add(RUBY_PICKAXE);
        if (RUBY_AXE != null) entries.add(RUBY_AXE);
        if (RUBY_SHOVEL != null) entries.add(RUBY_SHOVEL);
        if (RUBY_HOE != null) entries.add(RUBY_HOE);
        if (RUBY_SWORD != null) entries.add(RUBY_SWORD);
        if (VOID_GEM != null) entries.add(VOID_GEM);
        if (SKY_CRYSTAL != null) entries.add(SKY_CRYSTAL);
    }
}