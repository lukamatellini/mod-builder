package com.modgen.swiftstridesteps;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.EnumMap;
import java.util.List;

/**
 * Custom ArmorMaterial for swiftstridesteps
 * Required in 1.21.4 because ArmorMaterial is a record, not an interface
 * Uses Identifier.ofVanilla("diamond") for the layer instead of EquipmentModels
 */
public class ModArmorMaterial {
    
    /**
     * Diamond-equivalent armor material using the 1.21.4 ArmorMaterial record signature:
     * ArmorMaterial(int durabilityMultiplier, Map<EquipmentType, Integer> protection, 
     *               int enchantability, RegistryEntry<SoundEvent> equipSound,
     *               float toughness, float knockbackResistance, TagKey<Item> repairIngredient,
     *               Identifier modelId)
     */
    public static final ArmorMaterial DIAMOND_EQUIVALENT = new ArmorMaterial(
        33, // durability multiplier (matches diamond)
        createProtectionMap(3, 6, 8, 3, 11), // protection: boots, leggings, chestplate, helmet, body
        10, // enchantability
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        2.0f, // toughness
        0.0f, // knockback resistance
        ItemTags.REPAIRS_DIAMOND_ARMOR,
        Identifier.ofVanilla("diamond") // Use Identifier for model, NOT EquipmentModels class
    );
    
    private static Map<EquipmentType, Integer> createProtectionMap(int boots, int leggings, int chestplate, int helmet, int body) {
        EnumMap<EquipmentType, Integer> map = new EnumMap<>(EquipmentType.class);
        map.put(EquipmentType.BOOTS, boots);
        map.put(EquipmentType.LEGGINGS, leggings);
        map.put(EquipmentType.CHESTPLATE, chestplate);
        map.put(EquipmentType.HELMET, helmet);
        map.put(EquipmentType.BODY, body);
        return map;
    }
}