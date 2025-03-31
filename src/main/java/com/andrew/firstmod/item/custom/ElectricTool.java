package com.andrew.firstmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class ElectricTool {

    // Gets 2x2 blocks in horizontal plane for shovel and hoe (right-click useOn method)
    public static List<BlockPos> getBlocksToBeChangedHorizontally(BlockPos pos, Player player) {
        List<BlockPos> positions = new ArrayList<>();
        Level level = player.level(); // Get the player's world
        BlockState initialState = level.getBlockState(pos); // Get the initial block state

        // Define candidate positions (2x2 area)
        BlockPos[] candidates = {pos, pos.east(), pos.south(), pos.south().east()};

        // Choose only the same type of blocks as initial
        for (BlockPos candidate : candidates) {
            if (level.getBlockState(candidate).is(initialState.getBlock())) {
                positions.add(candidate);
            }
        }

        return positions;
    }

    // Gets 2x2 blocks in the direction of mining (left-click)
    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initialBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        Level level = player.level(); // Get the player's world
        BlockState initialState = level.getBlockState(initialBlockPos); // Get the initial block state


        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if(traceResult.getType() == HitResult.Type.MISS) {
            return positions;
        }

        if(traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
            for(int x = 0; x < range; x++) {
                for(int y = 0; y < range; y++) {
                    BlockPos targetPos = new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY(), initialBlockPos.getZ() + y);

                    if (level.getBlockState(targetPos).is(initialState.getBlock())) {
                        positions.add(targetPos);
                    }
                }
            }
        }

        if(traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
            for(int x = 0; x < range; x++) {
                for(int y = 0; y < range; y++) {
                    BlockPos targetPos = new BlockPos(initialBlockPos.getX() + x, initialBlockPos.getY() + y, initialBlockPos.getZ());

                    if (level.getBlockState(targetPos).is(initialState.getBlock())) {
                        positions.add(targetPos);
                    }
                }
            }
        }

        if(traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
            for(int x = 0; x < range; x++) {
                for(int y = 0; y < range; y++) {
                    BlockPos targetPos = new BlockPos(initialBlockPos.getX(), initialBlockPos.getY() + y, initialBlockPos.getZ() + x);
                    if (level.getBlockState(targetPos).is(initialState.getBlock())) {
                        positions.add(targetPos);
                    }
                }
            }
        }

        return positions;
    }
}