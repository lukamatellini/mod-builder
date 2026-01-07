package com.modgen.luckylootblocks;

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
    public static Item LUCKY_BLOCK;
    public static Item MINECRAFTOAK_PLANKS;
    public static Item MINECRAFTCOBBLESTONE;
    public static Item MINECRAFTDIRT;
    public static Item MINECRAFTCOOKED_BEEF;
    public static Item MINECRAFTPOTIONOTIONHEALING;
    public static Item XP;

    /**
     * Minecraft 1.21.0-compatible Item Registration Pattern
     * Uses Registry.register() with Identifier directly (no registryKey() method)
     */
    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Identifier id = Identifier.of(LuckyLootBlocks.MOD_ID, name);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }
    
    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerItems() {
        LuckyLootBlocks.LOGGER.info("Registering items for " + LuckyLootBlocks.MOD_ID);
        LUCKY_BLOCK = registerItem("lucky_block", Item::new, new Item.Settings().rarity(Rarity.RARE));
        MINECRAFTOAK_PLANKS = registerItem("minecraftoak_planks", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTCOBBLESTONE = registerItem("minecraftcobblestone", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTDIRT = registerItem("minecraftdirt", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTCOOKED_BEEF = registerItem("minecraftcooked_beef", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        MINECRAFTPOTIONOTIONHEALING = registerItem("minecraftpotionotionhealing", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
        XP = registerItem("xp", Item::new, new Item.Settings().rarity(Rarity.UNCOMMON));
    }
    
    public static Item getFirstItem() {
        return LUCKY_BLOCK != null ? LUCKY_BLOCK : Items.DIAMOND;
    }
    
    public static void addToCreativeTab(ItemGroup.Entries entries) {
        if (LUCKY_BLOCK != null) entries.add(LUCKY_BLOCK);
        if (MINECRAFTOAK_PLANKS != null) entries.add(MINECRAFTOAK_PLANKS);
        if (MINECRAFTCOBBLESTONE != null) entries.add(MINECRAFTCOBBLESTONE);
        if (MINECRAFTDIRT != null) entries.add(MINECRAFTDIRT);
        if (MINECRAFTCOOKED_BEEF != null) entries.add(MINECRAFTCOOKED_BEEF);
        if (MINECRAFTPOTIONOTIONHEALING != null) entries.add(MINECRAFTPOTIONOTIONHEALING);
        if (XP != null) entries.add(XP);
    }
}