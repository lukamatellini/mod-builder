package com.modgen.shatteredvoidrealms.engine;

import com.modgen.shatteredvoidrealms.ShatteredVoidRealms;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Trading System - NPC Shops with Reputation Integration
 * Supports multi-item trades, stock limits, and reputation requirements
 */
public class TradingSystem {
    private static final Logger LOGGER = LoggerFactory.getLogger("shatteredvoidrealms/trading");
    
    // NPC Trade definitions (npcId -> list of trades)
    private final Map<String, List<TradeOffer>> npcTrades = new ConcurrentHashMap<>();
    
    // Player trade usage tracking (playerId -> (npcId -> (tradeIndex -> usesCount)))
    private final Map<UUID, Map<String, Map<Integer, Integer>>> playerTradeUses = new ConcurrentHashMap<>();
    
    public TradingSystem() {
        registerTrades();
    }
    
    private void registerTrades() {
            addTrade("crystal_merchant", new TradeOffer(
                "minecraft:Crystals", 10,
                null, 0,
                "1", 1,
                10, 2, 0
            ));
            addTrade("crystal_merchant", new TradeOffer(
                "minecraft:Crystals", 5,
                null, 0,
                "1", 1,
                10, 2, 0
            ));
            addTrade("crystal_merchant", new TradeOffer(
                "minecraft:Crystals", 15,
                null, 0,
                "1", 1,
                10, 2, 0
            ));
        LOGGER.info("Registered trades for {} NPCs", npcTrades.size());
    }
    
    private void addTrade(String npcId, TradeOffer offer) {
        npcTrades.computeIfAbsent(npcId, k -> new ArrayList<>()).add(offer);
    }
    
    /**
     * Get available trades for an NPC
     */
    public List<TradeOffer> getTradesForNPC(String npcId) {
        return npcTrades.getOrDefault(npcId, Collections.emptyList());
    }
    
    /**
     * Get available trades for a player (filtered by reputation)
     */
    public List<TradeOffer> getAvailableTradesForPlayer(ServerPlayerEntity player, String npcId) {
        List<TradeOffer> allTrades = getTradesForNPC(npcId);
        int playerRep = ShatteredVoidRealms.REPUTATION_SYSTEM.getReputation(player.getUuid(), npcId);
        
        List<TradeOffer> available = new ArrayList<>();
        for (TradeOffer trade : allTrades) {
            if (playerRep >= trade.requiredReputation) {
                // Check if not maxed out
                int uses = getTradeUses(player.getUuid(), npcId, allTrades.indexOf(trade));
                if (uses < trade.maxUses) {
                    available.add(trade);
                }
            }
        }
        return available;
    }
    
    /**
     * Execute a trade
     */
    public TradeResult executeTrade(ServerPlayerEntity player, String npcId, int tradeIndex) {
        List<TradeOffer> trades = getTradesForNPC(npcId);
        if (tradeIndex < 0 || tradeIndex >= trades.size()) {
            return new TradeResult(false, "Invalid trade");
        }
        
        TradeOffer trade = trades.get(tradeIndex);
        
        // Check reputation
        int playerRep = ShatteredVoidRealms.REPUTATION_SYSTEM.getReputation(player.getUuid(), npcId);
        if (playerRep < trade.requiredReputation) {
            return new TradeResult(false, "Insufficient reputation (need " + trade.requiredReputation + ")");
        }
        
        // Check uses
        int uses = getTradeUses(player.getUuid(), npcId, tradeIndex);
        if (uses >= trade.maxUses) {
            return new TradeResult(false, "Trade sold out");
        }
        
        // Check if player has input items
        if (!hasItems(player, trade.inputItemId, trade.inputCount)) {
            return new TradeResult(false, "Missing " + trade.inputCount + "x " + trade.inputItemId);
        }
        if (trade.inputSecondaryId != null && !hasItems(player, trade.inputSecondaryId, trade.inputSecondaryCount)) {
            return new TradeResult(false, "Missing " + trade.inputSecondaryCount + "x " + trade.inputSecondaryId);
        }
        
        // Execute trade
        removeItems(player, trade.inputItemId, trade.inputCount);
        if (trade.inputSecondaryId != null) {
            removeItems(player, trade.inputSecondaryId, trade.inputSecondaryCount);
        }
        giveItems(player, trade.outputItemId, trade.outputCount);
        
        // Track usage
        incrementTradeUse(player.getUuid(), npcId, tradeIndex);
        
        // Grant XP
        if (trade.xpReward > 0) {
            player.addExperience(trade.xpReward);
        }
        
        // Small reputation boost for trading
        ShatteredVoidRealms.REPUTATION_SYSTEM.modifyReputation(player.getUuid(), npcId, 1);
        
        player.sendMessage(Text.literal("§aTrade complete! §7+" + trade.xpReward + " XP"), true);
        return new TradeResult(true, "Success");
    }
    
