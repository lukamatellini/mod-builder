package com.modgen.stormweaver;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item STORM_CASTER_WAND = registerItem("storm_caster_wand", new Item(new Item.Settings().maxCount(1).maxDamage(128).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StormWeaver.MOD_ID, name), item);
    }

    public static void registerItems() {
        StormWeaver.LOGGER.info("Registering items for " + StormWeaver.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return STORM_CASTER_WAND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(STORM_CASTER_WAND);
    }
}