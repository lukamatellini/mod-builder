package com.modgen.luckyblocks;


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
    public static Item NO_DIRECT_DROP;
    public static Item TRIGGERS_A_RANDOM_EVENT;
    public static Item VOID_ESSENCE;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyBlocks.MOD_ID, name);
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
        LuckyBlocks.LOGGER.info("Registering items for " + LuckyBlocks.MOD_ID);
        NO_DIRECT_DROP = registerItem("no_direct_drop", Item::new, new Item.Settings().rarity(Rarity.RARE));
        TRIGGERS_A_RANDOM_EVENT = registerItem("triggers_a_random_event", Item::new, new Item.Settings().rarity(Rarity.RARE));
        VOID_ESSENCE = registerItem("void_essence", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return NO_DIRECT_DROP != null ? NO_DIRECT_DROP : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (NO_DIRECT_DROP != null) entries.add(NO_DIRECT_DROP);
        if (TRIGGERS_A_RANDOM_EVENT != null) entries.add(TRIGGERS_A_RANDOM_EVENT);
        if (VOID_ESSENCE != null) entries.add(VOID_ESSENCE);
    }
}