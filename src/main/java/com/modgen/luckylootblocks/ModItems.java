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
    public static Item STONE_PICKAXE;
    public static Item BREAD;
    public static Item COOKED_BEEF;
    public static Item APPLE;
    public static Item GOLDEN_APPLE;
    public static Item ENCHANTED_BOOK;
    public static Item IRON_CHESTPLATE;
    public static Item NETHERITE_SCRAP;
    public static Item ANCIENT_DEBRIS;
    public static Item DRAGON_BREATH;
    public static Item DIAMOND_SWORD_SHARPNESS_1;
    public static Item BOW_POWER_1;
    public static Item DIAMOND_CHESTPLATE_PROTECTION_2;
    public static Item EFFICIENCY_3_PICKAXE;
    public static Item LUCKY_BLOCK_ITEM;

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
        STONE_PICKAXE = registerItem("stone_pickaxe", PickaxeItem::new, new Item.Settings().maxDamage(131).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        BREAD = registerItem("bread", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        COOKED_BEEF = registerItem("cooked_beef", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        APPLE = registerItem("apple", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        GOLDEN_APPLE = registerItem("golden_apple", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        ENCHANTED_BOOK = registerItem("enchanted_book", Item::new, new Item.Settings().rarity(Rarity.RARE));
        IRON_CHESTPLATE = registerItem("iron_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(240).rarity(Rarity.RARE));
        NETHERITE_SCRAP = registerItem("netherite_scrap", Item::new);
        ANCIENT_DEBRIS = registerItem("ancient_debris", Item::new);
        DRAGON_BREATH = registerItem("dragon_breath", Item::new);
        DIAMOND_SWORD_SHARPNESS_1 = registerItem("diamond_sword_sharpness_1", SwordItem::new, new Item.Settings().maxDamage(1561).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        BOW_POWER_1 = registerItem("bow_power_1", BowItem::new, new Item.Settings().maxDamage(384));
        DIAMOND_CHESTPLATE_PROTECTION_2 = registerItem("diamond_chestplate_protection_2", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(528).rarity(Rarity.EPIC));
        EFFICIENCY_3_PICKAXE = registerItem("efficiency_3_pickaxe", PickaxeItem::new, new Item.Settings().maxDamage(1561).rarity(Rarity.EPIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        LUCKY_BLOCK_ITEM = registerItem("lucky_block_item", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return STONE_PICKAXE != null ? STONE_PICKAXE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (STONE_PICKAXE != null) entries.add(STONE_PICKAXE);
        if (BREAD != null) entries.add(BREAD);
        if (COOKED_BEEF != null) entries.add(COOKED_BEEF);
        if (APPLE != null) entries.add(APPLE);
        if (GOLDEN_APPLE != null) entries.add(GOLDEN_APPLE);
        if (ENCHANTED_BOOK != null) entries.add(ENCHANTED_BOOK);
        if (IRON_CHESTPLATE != null) entries.add(IRON_CHESTPLATE);
        if (NETHERITE_SCRAP != null) entries.add(NETHERITE_SCRAP);
        if (ANCIENT_DEBRIS != null) entries.add(ANCIENT_DEBRIS);
        if (DRAGON_BREATH != null) entries.add(DRAGON_BREATH);
        if (DIAMOND_SWORD_SHARPNESS_1 != null) entries.add(DIAMOND_SWORD_SHARPNESS_1);
        if (BOW_POWER_1 != null) entries.add(BOW_POWER_1);
        if (DIAMOND_CHESTPLATE_PROTECTION_2 != null) entries.add(DIAMOND_CHESTPLATE_PROTECTION_2);
        if (EFFICIENCY_3_PICKAXE != null) entries.add(EFFICIENCY_3_PICKAXE);
        if (LUCKY_BLOCK_ITEM != null) entries.add(LUCKY_BLOCK_ITEM);
    }
}