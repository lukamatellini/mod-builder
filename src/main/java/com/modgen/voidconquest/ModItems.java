package com.modgen.voidconquest;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.voidconquest.item.VoidStaffItem;
import com.modgen.voidconquest.item.VoidWarpItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item SHADOW_ESSENCE;
    public static Item CRYSTAL_SHARD;
    public static Item VOID_SCALE;
    public static Item SHADOW_BLADE;
    public static Item CRYSTAL_PICKAXE;
    public static Item VOID_BOW;
    public static Item VOID_STAFF;
    public static Item VOID_WARP;
    public static Item OBSIDIAN_POWDER;
    public static Item VOID_SHARD;
    public static Item THE_VOID_PORTAL_KEY;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(VoidConquest.MOD_ID, name);
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
        VoidConquest.LOGGER.info("Registering items for " + VoidConquest.MOD_ID);
        SHADOW_ESSENCE = registerItem("shadow_essence", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.EPIC));
        CRYSTAL_SHARD = registerItem("crystal_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_SCALE = registerItem("void_scale", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        SHADOW_BLADE = registerItem("shadow_blade", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(800).rarity(Rarity.EPIC).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        CRYSTAL_PICKAXE = registerItem("crystal_pickaxe", settings -> new PickaxeItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 1, -2.8f)));
        VOID_BOW = registerItem("void_bow", BowItem::new, new Item.Settings().maxCount(1).maxDamage(700).rarity(Rarity.RARE));
        VOID_STAFF = registerItem("void_staff", VoidStaffItem::new, new Item.Settings().maxCount(1).maxDamage(1200).rarity(Rarity.EPIC));
        VOID_WARP = registerItem("void_warp", VoidWarpItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        OBSIDIAN_POWDER = registerItem("obsidian_powder", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_SHARD = registerItem("void_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        THE_VOID_PORTAL_KEY = registerItem("the_void_portal_key", Item::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return SHADOW_ESSENCE != null ? SHADOW_ESSENCE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SHADOW_ESSENCE != null) entries.add(SHADOW_ESSENCE);
        if (CRYSTAL_SHARD != null) entries.add(CRYSTAL_SHARD);
        if (VOID_SCALE != null) entries.add(VOID_SCALE);
        if (SHADOW_BLADE != null) entries.add(SHADOW_BLADE);
        if (CRYSTAL_PICKAXE != null) entries.add(CRYSTAL_PICKAXE);
        if (VOID_BOW != null) entries.add(VOID_BOW);
        if (VOID_STAFF != null) entries.add(VOID_STAFF);
        if (VOID_WARP != null) entries.add(VOID_WARP);
        if (OBSIDIAN_POWDER != null) entries.add(OBSIDIAN_POWDER);
        if (VOID_SHARD != null) entries.add(VOID_SHARD);
        if (THE_VOID_PORTAL_KEY != null) entries.add(THE_VOID_PORTAL_KEY);
    }
}