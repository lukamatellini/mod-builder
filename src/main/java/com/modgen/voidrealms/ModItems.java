package com.modgen.voidrealms;

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

import com.modgen.voidrealms.item.ShardbreakerSwordItem;
import com.modgen.voidrealms.item.CrystalStaffItem;
import com.modgen.voidrealms.item.SoulOrbItem;
import com.modgen.voidrealms.item.ShatteredRealmPortalIgniterItem;

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
    public static Item SHATTERED_REALM_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(VoidRealms.MOD_ID, name);
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
        VoidRealms.LOGGER.info("Registering items for " + VoidRealms.MOD_ID);
        VOID_HELMET = registerItem("void_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.RARE));
        VOID_CHESTPLATE = registerItem("void_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(650).rarity(Rarity.RARE));
        VOID_LEGGINGS = registerItem("void_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(600).rarity(Rarity.RARE));
        VOID_BOOTS = registerItem("void_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(450).rarity(Rarity.RARE));
        SHARDBREAKER_SWORD = registerItem("shardbreaker_sword", ShardbreakerSwordItem::new, new Item.Settings().maxCount(1).maxDamage(800).rarity(Rarity.EPIC));
        CRYSTAL_STAFF = registerItem("crystal_staff", CrystalStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
        ABYSSAL_PICKAXE = registerItem("abyssal_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1200).rarity(Rarity.RARE).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        SOUL_ORB = registerItem("soul_orb", SoulOrbItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
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
        if (SHATTERED_REALM_PORTAL_IGNITER != null) entries.add(SHATTERED_REALM_PORTAL_IGNITER);
    }
}