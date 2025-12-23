package com.modgen.aetheriaascendant;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.item.equipment.EquipmentType;

import com.modgen.aetheriaascendant.item.ThunderWandItem;
import com.modgen.aetheriaascendant.item.HealingStaffItem;
import com.modgen.aetheriaascendant.item.TeleportationScrollItem;
import com.modgen.aetheriaascendant.item.AetherPortalIgniterItem;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item THUNDER_WAND;
    public static Item AETHER_BLADE;
    public static Item CLOUD_STRIDER_BOOTS;
    public static Item HEALING_STAFF;
    public static Item TELEPORTATION_SCROLL;
    public static Item AETHER_PORTAL_IGNITER;

    /**
     * Minecraft 1.21.2+ Item Registration Pattern
     * Uses RegistryKey and settings.registryKey() BEFORE item construction
     * This is REQUIRED in 1.21.2+ or you get "Item id not set" error
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AetheriaAscendant.MOD_ID, name));
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }
    
    /**
     * Convenience method for simple items with default settings
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        AetheriaAscendant.LOGGER.info("Registering items for " + AetheriaAscendant.MOD_ID);
        THUNDER_WAND = registerItem("thunder_wand", ThunderWandItem::new, new Item.Settings().maxCount(1).maxDamage(1000).rarity(Rarity.EPIC));
        AETHER_BLADE = registerItem("aether_blade", settings -> new SwordItem(ToolMaterial.DIAMOND, 3f, -2.4f, settings), new Item.Settings().Settings().maxCount(1).maxDamage(1500).rarity(Rarity.EPIC));
        CLOUD_STRIDER_BOOTS = registerItem("cloud_strider_boots", settings -> new ArmorItem(ArmorMaterials.DIAMOND, EquipmentType.BOOTS, settings), new Item.Settings().Settings().maxCount(1).maxDamage(400).rarity(Rarity.RARE));
        HEALING_STAFF = registerItem("healing_staff", HealingStaffItem::new, new Item.Settings().maxCount(1).maxDamage(500).rarity(Rarity.UNCOMMON));
        TELEPORTATION_SCROLL = registerItem("teleportation_scroll", TeleportationScrollItem::new, new Item.Settings().maxDamage(500).rarity(Rarity.RARE));
        AETHER_PORTAL_IGNITER = registerItem("aether_portal_igniter", AetherPortalIgniterItem::new, new Item.Settings().maxDamage(64).rarity(Rarity.EPIC));
    }
    
    public static Item getFirstItem() {
        return THUNDER_WAND != null ? THUNDER_WAND : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (THUNDER_WAND != null) entries.add(THUNDER_WAND);
        if (AETHER_BLADE != null) entries.add(AETHER_BLADE);
        if (CLOUD_STRIDER_BOOTS != null) entries.add(CLOUD_STRIDER_BOOTS);
        if (HEALING_STAFF != null) entries.add(HEALING_STAFF);
        if (TELEPORTATION_SCROLL != null) entries.add(TELEPORTATION_SCROLL);
        if (AETHER_PORTAL_IGNITER != null) entries.add(AETHER_PORTAL_IGNITER);
    }
}