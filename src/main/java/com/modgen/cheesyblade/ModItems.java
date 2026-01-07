package com.modgen.cheesyblade;

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
    public static Item CHEESE_CURDS;
    public static Item SMALL_CHEESE_BLOCK_ITEM;
    public static Item MEDIUM_CHEESE_WHEEL_ITEM;
    public static Item AGED_CHEESE_SLICE;
    public static Item CHEESEMONGERS_BLADE;
    public static Item NOTHING_IF_FULLY_CONSUMED;
    public static Item REMAINING_SLICES_AS_AGED_CHEESE_SLICES_IF_PARTIALLY_CONSUMED;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(CheesyBlade.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        CheesyBlade.LOGGER.info("Registering items for " + CheesyBlade.MOD_ID);
        CHEESE_CURDS = registerItem("cheese_curds", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        SMALL_CHEESE_BLOCK_ITEM = registerItem("small_cheese_block_item", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        MEDIUM_CHEESE_WHEEL_ITEM = registerItem("medium_cheese_wheel_item", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        AGED_CHEESE_SLICE = registerItem("aged_cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESEMONGERS_BLADE = registerItem("cheesemongers_blade", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(750).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        NOTHING_IF_FULLY_CONSUMED = registerItem("nothing_if_fully_consumed", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        REMAINING_SLICES_AS_AGED_CHEESE_SLICES_IF_PARTIALLY_CONSUMED = registerItem("remaining_slices_as_aged_cheese_slices_if_partially_consumed", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return CHEESE_CURDS != null ? CHEESE_CURDS : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_CURDS != null) entries.add(CHEESE_CURDS);
        if (SMALL_CHEESE_BLOCK_ITEM != null) entries.add(SMALL_CHEESE_BLOCK_ITEM);
        if (MEDIUM_CHEESE_WHEEL_ITEM != null) entries.add(MEDIUM_CHEESE_WHEEL_ITEM);
        if (AGED_CHEESE_SLICE != null) entries.add(AGED_CHEESE_SLICE);
        if (CHEESEMONGERS_BLADE != null) entries.add(CHEESEMONGERS_BLADE);
        if (NOTHING_IF_FULLY_CONSUMED != null) entries.add(NOTHING_IF_FULLY_CONSUMED);
        if (REMAINING_SLICES_AS_AGED_CHEESE_SLICES_IF_PARTIALLY_CONSUMED != null) entries.add(REMAINING_SLICES_AS_AGED_CHEESE_SLICES_IF_PARTIALLY_CONSUMED);
    }
}