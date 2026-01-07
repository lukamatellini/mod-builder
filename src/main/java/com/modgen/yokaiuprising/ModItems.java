package com.modgen.yokaiuprising;

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
    public static Item MUTATED_FLESH;
    public static Item COOKED_MUTATED_FLESH;
    public static Item WORM_MEAT;
    public static Item COOKED_WORM_MEAT;
    public static Item SUMO_BELT;
    public static Item RAW_PORKCHOP;
    public static Item 1_LEATHER;
    public static Item ITSELF;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(YokaiUprising.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        YokaiUprising.LOGGER.info("Registering items for " + YokaiUprising.MOD_ID);
        MUTATED_FLESH = registerItem("mutated_flesh", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        COOKED_MUTATED_FLESH = registerItem("cooked_mutated_flesh", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        WORM_MEAT = registerItem("worm_meat", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        COOKED_WORM_MEAT = registerItem("cooked_worm_meat", Item::new, new Item.Settings().food(new FoodComponent.Builder().nutrition(6).saturationModifier(0.8f).build()));
        SUMO_BELT = registerItem("sumo_belt", settings -> new ArmorItem(ArmorMaterials.DIAMOND, ArmorItem.Type.CHESTPLATE, settings), new Item.Settings().maxDamage(150).rarity(Rarity.RARE));
        RAW_PORKCHOP = registerItem("raw_porkchop", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        1_LEATHER = registerItem("1_leather", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        ITSELF = registerItem("itself", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return MUTATED_FLESH != null ? MUTATED_FLESH : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (MUTATED_FLESH != null) entries.add(MUTATED_FLESH);
        if (COOKED_MUTATED_FLESH != null) entries.add(COOKED_MUTATED_FLESH);
        if (WORM_MEAT != null) entries.add(WORM_MEAT);
        if (COOKED_WORM_MEAT != null) entries.add(COOKED_WORM_MEAT);
        if (SUMO_BELT != null) entries.add(SUMO_BELT);
        if (RAW_PORKCHOP != null) entries.add(RAW_PORKCHOP);
        if (1_LEATHER != null) entries.add(1_LEATHER);
        if (ITSELF != null) entries.add(ITSELF);
    }
}