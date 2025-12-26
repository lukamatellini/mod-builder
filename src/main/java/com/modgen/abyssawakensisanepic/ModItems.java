package com.modgen.abyssawakensisanepic;

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

import com.modgen.abyssawakensisanepic.item.AbyssalCompassItem;
import com.modgen.abyssawakensisanepic.item.PurificationStaffItem;
import com.modgen.abyssawakensisanepic.item.AbyssalVoidPortalIgniterItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item VOID_SILK;
    public static Item WRAITH_ESSENCE;
    public static Item CRYSTAL_SHARD;
    public static Item ABYSSAL_SCALE;
    public static Item CORRUPTED_HEART;
    public static Item ABYSSAL_COMPASS;
    public static Item VOID_BLADE;
    public static Item CRYSTAL_PICKAXE;
    public static Item WRAITH_CLOAK;
    public static Item VOID_KINGS_CROWN;
    public static Item PURIFICATION_STAFF;
    public static Item POTION_OF_VOID_SIGHT;
    public static Item ABYSSAL_VOID_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(AbyssAwakensIsAnEpicAdventure.MOD_ID, name);
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
        AbyssAwakensIsAnEpicAdventure.LOGGER.info("Registering items for " + AbyssAwakensIsAnEpicAdventure.MOD_ID);
        VOID_SILK = registerItem("void_silk", Item::new, new Item.Settings().maxDamage(500));
        WRAITH_ESSENCE = registerItem("wraith_essence", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        CRYSTAL_SHARD = registerItem("crystal_shard", Item::new, new Item.Settings().maxDamage(500));
        ABYSSAL_SCALE = registerItem("abyssal_scale", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        CORRUPTED_HEART = registerItem("corrupted_heart", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        ABYSSAL_COMPASS = registerItem("abyssal_compass", AbyssalCompassItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_BLADE = registerItem("void_blade", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.EPIC).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CRYSTAL_PICKAXE = registerItem("crystal_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(2000).rarity(Rarity.EPIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        WRAITH_CLOAK = registerItem("wraith_cloak", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.EPIC));
        VOID_KINGS_CROWN = registerItem("void_kings_crown", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC));
        PURIFICATION_STAFF = registerItem("purification_staff", PurificationStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC));
        POTION_OF_VOID_SIGHT = registerItem("potion_of_void_sight", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ABYSSAL_VOID_PORTAL_IGNITER = registerItem("abyssal_void_portal_igniter", AbyssalVoidPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return VOID_SILK != null ? VOID_SILK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_SILK != null) entries.add(VOID_SILK);
        if (WRAITH_ESSENCE != null) entries.add(WRAITH_ESSENCE);
        if (CRYSTAL_SHARD != null) entries.add(CRYSTAL_SHARD);
        if (ABYSSAL_SCALE != null) entries.add(ABYSSAL_SCALE);
        if (CORRUPTED_HEART != null) entries.add(CORRUPTED_HEART);
        if (ABYSSAL_COMPASS != null) entries.add(ABYSSAL_COMPASS);
        if (VOID_BLADE != null) entries.add(VOID_BLADE);
        if (CRYSTAL_PICKAXE != null) entries.add(CRYSTAL_PICKAXE);
        if (WRAITH_CLOAK != null) entries.add(WRAITH_CLOAK);
        if (VOID_KINGS_CROWN != null) entries.add(VOID_KINGS_CROWN);
        if (PURIFICATION_STAFF != null) entries.add(PURIFICATION_STAFF);
        if (POTION_OF_VOID_SIGHT != null) entries.add(POTION_OF_VOID_SIGHT);
        if (ABYSSAL_VOID_PORTAL_IGNITER != null) entries.add(ABYSSAL_VOID_PORTAL_IGNITER);
    }
}