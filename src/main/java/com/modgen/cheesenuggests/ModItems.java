package com.modgen.cheesenuggests;

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
    public static Item CHEESE_NUGGET;
    public static Item CHEESE_SWORD;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(CheeseNuggests.MOD_ID, name);
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
        CheeseNuggests.LOGGER.info("Registering items for " + CheeseNuggests.MOD_ID);
        CHEESE_NUGGET = registerItem("cheese_nugget", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESE_SWORD = registerItem("cheese_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(131).rarity(Rarity.UNCOMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
    }
    
    public static Item getFirstItem() {
        return CHEESE_NUGGET != null ? CHEESE_NUGGET : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_NUGGET != null) entries.add(CHEESE_NUGGET);
        if (CHEESE_SWORD != null) entries.add(CHEESE_SWORD);
    }
}