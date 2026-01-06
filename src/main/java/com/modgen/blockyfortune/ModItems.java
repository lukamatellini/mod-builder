package com.modgen.blockyfortune;


import net.minecraft.item.Item;
import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.item.Items;


public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item LUCKY_BLOCK;
    public static Item COOKED_BEEF_;
    public static Item PLAYER_HASTE_EFFECT_30S;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(BlockyFortune.MOD_ID, name);
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
        BlockyFortune.LOGGER.info("Registering items for " + BlockyFortune.MOD_ID);
        LUCKY_BLOCK = registerItem("lucky_block", Item::new, new Item.Settings().maxDamage(500));
        COOKED_BEEF_ = registerItem("cooked_beef_", Item::new, new Item.Settings().rarity(Rarity.RARE));
        PLAYER_HASTE_EFFECT_30S = registerItem("player_haste_effect_30s", Item::new, new Item.Settings().rarity(Rarity.RARE));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK != null ? LUCKY_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK);
        if (COOKED_BEEF_ != null) entries.add(COOKED_BEEF_);
        if (PLAYER_HASTE_EFFECT_30S != null) entries.add(PLAYER_HASTE_EFFECT_30S);
    }
}