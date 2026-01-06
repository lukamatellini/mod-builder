package com.modgen.chancecubes;


import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.PickaxeItem;
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
    public static Item LUCKY_PICKAXE;
    public static Item LUCKY_SWORD;
    public static Item A_I_D_HEART;
    public static Item ROTTEN_FLESH;
    public static Item AID_HEART;
    public static Item SPIDER_EYE;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ChanceCubes.MOD_ID, name);
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
        ChanceCubes.LOGGER.info("Registering items for " + ChanceCubes.MOD_ID);
        LUCKY_PICKAXE = registerItem("lucky_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(500).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        LUCKY_SWORD = registerItem("lucky_sword", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxDamage(700).rarity(Rarity.RARE).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        A_I_D_HEART = registerItem("a_i_d_heart", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        ROTTEN_FLESH = registerItem("rotten_flesh", Item::new);
        AID_HEART = registerItem("aid_heart", Item::new);
        SPIDER_EYE = registerItem("spider_eye", Item::new);
    }
    
    public static Item getFirstItem() {
        return LUCKY_PICKAXE != null ? LUCKY_PICKAXE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_PICKAXE != null) entries.add(LUCKY_PICKAXE);
        if (LUCKY_SWORD != null) entries.add(LUCKY_SWORD);
        if (A_I_D_HEART != null) entries.add(A_I_D_HEART);
        if (ROTTEN_FLESH != null) entries.add(ROTTEN_FLESH);
        if (AID_HEART != null) entries.add(AID_HEART);
        if (SPIDER_EYE != null) entries.add(SPIDER_EYE);
    }
}