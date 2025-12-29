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
    public static Item ROTTEN_FLESH;
    public static Item CARROT;
    public static Item POTATO;
    public static Item RANDOMLY_DROPS_ITEMS_FROM_A_DEFINED_LOOT_POOL_OR_SPAWNS_A_HOSTILE_ZOMBIE;
    public static Item REFINED_INGOT;

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
        ROTTEN_FLESH = registerItem("rotten_flesh", Item::new, new Item.Settings().rarity(Rarity.RARE));
        CARROT = registerItem("carrot", Item::new, new Item.Settings().rarity(Rarity.RARE));
        POTATO = registerItem("potato", Item::new, new Item.Settings().rarity(Rarity.RARE));
        RANDOMLY_DROPS_ITEMS_FROM_A_DEFINED_LOOT_POOL_OR_SPAWNS_A_HOSTILE_ZOMBIE = registerItem("randomly_drops_items_from_a_defined_loot_pool_or_spawns_a_hostile_zombie", Item::new, new Item.Settings().rarity(Rarity.RARE));
        REFINED_INGOT = registerItem("refined_ingot", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return ROTTEN_FLESH != null ? ROTTEN_FLESH : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ROTTEN_FLESH != null) entries.add(ROTTEN_FLESH);
        if (CARROT != null) entries.add(CARROT);
        if (POTATO != null) entries.add(POTATO);
        if (RANDOMLY_DROPS_ITEMS_FROM_A_DEFINED_LOOT_POOL_OR_SPAWNS_A_HOSTILE_ZOMBIE != null) entries.add(RANDOMLY_DROPS_ITEMS_FROM_A_DEFINED_LOOT_POOL_OR_SPAWNS_A_HOSTILE_ZOMBIE);
        if (REFINED_INGOT != null) entries.add(REFINED_INGOT);
    }
}