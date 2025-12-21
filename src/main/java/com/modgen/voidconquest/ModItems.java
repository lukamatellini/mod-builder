package com.modgen.voidconquest;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.voidconquest.item.VoidReaperItem;
import com.modgen.voidconquest.item.CrystalStaffItem;
import com.modgen.voidconquest.item.VoidKeyItem;
import com.modgen.voidconquest.item.SoulLanternItem;
import com.modgen.voidconquest.item.HealthInjectorItem;

public class ModItems {
    public static final Item VOID_REAPER = registerItem("void_reaper", new VoidReaperItem(new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.EPIC)));
    public static final Item CRYSTAL_STAFF = registerItem("crystal_staff", new CrystalStaffItem(new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC)));
    public static final Item TITAN_HELMET = registerItem("titan_helmet", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(330).rarity(Rarity.RARE)));
    public static final Item TITAN_CHESTPLATE = registerItem("titan_chestplate", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(480).rarity(Rarity.RARE)));
    public static final Item TITAN_LEGGINGS = registerItem("titan_leggings", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(420).rarity(Rarity.RARE)));
    public static final Item TITAN_BOOTS = registerItem("titan_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(360).rarity(Rarity.RARE)));
    public static final Item VOID_KEY = registerItem("void_key", new VoidKeyItem(new Item.Settings().maxDamage(1).rarity(Rarity.RARE)));
    public static final Item SOUL_LANTERN = registerItem("soul_lantern", new SoulLanternItem(new Item.Settings().maxDamage(100).rarity(Rarity.UNCOMMON)));
    public static final Item HEALTH_INJECTOR = registerItem("health_injector", new HealthInjectorItem(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(VoidConquest.MOD_ID, name), item);
    }

    public static void registerItems() {
        VoidConquest.LOGGER.info("Registering items for " + VoidConquest.MOD_ID);
    }
    
    public static Item getFirstItem() {
        return VOID_REAPER;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        entries.add(VOID_REAPER);
        entries.add(CRYSTAL_STAFF);
        entries.add(TITAN_HELMET);
        entries.add(TITAN_CHESTPLATE);
        entries.add(TITAN_LEGGINGS);
        entries.add(TITAN_BOOTS);
        entries.add(VOID_KEY);
        entries.add(SOUL_LANTERN);
        entries.add(HEALTH_INJECTOR);
    }
}