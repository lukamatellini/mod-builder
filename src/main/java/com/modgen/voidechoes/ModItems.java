package com.modgen.voidechoes;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.voidechoes.item.EchoingBowItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item VOID_INFUSED_BLADE;
    public static Item ECHOING_BOW;
    public static Item AMULET_OF_WHISPERS;
    public static Item VOID_INFUSED_INGOT;
    public static Item VOID_SHARD;
    public static Item VOID_INFUSED_STRING;

    /**
     * Minecraft 1.21.0-1.21.1 Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(VoidEchoes.MOD_ID, name);
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
        VoidEchoes.LOGGER.info("Registering items for " + VoidEchoes.MOD_ID);
        VOID_INFUSED_BLADE = registerItem("void_infused_blade", settings -> new SwordItem(ToolMaterials.DIAMOND, settings), new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.UNCOMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f)));
        ECHOING_BOW = registerItem("echoing_bow", EchoingBowItem::new, new Item.Settings().maxCount(1).maxDamage(384).rarity(Rarity.UNCOMMON));
        AMULET_OF_WHISPERS = registerItem("amulet_of_whispers", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_INFUSED_INGOT = registerItem("void_infused_ingot", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_SHARD = registerItem("void_shard", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
        VOID_INFUSED_STRING = registerItem("void_infused_string", Item::new, new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return VOID_INFUSED_BLADE != null ? VOID_INFUSED_BLADE : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (VOID_INFUSED_BLADE != null) entries.add(VOID_INFUSED_BLADE);
        if (ECHOING_BOW != null) entries.add(ECHOING_BOW);
        if (AMULET_OF_WHISPERS != null) entries.add(AMULET_OF_WHISPERS);
        if (VOID_INFUSED_INGOT != null) entries.add(VOID_INFUSED_INGOT);
        if (VOID_SHARD != null) entries.add(VOID_SHARD);
        if (VOID_INFUSED_STRING != null) entries.add(VOID_INFUSED_STRING);
    }
}