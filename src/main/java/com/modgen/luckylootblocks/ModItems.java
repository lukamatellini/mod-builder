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
    public static Item LUCKY_BLOCK_ITEM;
    public static Item GOOD_DROPS;
    public static Item RANDOM_EVENTS;

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
        LUCKY_BLOCK_ITEM = registerItem("lucky_block_item", Item::new, new Item.Settings().rarity(Rarity.RARE));
        GOOD_DROPS = registerItem("good_drops", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        RANDOM_EVENTS = registerItem("random_events", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK_ITEM != null ? LUCKY_BLOCK_ITEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK_ITEM != null) entries.add(LUCKY_BLOCK_ITEM);
        if (GOOD_DROPS != null) entries.add(GOOD_DROPS);
        if (RANDOM_EVENTS != null) entries.add(RANDOM_EVENTS);
    }
}