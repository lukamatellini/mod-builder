package com.modgen.luckyblock;


import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item RANDOMLY_DROPS_ITEMS;
    public static Item SPAWNS_MOBS;
    public static Item GRANTS_EFFECTS;
    public static Item OR_TRIGGERS_EVENTS_BASED_ON_DEFINED_GOOD;
    public static Item NEUTRAL;
    public static Item AND_BAD_OUTCOMES;
    public static Item EMBER_CORE;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyBlock.MOD_ID, name);
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
        LuckyBlock.LOGGER.info("Registering items for " + LuckyBlock.MOD_ID);
        RANDOMLY_DROPS_ITEMS = registerItem("randomly_drops_items", Item::new, new Item.Settings().rarity(Rarity.RARE));
        SPAWNS_MOBS = registerItem("spawns_mobs", Item::new, new Item.Settings().rarity(Rarity.RARE));
        GRANTS_EFFECTS = registerItem("grants_effects", Item::new, new Item.Settings().rarity(Rarity.RARE));
        OR_TRIGGERS_EVENTS_BASED_ON_DEFINED_GOOD = registerItem("or_triggers_events_based_on_defined_good", Item::new, new Item.Settings().rarity(Rarity.RARE));
        NEUTRAL = registerItem("neutral", Item::new, new Item.Settings().rarity(Rarity.RARE));
        AND_BAD_OUTCOMES = registerItem("and_bad_outcomes", Item::new, new Item.Settings().rarity(Rarity.RARE));
        EMBER_CORE = registerItem("ember_core", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return RANDOMLY_DROPS_ITEMS != null ? RANDOMLY_DROPS_ITEMS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (RANDOMLY_DROPS_ITEMS != null) entries.add(RANDOMLY_DROPS_ITEMS);
        if (SPAWNS_MOBS != null) entries.add(SPAWNS_MOBS);
        if (GRANTS_EFFECTS != null) entries.add(GRANTS_EFFECTS);
        if (OR_TRIGGERS_EVENTS_BASED_ON_DEFINED_GOOD != null) entries.add(OR_TRIGGERS_EVENTS_BASED_ON_DEFINED_GOOD);
        if (NEUTRAL != null) entries.add(NEUTRAL);
        if (AND_BAD_OUTCOMES != null) entries.add(AND_BAD_OUTCOMES);
        if (EMBER_CORE != null) entries.add(EMBER_CORE);
    }
}