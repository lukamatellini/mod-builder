package com.modgen.shatteredrealmsaga.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import java.util.List;

/**
 * Packet definitions - shared types, no client/server specific code
 */
public class ModPackets {
    
    // Packet IDs
    public static final Identifier OPEN_JOURNAL_ID = Identifier.of("shatteredrealmsaga", "open_journal");
    public static final Identifier DIALOGUE_ID = Identifier.of("shatteredrealmsaga", "dialogue");
    public static final Identifier CLOSE_DIALOGUE_ID = Identifier.of("shatteredrealmsaga", "close_dialogue");
    public static final Identifier DIALOGUE_CHOICE_ID = Identifier.of("shatteredrealmsaga", "dialogue_choice");
    public static final Identifier OPEN_TRADING_ID = Identifier.of("shatteredrealmsaga", "open_trading");
    public static final Identifier EXECUTE_TRADE_ID = Identifier.of("shatteredrealmsaga", "execute_trade");
    public static final Identifier PROGRESS_BAR_UPDATE_ID = Identifier.of("shatteredrealmsaga", "progress_bar_update");

    // === QUEST PAYLOAD ===
    public record OpenJournalPayload() implements CustomPayload {
        public static final CustomPayload.Id<OpenJournalPayload> ID = new CustomPayload.Id<>(OPEN_JOURNAL_ID);
        public static final PacketCodec<RegistryByteBuf, OpenJournalPayload> CODEC = 
            PacketCodec.unit(new OpenJournalPayload());
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }

    // === DIALOGUE PAYLOADS ===
    public record DialoguePayload(String npcName, List<String> lines, List<String> choices) implements CustomPayload {
        public static final CustomPayload.Id<DialoguePayload> ID = new CustomPayload.Id<>(DIALOGUE_ID);
        public static final PacketCodec<RegistryByteBuf, DialoguePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, DialoguePayload::npcName,
            PacketCodecs.STRING.collect(PacketCodecs.toList()), DialoguePayload::lines,
            PacketCodecs.STRING.collect(PacketCodecs.toList()), DialoguePayload::choices,
            DialoguePayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
    
    public record CloseDialoguePayload() implements CustomPayload {
        public static final CustomPayload.Id<CloseDialoguePayload> ID = new CustomPayload.Id<>(CLOSE_DIALOGUE_ID);
        public static final PacketCodec<RegistryByteBuf, CloseDialoguePayload> CODEC = 
            PacketCodec.unit(new CloseDialoguePayload());
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
    
    public record DialogueChoicePayload(int choiceIndex) implements CustomPayload {
        public static final CustomPayload.Id<DialogueChoicePayload> ID = new CustomPayload.Id<>(DIALOGUE_CHOICE_ID);
        public static final PacketCodec<RegistryByteBuf, DialogueChoicePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER, DialogueChoicePayload::choiceIndex,
            DialogueChoicePayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }

    // === TRADING PAYLOAD CLASSES ===
    
    /**
     * Trade data structure for network transmission
     * Uses manual codec due to 8 fields (exceeds PacketCodec.tuple max of 6)
     */
    public record TradeData(
        String tradeId,
        String outputName,
        int outputCount,
        List<String> inputNames,
        List<Integer> inputCounts,
        int stock,
        boolean canAfford,
        int requiredReputation
    ) {
        public static final PacketCodec<RegistryByteBuf, TradeData> CODEC = new PacketCodec<>() {
            @Override
            public TradeData decode(RegistryByteBuf buf) {
                String tradeId = PacketCodecs.STRING.decode(buf);
                String outputName = PacketCodecs.STRING.decode(buf);
                int outputCount = PacketCodecs.INTEGER.decode(buf);
                List<String> inputNames = PacketCodecs.STRING.collect(PacketCodecs.toList()).decode(buf);
                List<Integer> inputCounts = PacketCodecs.INTEGER.collect(PacketCodecs.toList()).decode(buf);
                int stock = PacketCodecs.INTEGER.decode(buf);
                boolean canAfford = PacketCodecs.BOOL.decode(buf);
                int requiredReputation = PacketCodecs.INTEGER.decode(buf);
                return new TradeData(tradeId, outputName, outputCount, inputNames, inputCounts, stock, canAfford, requiredReputation);
            }
            
            @Override
            public void encode(RegistryByteBuf buf, TradeData data) {
                PacketCodecs.STRING.encode(buf, data.tradeId);
                PacketCodecs.STRING.encode(buf, data.outputName);
                PacketCodecs.INTEGER.encode(buf, data.outputCount);
                PacketCodecs.STRING.collect(PacketCodecs.toList()).encode(buf, data.inputNames);
                PacketCodecs.INTEGER.collect(PacketCodecs.toList()).encode(buf, data.inputCounts);
                PacketCodecs.INTEGER.encode(buf, data.stock);
                PacketCodecs.BOOL.encode(buf, data.canAfford);
                PacketCodecs.INTEGER.encode(buf, data.requiredReputation);
            }
        };
    }
    
    public record OpenTradingPayload(String merchantId, String merchantName, List<TradeData> trades) implements CustomPayload {
        public static final CustomPayload.Id<OpenTradingPayload> ID = new CustomPayload.Id<>(OPEN_TRADING_ID);
        public static final PacketCodec<RegistryByteBuf, OpenTradingPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, OpenTradingPayload::merchantId,
            PacketCodecs.STRING, OpenTradingPayload::merchantName,
            TradeData.CODEC.collect(PacketCodecs.toList()), OpenTradingPayload::trades,
            OpenTradingPayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
    
    public record ExecuteTradePayload(String merchantId, int tradeIndex) implements CustomPayload {
        public static final CustomPayload.Id<ExecuteTradePayload> ID = new CustomPayload.Id<>(EXECUTE_TRADE_ID);
        public static final PacketCodec<RegistryByteBuf, ExecuteTradePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, ExecuteTradePayload::merchantId,
            PacketCodecs.INTEGER, ExecuteTradePayload::tradeIndex,
            ExecuteTradePayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }

    // === PROGRESS BAR PAYLOAD ===
    
    public record ProgressBarUpdatePayload(String barId, String label, float progress, int color, int durationTicks) implements CustomPayload {
        public static final CustomPayload.Id<ProgressBarUpdatePayload> ID = new CustomPayload.Id<>(PROGRESS_BAR_UPDATE_ID);
        public static final PacketCodec<RegistryByteBuf, ProgressBarUpdatePayload> CODEC = PacketCodec.tuple(
            PacketCodecs.STRING, ProgressBarUpdatePayload::barId,
            PacketCodecs.STRING, ProgressBarUpdatePayload::label,
            PacketCodecs.FLOAT, ProgressBarUpdatePayload::progress,
            PacketCodecs.INTEGER, ProgressBarUpdatePayload::color,
            PacketCodecs.INTEGER, ProgressBarUpdatePayload::durationTicks,
            ProgressBarUpdatePayload::new
        );
        
        @Override
        public Id<? extends CustomPayload> getId() { return ID; }
    }
}