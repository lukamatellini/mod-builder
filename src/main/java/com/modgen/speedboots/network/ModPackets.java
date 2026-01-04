package com.modgen.speedboots.network;

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
    public static final Identifier PROGRESS_BAR_UPDATE_ID = Identifier.of("speedboots", "progress_bar_update");

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