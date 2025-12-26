package com.modgen.aherosbeginning;

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

import com.modgen.aherosbeginning.item.VoidScepterItem;
import com.modgen.aherosbeginning.item.VoidEssenceItem;
import com.modgen.aherosbeginning.item.EtherealVoidPortalIgniterItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item VOID_SCEPTER;
    public static Item VOID_BLADE;
    public static Item CRYSTAL_HEART;
    public static Item VOID_SHARD;
    public static Item ANCIENT_FRAGMENT;
    public static Item ANCIENT_TOME;
    public static Item VOID_ESSENCE;
    public static Item CRYSTAL_HELMET;
    public static Item CRYSTAL_CHESTPLATE;
    public static Item CRYSTAL_LEGGINGS;
    public static Item CRYSTAL_BOOTS;
    public static Item ETHEREAL_VOID_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(AHerosBeginning.MOD_ID, name);
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
        AHerosBeginning.LOGGER.info("Registering items for " + AHerosBeginning.MOD_ID);
        VOID_SCEPTER = registerItem("void_scepter", VoidScepterItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC));
        VOID_BLADE = registerItem("void_blade", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CRYSTAL_HEART = registerItem("crystal_heart", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_SHARD = registerItem("void_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        ANCIENT_FRAGMENT = registerItem("ancient_fragment", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        ANCIENT_TOME = registerItem("ancient_tome", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        VOID_ESSENCE = registerItem("void_essence", VoidEssenceItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        CRYSTAL_HELMET = registerItem("crystal_helmet", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxCount(1).maxDamage(400).rarity(Rarity.RARE));
        CRYSTAL_CHESTPLATE = registerItem("crystal_chestplate", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.RARE));
        CRYSTAL_LEGGINGS = registerItem("crystal_leggings", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, settings), new Item.Settings().maxCount(1).maxDamage(450).rarity(Rarity.RARE));
        CRYSTAL_BOOTS = registerItem("crystal_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, settings), new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.RARE));
        ETHEREAL_VOID_PORTAL_IGNITER = registerItem("ethereal_void_portal_igniter", EtherealVoidPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return VOID_SCEPTER != null ? VOID_SCEPTER : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_SCEPTER != null) entries.add(VOID_SCEPTER);
        if (VOID_BLADE != null) entries.add(VOID_BLADE);
        if (CRYSTAL_HEART != null) entries.add(CRYSTAL_HEART);
        if (VOID_SHARD != null) entries.add(VOID_SHARD);
        if (ANCIENT_FRAGMENT != null) entries.add(ANCIENT_FRAGMENT);
        if (ANCIENT_TOME != null) entries.add(ANCIENT_TOME);
        if (VOID_ESSENCE != null) entries.add(VOID_ESSENCE);
        if (CRYSTAL_HELMET != null) entries.add(CRYSTAL_HELMET);
        if (CRYSTAL_CHESTPLATE != null) entries.add(CRYSTAL_CHESTPLATE);
        if (CRYSTAL_LEGGINGS != null) entries.add(CRYSTAL_LEGGINGS);
        if (CRYSTAL_BOOTS != null) entries.add(CRYSTAL_BOOTS);
        if (ETHEREAL_VOID_PORTAL_IGNITER != null) entries.add(ETHEREAL_VOID_PORTAL_IGNITER);
    }
}