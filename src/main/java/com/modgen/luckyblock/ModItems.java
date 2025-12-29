package com.modgen.luckyblock;


import net.minecraft.item.Item;
import net.minecraft.item.Items;
import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item WORM_SCALE;
    public static Item WORM_SCALES;
    public static Item MINECRAFTSLIME_BALL;
    public static Item REFINED_INGOT;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyBlock.MOD_ID, name);
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
        LuckyBlock.LOGGER.info("Registering items for " + LuckyBlock.MOD_ID);
        WORM_SCALE = registerItem("worm_scale", Item::new, new Item.Settings().maxDamage(500));
        WORM_SCALES = registerItem("worm_scales", Item::new, new Item.Settings().rarity(Rarity.RARE));
        MINECRAFTSLIME_BALL = registerItem("minecraftslime_ball", Item::new, new Item.Settings().rarity(Rarity.RARE));
        REFINED_INGOT = registerItem("refined_ingot", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return WORM_SCALE != null ? WORM_SCALE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (WORM_SCALE != null) entries.add(WORM_SCALE);
        if (WORM_SCALES != null) entries.add(WORM_SCALES);
        if (MINECRAFTSLIME_BALL != null) entries.add(MINECRAFTSLIME_BALL);
        if (REFINED_INGOT != null) entries.add(REFINED_INGOT);
    }
}