package com.modgen.shatteredvoidrealms;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import com.modgen.shatteredvoidrealms.item.VoidReaperItem;
import com.modgen.shatteredvoidrealms.item.CrystalStaffItem;
import com.modgen.shatteredvoidrealms.item.SoulLanternItem;
import com.modgen.shatteredvoidrealms.item.HealthInjectorItem;

public class ModItems {
    public static final Item VOID_REAPER = registerItem("void_reaper", new VoidReaperItem(new Item.Settings().maxCount(1).maxDamage(1500).rarity(Rarity.EPIC)));
    public static final Item CRYSTAL_STAFF = registerItem("crystal_staff", new CrystalStaffItem(new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC)));
    public static final Item TITAN_HELMET = registerItem("titan_helmet", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, new Item.Settings().maxCount(1).maxDamage(700).rarity(Rarity.EPIC)));
    public static final Item TITAN_CHESTPLATE = registerItem("titan_chestplate", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxCount(1).maxDamage(900).rarity(Rarity.EPIC)));
    public static final Item TITAN_LEGGINGS = registerItem("titan_leggings", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.LEGGINGS, new Item.Settings().maxCount(1).maxDamage(850).rarity(Rarity.EPIC)));
    public static final Item TITAN_BOOTS = registerItem("titan_boots", new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.BOOTS, new Item.Settings().maxCount(1).maxDamage(750).rarity(Rarity.EPIC)));
    public static final Item VOID_KEY = registerItem("void_key", new Item(new Item.Settings().maxDamage(500).rarity(Rarity.RARE)));
    public static final Item SOUL_LANTERN = registerItem("soul_lantern", new SoulLanternItem(new Item.Settings().maxDamage(500).rarity(Rarity.RARE)));
    public static final Item HEALTH_INJECTOR = registerItem("health_injector", new HealthInjectorItem(new Item.Settings().maxDamage(500).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ShatteredVoidRealms.MOD_ID, name), item);
    }

    public static void registerItems() {
        ShatteredVoidRealms.LOGGER.info("Registering items for " + ShatteredVoidRealms.MOD_ID);
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