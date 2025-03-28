package com.andrew.firstmod.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import com.andrew.firstmod.data.TeleportationStoneData;

import java.util.Comparator;
import java.util.Optional;
import java.util.Set;

public class TeleportationEffect  extends InstantenousMobEffect {
    public TeleportationEffect(MobEffectCategory category, int color) {super(category, color);}


    private BlockPos findNearestStone(ServerLevel world, BlockPos startPos) {
        Set<BlockPos> stones = TeleportationStoneData.get(world).getStoredPositions();

        Optional<BlockPos> nearest = stones.stream()
                .min(Comparator.comparingDouble(pos -> pos.distSqr(startPos)));

        return nearest.orElse(null);
    }

    private void teleportToTop(LivingEntity entity, BlockPos basePos) {
        ServerLevel world = (ServerLevel) entity.level();
        BlockPos topPos = basePos.above(); // Assume the player stands on top of the block

        while (!world.getBlockState(topPos).isAir() && topPos.getY() < world.getMaxBuildHeight()) {
            topPos = topPos.above();
        }

        entity.teleportTo(topPos.getX() + 0.5, topPos.getY(), topPos.getZ() + 0.5);
    }

    public boolean applyEffectTick(@NotNull LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide() && entity.level() instanceof ServerLevel serverLevel) {
            BlockPos nearestStone = findNearestStone(serverLevel, entity.blockPosition());

            if (nearestStone != null) {
                teleportToTop(entity, nearestStone);
            }
            else {
                entity.sendSystemMessage(net.minecraft.network.chat.Component.literal("No Teleportation Stone found"));
            }
        }
        return true;
    }
}
