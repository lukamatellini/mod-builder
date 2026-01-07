package com.modgen.luckylootboxes;

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
    public static Item LUCKY_CHARM;
    public static Item UNLUCKY_CHARM;
    public static Item FOUR_LEAF_CLOVER;
    public static Item COMMON_BONE;
    public static Item RARE_WITHER_SKELETON_SKULL;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyLootBoxes.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyLootBoxes.LOGGER.info("Registering items for " + LuckyLootBoxes.MOD_ID);
        LUCKY_CHARM = registerItem("lucky_charm", Item::new, new Item.Settings().rarity(Rarity.RARE));
        UNLUCKY_CHARM = registerItem("unlucky_charm", Item::new, new Item.Settings().rarity(Rarity.RARE));
        FOUR_LEAF_CLOVER = registerItem("four_leaf_clover", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        COMMON_BONE = registerItem("common_bone", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        RARE_WITHER_SKELETON_SKULL = registerItem("rare_wither_skeleton_skull", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_CHARM != null ? LUCKY_CHARM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_CHARM != null) entries.add(LUCKY_CHARM);
        if (UNLUCKY_CHARM != null) entries.add(UNLUCKY_CHARM);
        if (FOUR_LEAF_CLOVER != null) entries.add(FOUR_LEAF_CLOVER);
        if (COMMON_BONE != null) entries.add(COMMON_BONE);
        if (RARE_WITHER_SKELETON_SKULL != null) entries.add(RARE_WITHER_SKELETON_SKULL);
    }
}