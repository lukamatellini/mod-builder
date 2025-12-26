package com.modgen.magicwand;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.magicwand.item.LightningWandItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item LIGHTNING_WAND;
    public static Item LIGHTNING_GEM;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(MagicWand.MOD_ID, name);
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
        MagicWand.LOGGER.info("Registering items for " + MagicWand.MOD_ID);
        LIGHTNING_WAND = registerItem("lightning_wand", LightningWandItem::new, new Item.Settings().maxCount(1).maxDamage(100).rarity(Rarity.RARE));
        LIGHTNING_GEM = registerItem("lightning_gem", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LIGHTNING_WAND != null ? LIGHTNING_WAND : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LIGHTNING_WAND != null) entries.add(LIGHTNING_WAND);
        if (LIGHTNING_GEM != null) entries.add(LIGHTNING_GEM);
    }
}