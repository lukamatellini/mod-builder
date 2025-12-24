package com.modgen.shatteredrealms.block;

import com.modgen.shatteredrealms.ShatteredRealms;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

public class ShatteredRealmPortalBlock extends Block {
    
    private static final RegistryKey<World> DIMENSION_KEY = RegistryKey.of(
        RegistryKeys.WORLD, Identifier.of(ShatteredRealms.MOD_ID, "shattered_realm")
    );
    
    public ShatteredRealmPortalBlock(Settings settings) {
        super(settings);
    }
    
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (world.isClient || !(entity instanceof ServerPlayerEntity player)) return;
        if (entity.hasPortalCooldown()) return;
        
        entity.setPortalCooldown(100);
        
        world.playSound(null, pos, SoundEvents.BLOCK_PORTAL_TRIGGER, SoundCategory.BLOCKS, 1.0f, 1.0f);
        
        ServerWorld targetWorld;
        if (world.getRegistryKey().equals(DIMENSION_KEY)) {
            targetWorld = player.getServer().getOverworld();
        } else {
            targetWorld = player.getServer().getWorld(DIMENSION_KEY);
        }
        
        if (targetWorld != null) {
            TeleportTarget target = new TeleportTarget(
                targetWorld, player.getPos(), player.getVelocity(),
                player.getYaw(), player.getPitch(), TeleportTarget.NO_OP
            );
            player.teleportTo(target);
        }
    }
}