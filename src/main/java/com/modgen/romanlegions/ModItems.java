package com.modgen.romanlegions;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item GLADIUS = registerItem("gladius", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings().maxCount(1).maxDamage(250).rarity(Rarity.UNCOMMON).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item PUGIO = registerItem("pugio", new SwordItem(ToolMaterials.DIAMOND, new Item.Settings().maxCount(1).maxDamage(150).attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.DIAMOND, 3, -2.4f))));
    public static final Item PILUM = registerItem("pilum", new Item(new Item.Settings().maxDamage(1).rarity(Rarity.UNCOMMON)));
    public static final Item SCUTUM = registerItem("scutum", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));
    public static final Item LORICA_SEGMENTATA = registerItem("lorica_segmentata", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(400).rarity(Rarity.RARE)));
    public static final Item GALEA = registerItem("galea", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(200).rarity(Rarity.UNCOMMON)));
    public static final Item CALIGAE = registerItem("caligae", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(180)));
    public static final Item BALTEUS = registerItem("balteus", new Item(new Item.Settings().maxDamage(100).rarity(Rarity.UNCOMMON)));
    public static final Item LEGION_STANDARD = registerItem("legion_standard", new Item(new Item.Settings().maxDamage(1000).rarity(Rarity.EPIC)));
    public static final Item DENARII = registerItem("denarii", new Item(new Item.Settings().maxDamage(500)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(RomanLegions.MOD_ID, name), item);
    }

    public static void registerItems() {
        RomanLegions.LOGGER.info("Registering items for " + RomanLegions.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return GLADIUS;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(GLADIUS);
        entries.add(PUGIO);
        entries.add(PILUM);
        entries.add(SCUTUM);
        entries.add(LORICA_SEGMENTATA);
        entries.add(GALEA);
        entries.add(CALIGAE);
        entries.add(BALTEUS);
        entries.add(LEGION_STANDARD);
        entries.add(DENARII);
    }
}