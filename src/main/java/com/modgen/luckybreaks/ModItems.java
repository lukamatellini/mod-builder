package com.modgen.luckybreaks;

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
    public static Item LUCKY_BLOCK;
    public static Item MINECRAFTROTTEN_FLESH;
    public static Item MINECRAFTBOWENCHANTMENTSIDMINECRAFTPOWER;
    public static Item LVL1;
    public static Item MINECRAFTSTRING;
    public static Item MINECRAFTBONE;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyBreaks.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyBreaks.LOGGER.info("Registering items for " + LuckyBreaks.MOD_ID);
        LUCKY_BLOCK = registerItem("lucky_block", Item::new);
        MINECRAFTROTTEN_FLESH = registerItem("minecraftrotten_flesh", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTBOWENCHANTMENTSIDMINECRAFTPOWER = registerItem("minecraftbowenchantmentsidminecraftpower", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        LVL1 = registerItem("lvl1", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTSTRING = registerItem("minecraftstring", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTBONE = registerItem("minecraftbone", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK != null ? LUCKY_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK);
        if (MINECRAFTROTTEN_FLESH != null) entries.add(MINECRAFTROTTEN_FLESH);
        if (MINECRAFTBOWENCHANTMENTSIDMINECRAFTPOWER != null) entries.add(MINECRAFTBOWENCHANTMENTSIDMINECRAFTPOWER);
        if (LVL1 != null) entries.add(LVL1);
        if (MINECRAFTSTRING != null) entries.add(MINECRAFTSTRING);
        if (MINECRAFTBONE != null) entries.add(MINECRAFTBONE);
    }
}