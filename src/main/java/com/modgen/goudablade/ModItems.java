package com.modgen.goudablade;

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
    public static Item CHEESE_SLICE;
    public static Item CHEESE_SWORD;
    public static Item PUNGENT_MILK_POD;
    public static Item CHEESE_SEED;
    public static Item _4X_CHEESE_SLICE;
    public static Item MINECRAFTCOBBLESTONE;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(GoudaBlade.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        GoudaBlade.LOGGER.info("Registering items for " + GoudaBlade.MOD_ID);
        CHEESE_SLICE = registerItem("cheese_slice", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        CHEESE_SWORD = registerItem("cheese_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(250).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        PUNGENT_MILK_POD = registerItem("pungent_milk_pod", Item::new);
        CHEESE_SEED = registerItem("cheese_seed", Item::new);
        _4X_CHEESE_SLICE = registerItem("4x_cheese_slice", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTCOBBLESTONE = registerItem("minecraftcobblestone", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return CHEESE_SLICE != null ? CHEESE_SLICE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (CHEESE_SLICE != null) entries.add(CHEESE_SLICE);
        if (CHEESE_SWORD != null) entries.add(CHEESE_SWORD);
        if (PUNGENT_MILK_POD != null) entries.add(PUNGENT_MILK_POD);
        if (CHEESE_SEED != null) entries.add(CHEESE_SEED);
        if (_4X_CHEESE_SLICE != null) entries.add(_4X_CHEESE_SLICE);
        if (MINECRAFTCOBBLESTONE != null) entries.add(MINECRAFTCOBBLESTONE);
    }
}