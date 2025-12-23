package com.modgen.aetheriaascendant.item;

import com.modgen.aetheriaascendant.AetheriaAscendant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

/**
 * Warp Item for The Aether dimension
 * Right-click to teleport to/from the dimension
 */
public class AetherWarpItem extends Item {
    
    private static final RegistryKey<World> DIMENSION_KEY = RegistryKey.of(
        RegistryKeys.WORLD, Identifier.of(AetheriaAscendant.MOD_ID, "aether")
    );
    
    public AetherWarpItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        
        if (!world.isClient && player instanceof ServerPlayerEntity serverPlayer) {
            // Play teleport sound
            world.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.ENTITY_ENDERMAN_TELEPORT, SoundCategory.PLAYERS, 1.0f, 1.0f);
            
            ServerWorld targetWorld;
            
            // Toggle between dimension and overworld
            if (world.getRegistryKey().equals(DIMENSION_KEY)) {
                // In custom dimension -> go to overworld
                targetWorld = serverPlayer.getServer().getOverworld();
                player.sendMessage(Text.literal("§aReturning to the Overworld..."), true);
            } else {
                // In any other dimension -> go to custom dimension
                targetWorld = serverPlayer.getServer().getWorld(DIMENSION_KEY);
                if (targetWorld == null) {
                    player.sendMessage(Text.literal("§cDimension not available!"), false);
                    return ActionResult.FAIL;
                }
                player.sendMessage(Text.literal("§dTeleporting to The Aether..."), true);
            }
            
            // Perform teleport
            TeleportTarget target = new TeleportTarget(
                targetWorld,
                serverPlayer.getPos(),
                serverPlayer.getVelocity(),
                serverPlayer.getYaw(),
                serverPlayer.getPitch(),
                TeleportTarget.NO_OP
            );
            serverPlayer.teleportTo(target);
            
            // Cooldown (1.21.x API - uses ItemStack instead of Item)
            player.getItemCooldownManager().set(stack, 100);
        }
        
        return ActionResult.SUCCESS;
    }
}