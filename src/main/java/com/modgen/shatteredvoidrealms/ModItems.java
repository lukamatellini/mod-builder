package com.modgen.shatteredvoidrealms;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.shatteredvoidrealms.item.AbyssalAltarItem;
import com.modgen.shatteredvoidrealms.item.WarpPedestalItem;
import com.modgen.shatteredvoidrealms.item.ShatteredRealmPortalIgniterItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item VOID_STONE;
    public static Item CRYSTAL_ORE;
    public static Item ABYSSAL_ALTAR;
    public static Item WARP_PEDESTAL;
    public static Item SHATTERED_REALM_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ShatteredVoidRealms.MOD_ID, name);
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
        ShatteredVoidRealms.LOGGER.info("Registering items for " + ShatteredVoidRealms.MOD_ID);
        VOID_STONE = registerItem("void_stone", Item::new, new Item.Settings().maxDamage(500));
        CRYSTAL_ORE = registerItem("crystal_ore", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ABYSSAL_ALTAR = registerItem("abyssal_altar", AbyssalAltarItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        WARP_PEDESTAL = registerItem("warp_pedestal", WarpPedestalItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        SHATTERED_REALM_PORTAL_IGNITER = registerItem("shattered_realm_portal_igniter", ShatteredRealmPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return VOID_STONE != null ? VOID_STONE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_STONE != null) entries.add(VOID_STONE);
        if (CRYSTAL_ORE != null) entries.add(CRYSTAL_ORE);
        if (ABYSSAL_ALTAR != null) entries.add(ABYSSAL_ALTAR);
        if (WARP_PEDESTAL != null) entries.add(WARP_PEDESTAL);
        if (SHATTERED_REALM_PORTAL_IGNITER != null) entries.add(SHATTERED_REALM_PORTAL_IGNITER);
    }
}