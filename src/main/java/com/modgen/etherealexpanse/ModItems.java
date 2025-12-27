package com.modgen.etherealexpanse;

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

import com.modgen.etherealexpanse.item.VoidExpansePortalIgniterItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item ETHEREAL_CRYSTAL;
    public static Item VOID_COMPASS;
    public static Item ANCHOR_BOOTS;
    public static Item VOID_EXPANSE_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(EtherealExpanse.MOD_ID, name);
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
        EtherealExpanse.LOGGER.info("Registering items for " + EtherealExpanse.MOD_ID);
        ETHEREAL_CRYSTAL = registerItem("ethereal_crystal", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_COMPASS = registerItem("void_compass", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ANCHOR_BOOTS = registerItem("anchor_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.UNCOMMON));
        VOID_EXPANSE_PORTAL_IGNITER = registerItem("void_expanse_portal_igniter", VoidExpansePortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return ETHEREAL_CRYSTAL != null ? ETHEREAL_CRYSTAL : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (ETHEREAL_CRYSTAL != null) entries.add(ETHEREAL_CRYSTAL);
        if (VOID_COMPASS != null) entries.add(VOID_COMPASS);
        if (ANCHOR_BOOTS != null) entries.add(ANCHOR_BOOTS);
        if (VOID_EXPANSE_PORTAL_IGNITER != null) entries.add(VOID_EXPANSE_PORTAL_IGNITER);
    }
}