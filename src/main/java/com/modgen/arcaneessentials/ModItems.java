package com.modgen.arcaneessentials;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item LIGHTNING_WAND = registerItem("lightning_wand", new Item(new Item.Settings().maxCount(1).maxDamage(256).rarity(Rarity.EPIC)));
    public static final Item ENDURANCE_AMULET = registerItem("endurance_amulet", new Item(new Item.Settings().maxDamage(128).rarity(Rarity.RARE)));
    public static final Item LURKER_HIDE = registerItem("lurker_hide", new Item(new Item.Settings().maxDamage(500)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ArcaneEssentials.MOD_ID, name), item);
    }

    public static void registerItems() {
        ArcaneEssentials.LOGGER.info("Registering items for " + ArcaneEssentials.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return LIGHTNING_WAND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(LIGHTNING_WAND);
        entries.add(ENDURANCE_AMULET);
        entries.add(LURKER_HIDE);
    }
}