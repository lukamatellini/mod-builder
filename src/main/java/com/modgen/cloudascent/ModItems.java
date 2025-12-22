package com.modgen.cloudascent;

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
    public static Item CLOUD_BLOCK_FIRM;
    public static Item CLOUD_BLOCK_SOFT;
    public static Item CLOUD_BLOCK_STORM;

    /**
     * Minecraft 1.21.x Item Registration Pattern
     * CRITICAL: Item.Settings.registryKey() MUST be called BEFORE Item construction
     * This factory pattern ensures the registry key is set on settings before the item is created
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(CloudAscent.MOD_ID, name));
        Item item = factory.apply(settings.registryKey(itemKey));
        return Registry.register(Registries.ITEM, itemKey, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        CloudAscent.LOGGER.info("Registering items for " + CloudAscent.MOD_ID);
        CLOUD_BLOCK_FIRM = registerItem("cloud_block_firm", Item::new, new Item.Settings().maxDamage(500));
        CLOUD_BLOCK_SOFT = registerItem("cloud_block_soft", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        CLOUD_BLOCK_STORM = registerItem("cloud_block_storm", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return CLOUD_BLOCK_FIRM != null ? CLOUD_BLOCK_FIRM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CLOUD_BLOCK_FIRM != null) entries.add(CLOUD_BLOCK_FIRM);
        if (CLOUD_BLOCK_SOFT != null) entries.add(CLOUD_BLOCK_SOFT);
        if (CLOUD_BLOCK_STORM != null) entries.add(CLOUD_BLOCK_STORM);
    }
}