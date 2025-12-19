package com.modgen.velocitystrands;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item SWIFTFOOT_BOOTS = registerItem("swiftfoot_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(350).rarity(Rarity.EPIC)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VelocityStrands.MOD_ID, name), item);
    }

    public static void registerItems() {
        VelocityStrands.LOGGER.info("Registering items for " + VelocityStrands.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return SWIFTFOOT_BOOTS;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(SWIFTFOOT_BOOTS);
    }
}