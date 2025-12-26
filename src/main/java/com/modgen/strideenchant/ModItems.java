package com.modgen.strideenchant;

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
    public static Item SWIFT_FEATHER;
    public static Item SWIFT_GEM;
    public static Item SWIFTSTRIDE_BOOTS;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(StrideEnchant.MOD_ID, name);
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
        StrideEnchant.LOGGER.info("Registering items for " + StrideEnchant.MOD_ID);
        SWIFT_FEATHER = registerItem("swift_feather", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        SWIFT_GEM = registerItem("swift_gem", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        SWIFTSTRIDE_BOOTS = registerItem("swiftstride_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return SWIFT_FEATHER != null ? SWIFT_FEATHER : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SWIFT_FEATHER != null) entries.add(SWIFT_FEATHER);
        if (SWIFT_GEM != null) entries.add(SWIFT_GEM);
        if (SWIFTSTRIDE_BOOTS != null) entries.add(SWIFTSTRIDE_BOOTS);
    }
}