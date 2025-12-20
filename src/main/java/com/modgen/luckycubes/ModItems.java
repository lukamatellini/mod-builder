package com.modgen.luckycubes;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item LUCKY_BLOCK = registerItem("lucky_block", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(LuckyCubes.MOD_ID, name), item);
    }

    public static void registerItems() {
        LuckyCubes.LOGGER.info("Registering items for " + LuckyCubes.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(LUCKY_BLOCK);
    }
}