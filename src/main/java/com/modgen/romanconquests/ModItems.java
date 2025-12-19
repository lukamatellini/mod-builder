package com.modgen.romanconquests;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item GLADIUS = registerItem("gladius", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings().maxCount(1).maxDamage(250).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item PUGIO = registerItem("pugio", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings().maxCount(1).maxDamage(150).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item PILUM = registerItem("pilum", new Item(new Item.Settings().maxDamage(500)));
    public static final Item SCUTUM = registerItem("scutum", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    public static final Item LORICA_SEGMENTATA_HELMET = registerItem("lorica_segmentata_helmet", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(165).rarity(Rarity.UNCOMMON)));
    public static final Item LORICA_SEGMENTATA_CHESTPLATE = registerItem("lorica_segmentata_chestplate", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(240).rarity(Rarity.UNCOMMON)));
    public static final Item LORICA_SEGMENTATA_LEGGINGS = registerItem("lorica_segmentata_leggings", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(225).rarity(Rarity.UNCOMMON)));
    public static final Item LORICA_SEGMENTATA_BOOTS = registerItem("lorica_segmentata_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(195).rarity(Rarity.UNCOMMON)));
    public static final Item ROMAN_STANDARD = registerItem("roman_standard", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.RARE)));
    public static final Item LAUREL_WREATH = registerItem("laurel_wreath", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(300).rarity(Rarity.EPIC)));
    public static final Item DENARIUS = registerItem("denarius", new Item(new Item.Settings().maxDamage(500)));
    public static final Item ROMAN_BRICK = registerItem("roman_brick", new Item(new Item.Settings().maxDamage(500)));
    public static final Item TOGA_CLOTH = registerItem("toga_cloth", new Item(new Item.Settings().maxDamage(500)));
    public static final Item MARBLE_BLOCK = registerItem("marble_block", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    public static final Item CHISELED_MARBLE = registerItem("chiseled_marble", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    public static final Item PILLAR_BLOCK = registerItem("pillar_block", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.RARE)));
    public static final Item MOSAIC_TILE = registerItem("mosaic_tile", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RomanConquests.MOD_ID, name), item);
    }

    public static void registerItems() {
        RomanConquests.LOGGER.info("Registering items for " + RomanConquests.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return GLADIUS;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(GLADIUS);
        entries.add(PUGIO);
        entries.add(PILUM);
        entries.add(SCUTUM);
        entries.add(LORICA_SEGMENTATA_HELMET);
        entries.add(LORICA_SEGMENTATA_CHESTPLATE);
        entries.add(LORICA_SEGMENTATA_LEGGINGS);
        entries.add(LORICA_SEGMENTATA_BOOTS);
        entries.add(ROMAN_STANDARD);
        entries.add(LAUREL_WREATH);
        entries.add(DENARIUS);
        entries.add(ROMAN_BRICK);
        entries.add(TOGA_CLOTH);
        entries.add(MARBLE_BLOCK);
        entries.add(CHISELED_MARBLE);
        entries.add(PILLAR_BLOCK);
        entries.add(MOSAIC_TILE);
    }
}