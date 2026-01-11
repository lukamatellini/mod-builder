package com.modgen.navalarchitect;

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
    public static Item PILOT_SEAT;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(NavalArchitect.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        NavalArchitect.LOGGER.info("Registering items for " + NavalArchitect.MOD_ID);
        PILOT_SEAT = registerItem("pilot_seat", Item::new);
    }
    
    public static Item getFirstItem() {
        return PILOT_SEAT != null ? PILOT_SEAT : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (PILOT_SEAT != null) entries.add(PILOT_SEAT);
    }
}