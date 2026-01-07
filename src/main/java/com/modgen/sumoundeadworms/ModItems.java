package com.modgen.sumoundeadworms;

import java.util.function.Function;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // DEFERRED REGISTRATION: Fields initialized in registerItems()
    public static Item SUMO_HACHIMAKI;
    public static Item CARROT_RARE;
    public static Item CLAY_BALL_RARE;
    public static Item RAW_PORKCHOP;
    public static Item SUMO_HACHIMAKI_RARE_COSMETIC_HELMET_WITH_PROTECTION_I;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(SumoUndeadWorms.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        SumoUndeadWorms.LOGGER.info("Registering items for " + SumoUndeadWorms.MOD_ID);
        SUMO_HACHIMAKI = registerItem("sumo_hachimaki", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.HELMET, settings), new Item.Settings().maxDamage(100).rarity(Rarity.RARE));
        CARROT_RARE = registerItem("carrot_rare", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        CLAY_BALL_RARE = registerItem("clay_ball_rare", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        RAW_PORKCHOP = registerItem("raw_porkchop", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        SUMO_HACHIMAKI_RARE_COSMETIC_HELMET_WITH_PROTECTION_I = registerItem("sumo_hachimaki_rare_cosmetic_helmet_with_protection_i", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return SUMO_HACHIMAKI != null ? SUMO_HACHIMAKI : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (SUMO_HACHIMAKI != null) entries.add(SUMO_HACHIMAKI);
        if (CARROT_RARE != null) entries.add(CARROT_RARE);
        if (CLAY_BALL_RARE != null) entries.add(CLAY_BALL_RARE);
        if (RAW_PORKCHOP != null) entries.add(RAW_PORKCHOP);
        if (SUMO_HACHIMAKI_RARE_COSMETIC_HELMET_WITH_PROTECTION_I != null) entries.add(SUMO_HACHIMAKI_RARE_COSMETIC_HELMET_WITH_PROTECTION_I);
    }
}