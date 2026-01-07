package com.modgen.luckylootblocks;

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
    public static Item ZOMBIE_;
    public static Item SKELETON_;
    public static Item CREEPER_;
    public static Item SPIDER_;
    public static Item OAK_PLANKS_;
    public static Item COBBLESTONE_;
    public static Item COOKED_BEEF_;
    public static Item COOKED_CHICKEN_;
    public static Item BREAD_;
    public static Item REGENERATION_EFFECT;
    public static Item STRENGTH_EFFECT;
    public static Item POISON_EFFECT;
    public static Item SLOWNESS_EFFECT;
    public static Item EXPLOSION;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyLootBlocks.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyLootBlocks.LOGGER.info("Registering items for " + LuckyLootBlocks.MOD_ID);
        LUCKY_BLOCK_ITEM = registerItem("lucky_block_item", Item::new, new Item.Settings().rarity(Rarity.RARE));
        ZOMBIE_ = registerItem("zombie_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SKELETON_ = registerItem("skeleton_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CREEPER_ = registerItem("creeper_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SPIDER_ = registerItem("spider_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        OAK_PLANKS_ = registerItem("oak_planks_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        COBBLESTONE_ = registerItem("cobblestone_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        COOKED_BEEF_ = registerItem("cooked_beef_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        COOKED_CHICKEN_ = registerItem("cooked_chicken_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        BREAD_ = registerItem("bread_", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        REGENERATION_EFFECT = registerItem("regeneration_effect", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        STRENGTH_EFFECT = registerItem("strength_effect", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        POISON_EFFECT = registerItem("poison_effect", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SLOWNESS_EFFECT = registerItem("slowness_effect", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        EXPLOSION = registerItem("explosion", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK_ITEM != null ? LUCKY_BLOCK_ITEM : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK_ITEM != null) entries.add(LUCKY_BLOCK_ITEM);
        if (ZOMBIE_ != null) entries.add(ZOMBIE_);
        if (SKELETON_ != null) entries.add(SKELETON_);
        if (CREEPER_ != null) entries.add(CREEPER_);
        if (SPIDER_ != null) entries.add(SPIDER_);
        if (OAK_PLANKS_ != null) entries.add(OAK_PLANKS_);
        if (COBBLESTONE_ != null) entries.add(COBBLESTONE_);
        if (COOKED_BEEF_ != null) entries.add(COOKED_BEEF_);
        if (COOKED_CHICKEN_ != null) entries.add(COOKED_CHICKEN_);
        if (BREAD_ != null) entries.add(BREAD_);
        if (REGENERATION_EFFECT != null) entries.add(REGENERATION_EFFECT);
        if (STRENGTH_EFFECT != null) entries.add(STRENGTH_EFFECT);
        if (POISON_EFFECT != null) entries.add(POISON_EFFECT);
        if (SLOWNESS_EFFECT != null) entries.add(SLOWNESS_EFFECT);
        if (EXPLOSION != null) entries.add(EXPLOSION);
    }
}