    private boolean hasItems(ServerPlayerEntity player, String itemId, int count) {
        Item item = resolveItem(itemId);
        if (item == Items.AIR) return false;
        
        int found = 0;
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.getItem().equals(item)) {
                found += stack.getCount();
            }
        }
        return found >= count;
    }
    
    private void removeItems(ServerPlayerEntity player, String itemId, int count) {
        Item item = resolveItem(itemId);
        int remaining = count;
        
        for (int i = 0; i < player.getInventory().size() && remaining > 0; i++) {
            ItemStack stack = player.getInventory().getStack(i);
            if (stack.getItem().equals(item)) {
                int take = Math.min(remaining, stack.getCount());
                stack.decrement(take);
                remaining -= take;
            }
        }
    }
    
    private void giveItems(ServerPlayerEntity player, String itemId, int count) {
        Item item = resolveItem(itemId);
        if (item == Items.AIR) return;
        
        ItemStack stack = new ItemStack(item, count);
        if (!player.getInventory().insertStack(stack)) {
            player.dropItem(stack, false);
        }
    }
    
    private Item resolveItem(String itemId) {
        try {
            Identifier id = itemId.contains(":") ? Identifier.of(itemId) : Identifier.of("shatteredvoidrealms", itemId);
            return Registries.ITEM.get(id);
        } catch (Exception e) {
            return Items.AIR;
        }
    }
    
    private int getTradeUses(UUID playerId, String npcId, int tradeIndex) {
        return playerTradeUses
            .getOrDefault(playerId, Collections.emptyMap())
            .getOrDefault(npcId, Collections.emptyMap())
            .getOrDefault(tradeIndex, 0);
    }
    
    private void incrementTradeUse(UUID playerId, String npcId, int tradeIndex) {
        playerTradeUses
            .computeIfAbsent(playerId, k -> new ConcurrentHashMap<>())
            .computeIfAbsent(npcId, k -> new ConcurrentHashMap<>())
            .merge(tradeIndex, 1, Integer::sum);
    }
    
    /**
     * Reset daily trade limits (call from scheduled task)
     */
    public void resetDailyTrades() {
        playerTradeUses.clear();
        LOGGER.info("Daily trade limits reset");
    }
    
    public int getNPCTradeCount() {
        return npcTrades.size();
    }
    
    // Data classes
    public static class TradeOffer {
        public final String inputItemId;
        public final int inputCount;
        public final String inputSecondaryId;
        public final int inputSecondaryCount;
        public final String outputItemId;
        public final int outputCount;
        public final int maxUses;
        public final int xpReward;
        public final int requiredReputation;
        
        public TradeOffer(String inputItemId, int inputCount, String inputSecondaryId, int inputSecondaryCount,
                         String outputItemId, int outputCount, int maxUses, int xpReward, int requiredReputation) {
            this.inputItemId = inputItemId;
            this.inputCount = inputCount;
            this.inputSecondaryId = inputSecondaryId;
            this.inputSecondaryCount = inputSecondaryCount;
            this.outputItemId = outputItemId;
            this.outputCount = outputCount;
            this.maxUses = maxUses;
            this.xpReward = xpReward;
            this.requiredReputation = requiredReputation;
        }
    }
    
    public static class TradeResult {
        public final boolean success;
        public final String message;
        
        public TradeResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
    }
}