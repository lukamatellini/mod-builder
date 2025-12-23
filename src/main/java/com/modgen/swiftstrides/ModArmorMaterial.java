package com.modgen.swiftstrides;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import java.util.Map;
import java.util.EnumMap;

/**
 * Custom ArmorMaterial for swiftstrides
 * Required in 1.21.4 because ArmorMaterial is a record, not an interface
 */
public class ModArmorMaterial {
    
    public static final ArmorMaterial DIAMOND_EQUIVALENT = new ArmorMaterial(
        33, // durability multiplier (matches diamond)
        createProtectionMap(3, 8, 6, 3, 11), // protection values
        15, // enchantability
        SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
        0.0f, // toughness (diamond has 2.0)
        0.0f, // knockback resistance
        ItemTags.REPAIRS_DIAMOND_ARMOR,
        EquipmentModels.DIAMOND // model key
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