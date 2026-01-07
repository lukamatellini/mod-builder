package com.modgen.fortunefollies;

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
    public static Item LUCKY_BLOCK_ITEM;
    public static Item ZOMBIE;
    public static Item CREEPER;
    public static Item EXPLOSION_SMALL;
    public static Item REGENERATION;
    public static Item POISON;
    public static Item EXPERIENCE_ORB;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(FortuneFollies.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        FortuneFollies.LOGGER.info("Registering items for " + FortuneFollies.MOD_ID);
        LUCKY_BLOCK_ITEM = registerItem("lucky_block_item", Item::new);
        ZOMBIE = registerItem("zombie", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CREEPER = registerItem("creeper", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        EXPLOSION_SMALL = registerItem("explosion_small", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        REGENERATION = registerItem("regeneration", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        POISON = registerItem("poison", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        EXPERIENCE_ORB = registerItem("experience_orb", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK_ITEM != null ? LUCKY_BLOCK_ITEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK_ITEM != null) entries.add(LUCKY_BLOCK_ITEM);
        if (ZOMBIE != null) entries.add(ZOMBIE);
        if (CREEPER != null) entries.add(CREEPER);
        if (EXPLOSION_SMALL != null) entries.add(EXPLOSION_SMALL);
        if (REGENERATION != null) entries.add(REGENERATION);
        if (POISON != null) entries.add(POISON);
        if (EXPERIENCE_ORB != null) entries.add(EXPERIENCE_ORB);
    }
}