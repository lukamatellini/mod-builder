package com.modgen.fortunefates;

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
    public static Item HASTEREGENERATION_EFFECT;
    public static Item SMALL_CHEST_WITH_VALUABLE_LOOT;
    public static Item COOKED_PORKCHOPS;
    public static Item SILVERFISH_SWARM;
    public static Item SMALL_EXPLOSION;
    public static Item SLOWNESSWEAKNESS_EFFECT;
    public static Item SET_PLAYER_ON_FIRE;
    public static Item POISONOUS_POTATOES;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(FortuneFates.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        FortuneFates.LOGGER.info("Registering items for " + FortuneFates.MOD_ID);
        LUCKY_BLOCK_ITEM = registerItem("lucky_block_item", Item::new, new Item.Settings().rarity(Rarity.RARE));
        HASTEREGENERATION_EFFECT = registerItem("hasteregeneration_effect", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SMALL_CHEST_WITH_VALUABLE_LOOT = registerItem("small_chest_with_valuable_loot", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        COOKED_PORKCHOPS = registerItem("cooked_porkchops", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SILVERFISH_SWARM = registerItem("silverfish_swarm", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SMALL_EXPLOSION = registerItem("small_explosion", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SLOWNESSWEAKNESS_EFFECT = registerItem("slownessweakness_effect", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SET_PLAYER_ON_FIRE = registerItem("set_player_on_fire", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        POISONOUS_POTATOES = registerItem("poisonous_potatoes", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK_ITEM != null ? LUCKY_BLOCK_ITEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK_ITEM != null) entries.add(LUCKY_BLOCK_ITEM);
        if (HASTEREGENERATION_EFFECT != null) entries.add(HASTEREGENERATION_EFFECT);
        if (SMALL_CHEST_WITH_VALUABLE_LOOT != null) entries.add(SMALL_CHEST_WITH_VALUABLE_LOOT);
        if (COOKED_PORKCHOPS != null) entries.add(COOKED_PORKCHOPS);
        if (SILVERFISH_SWARM != null) entries.add(SILVERFISH_SWARM);
        if (SMALL_EXPLOSION != null) entries.add(SMALL_EXPLOSION);
        if (SLOWNESSWEAKNESS_EFFECT != null) entries.add(SLOWNESSWEAKNESS_EFFECT);
        if (SET_PLAYER_ON_FIRE != null) entries.add(SET_PLAYER_ON_FIRE);
        if (POISONOUS_POTATOES != null) entries.add(POISONOUS_POTATOES);
    }
}