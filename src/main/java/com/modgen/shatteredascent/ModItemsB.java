package com.modgen.shatteredascent;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.util.Rarity;

import com.modgen.shatteredascent.item.WarpStoneItem;
import com.modgen.shatteredascent.item.TheShatteredRealmPortalIgniterItem;

/**
 * ModItemsB - Item registration chunk 2 of 2
 * Contains 2 items
 */
public class ModItemsB {
    // Item declarations
    public static Item WARP_STONE;
    public static Item THE_SHATTERED_REALM_PORTAL_IGNITER;

    public static void registerItems() {
        WARP_STONE = ModItems.registerItem("warp_stone", WarpStoneItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        THE_SHATTERED_REALM_PORTAL_IGNITER = ModItems.registerItem("the_shattered_realm_portal_igniter", TheShatteredRealmPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
}