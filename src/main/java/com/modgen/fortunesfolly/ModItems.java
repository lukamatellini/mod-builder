package com.modgen.fortunesfolly;

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
    public static Item LUCKY_BLOCK;
    public static Item MINECRAFTFEATHER;
    public static Item MINECRAFTEGG;
    public static Item MINECRAFTPORKCHOP;
    public static Item MINECRAFTSADDLE;
    public static Item DIRT;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(FortunesFolly.MOD_ID, name);
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
        FortunesFolly.LOGGER.info("Registering items for " + FortunesFolly.MOD_ID);
        LUCKY_BLOCK = registerItem("lucky_block", Item::new, new Item.Settings().maxDamage(500));
        MINECRAFTFEATHER = registerItem("minecraftfeather", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTEGG = registerItem("minecraftegg", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTPORKCHOP = registerItem("minecraftporkchop", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTSADDLE = registerItem("minecraftsaddle", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        DIRT = registerItem("dirt", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK != null ? LUCKY_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK);
        if (MINECRAFTFEATHER != null) entries.add(MINECRAFTFEATHER);
        if (MINECRAFTEGG != null) entries.add(MINECRAFTEGG);
        if (MINECRAFTPORKCHOP != null) entries.add(MINECRAFTPORKCHOP);
        if (MINECRAFTSADDLE != null) entries.add(MINECRAFTSADDLE);
        if (DIRT != null) entries.add(DIRT);
    }
}