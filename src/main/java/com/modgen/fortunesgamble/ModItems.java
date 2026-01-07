package com.modgen.fortunesgamble;

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
    public static Item ENCHANTED_IRON_TOOL;
    public static Item ENCHANTED_DIAMOND_TOOL;
    public static Item ENCHANTED_NETHERITE_TOOL;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(FortunesGamble.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        FortunesGamble.LOGGER.info("Registering items for " + FortunesGamble.MOD_ID);
        ENCHANTED_IRON_TOOL = registerItem("enchanted_iron_tool", Item::new, new Item.Settings().rarity(Rarity.RARE));
        ENCHANTED_DIAMOND_TOOL = registerItem("enchanted_diamond_tool", Item::new, new Item.Settings().rarity(Rarity.EPIC));
        ENCHANTED_NETHERITE_TOOL = registerItem("enchanted_netherite_tool", Item::new, new Item.Settings().rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return ENCHANTED_IRON_TOOL != null ? ENCHANTED_IRON_TOOL : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ENCHANTED_IRON_TOOL != null) entries.add(ENCHANTED_IRON_TOOL);
        if (ENCHANTED_DIAMOND_TOOL != null) entries.add(ENCHANTED_DIAMOND_TOOL);
        if (ENCHANTED_NETHERITE_TOOL != null) entries.add(ENCHANTED_NETHERITE_TOOL);
    }
}