package com.modgen.shatteredrealmsaga.item;

import com.modgen.shatteredrealmsaga.ShatteredRealmSaga;
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
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.TeleportTarget;
import net.minecraft.world.World;

/**
 * Warp Item for The Shattered Realm dimension
 * Right-click to teleport to/from the dimension
 */
public class TheShatteredRealmWarpItem extends Item {
    
    private static final RegistryKey<World> DIMENSION_KEY = RegistryKey.of(
        RegistryKeys.WORLD, Identifier.of(ShatteredRealmSaga.MOD_ID, "the_shattered_realm")
    );
    
    public TheShatteredRealmWarpItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
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
                    return TypedActionResult.fail(stack);
                }
                player.sendMessage(Text.literal("§dTeleporting to The Shattered Realm..."), true);
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
            
            // Cooldown (1.21.1 API - uses stack.getItem() instead of stack)
            player.getItemCooldownManager().set(stack.getItem(), 100);
        }
        
        return TypedActionResult.success(stack, world.isClient());
    }
}