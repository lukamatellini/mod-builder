package com.modgen.bananablaster;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item BANANA_WAND = registerItem("banana_wand", new Item(new Item.Settings().maxCount(1).maxDamage(150).rarity(Rarity.UNCOMMON)));
    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BananaBlaster.MOD_ID, name), item);
    }

    public static void registerItems() {
        BananaBlaster.LOGGER.info("Registering items for " + BananaBlaster.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return BANANA_WAND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(BANANA_WAND);
        entries.add(BANANA);
    }
}