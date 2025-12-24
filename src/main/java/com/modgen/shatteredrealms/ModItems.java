package com.modgen.shatteredrealms;

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

import com.modgen.shatteredrealms.item.ShardbreakerSwordItem;
import com.modgen.shatteredrealms.item.CrystalStaffItem;
import com.modgen.shatteredrealms.item.SoulOrbItem;
import com.modgen.shatteredrealms.item.VoidIgniterItem;
import com.modgen.shatteredrealms.item.ShatteredRealmPortalIgniterItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item VOID_HELMET;
    public static Item VOID_CHESTPLATE;
    public static Item VOID_LEGGINGS;
    public static Item VOID_BOOTS;
    public static Item SHARDBREAKER_SWORD;
    public static Item CRYSTAL_STAFF;
    public static Item ABYSSAL_PICKAXE;
    public static Item SOUL_ORB;
    public static Item VOID_SHARDS;
    public static Item CRYSTAL_SHARDS;
    public static Item VOID_IGNITER;
    public static Item HEART_OF_THE_VOID;
    public static Item VOID_HEART;
    public static Item EMPRESS_DIADEM;
    public static Item SHATTERED_REALM_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ShatteredRealms.MOD_ID, name);
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
        ShatteredRealms.LOGGER.info("Registering items for " + ShatteredRealms.MOD_ID);
        VOID_HELMET = registerItem("void_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.RARE));
        VOID_CHESTPLATE = registerItem("void_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(400).rarity(Rarity.RARE));
        VOID_LEGGINGS = registerItem("void_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(350).rarity(Rarity.RARE));
        VOID_BOOTS = registerItem("void_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.RARE));
        SHARDBREAKER_SWORD = registerItem("shardbreaker_sword", ShardbreakerSwordItem::new, new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.EPIC));
        CRYSTAL_STAFF = registerItem("crystal_staff", CrystalStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
        ABYSSAL_PICKAXE = registerItem("abyssal_pickaxe", PickaxeItem::new, new Item.Settings().maxCount(1).maxDamage(600).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        SOUL_ORB = registerItem("soul_orb", SoulOrbItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_SHARDS = registerItem("void_shards", Item::new, new Item.Settings().maxDamage(500));
        CRYSTAL_SHARDS = registerItem("crystal_shards", Item::new, new Item.Settings().maxDamage(500));
        VOID_IGNITER = registerItem("void_igniter", VoidIgniterItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        HEART_OF_THE_VOID = registerItem("heart_of_the_void", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_HEART = registerItem("void_heart", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        EMPRESS_DIADEM = registerItem("empress_diadem", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.EPIC));
        SHATTERED_REALM_PORTAL_IGNITER = registerItem("shattered_realm_portal_igniter", ShatteredRealmPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return VOID_HELMET != null ? VOID_HELMET : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_HELMET != null) entries.add(VOID_HELMET);
        if (VOID_CHESTPLATE != null) entries.add(VOID_CHESTPLATE);
        if (VOID_LEGGINGS != null) entries.add(VOID_LEGGINGS);
        if (VOID_BOOTS != null) entries.add(VOID_BOOTS);
        if (SHARDBREAKER_SWORD != null) entries.add(SHARDBREAKER_SWORD);
        if (CRYSTAL_STAFF != null) entries.add(CRYSTAL_STAFF);
        if (ABYSSAL_PICKAXE != null) entries.add(ABYSSAL_PICKAXE);
        if (SOUL_ORB != null) entries.add(SOUL_ORB);
        if (VOID_SHARDS != null) entries.add(VOID_SHARDS);
        if (CRYSTAL_SHARDS != null) entries.add(CRYSTAL_SHARDS);
        if (VOID_IGNITER != null) entries.add(VOID_IGNITER);
        if (HEART_OF_THE_VOID != null) entries.add(HEART_OF_THE_VOID);
        if (VOID_HEART != null) entries.add(VOID_HEART);
        if (EMPRESS_DIADEM != null) entries.add(EMPRESS_DIADEM);
        if (SHATTERED_REALM_PORTAL_IGNITER != null) entries.add(SHATTERED_REALM_PORTAL_IGNITER);
    }
}