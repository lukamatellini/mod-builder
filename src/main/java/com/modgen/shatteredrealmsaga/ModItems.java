package com.modgen.shatteredrealmsaga;

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

import com.modgen.shatteredrealmsaga.item.ShardbreakerSwordItem;
import com.modgen.shatteredrealmsaga.item.CrystalStaffItem;
import com.modgen.shatteredrealmsaga.item.SoulOrbItem;
import com.modgen.shatteredrealmsaga.item.TheShatteredRealmPortalIgniterItem;

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
    public static Item WARP_PEDESTAL;
    public static Item ABYSSAL_ALTAR;
    public static Item THE_SHATTERED_REALM_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(ShatteredRealmSaga.MOD_ID, name);
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
        ShatteredRealmSaga.LOGGER.info("Registering items for " + ShatteredRealmSaga.MOD_ID);
        VOID_HELMET = registerItem("void_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(330).rarity(Rarity.RARE));
        VOID_CHESTPLATE = registerItem("void_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(480).rarity(Rarity.RARE));
        VOID_LEGGINGS = registerItem("void_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(420).rarity(Rarity.RARE));
        VOID_BOOTS = registerItem("void_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(270).rarity(Rarity.RARE));
        SHARDBREAKER_SWORD = registerItem("shardbreaker_sword", ShardbreakerSwordItem::new, new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.EPIC));
        CRYSTAL_STAFF = registerItem("crystal_staff", CrystalStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.RARE));
        ABYSSAL_PICKAXE = registerItem("abyssal_pickaxe", PickaxeItem::new, new Item.Settings().maxCount(1).maxDamage(2000).rarity(Rarity.EPIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        SOUL_ORB = registerItem("soul_orb", SoulOrbItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        WARP_PEDESTAL = registerItem("warp_pedestal", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        ABYSSAL_ALTAR = registerItem("abyssal_altar", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        THE_SHATTERED_REALM_PORTAL_IGNITER = registerItem("the_shattered_realm_portal_igniter", TheShatteredRealmPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
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
        if (WARP_PEDESTAL != null) entries.add(WARP_PEDESTAL);
        if (ABYSSAL_ALTAR != null) entries.add(ABYSSAL_ALTAR);
        if (THE_SHATTERED_REALM_PORTAL_IGNITER != null) entries.add(THE_SHATTERED_REALM_PORTAL_IGNITER);
    }
}