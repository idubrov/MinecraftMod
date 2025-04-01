package com.andrew.firstmod.event;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.data.TeleportationStoneData;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.event.level.ExplosionEvent;
import net.neoforged.neoforge.event.level.LevelEvent;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@EventBusSubscriber(modid = FirstMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class TeleportationStoneTracker {

    // Stores positions of all placed Teleportation Stones (accessible to all players)
    private static final HashSet<BlockPos> teleportationStones = new HashSet<>();


    @SubscribeEvent
    public static void onWorldLoad(LevelEvent.Load event) {
        if (!(event.getLevel() instanceof ServerLevel serverLevel)) return;

        // Load saved Teleportation Stones into memory
        TeleportationStoneData data = TeleportationStoneData.get(serverLevel);
        TeleportationStoneTracker.teleportationStones.addAll(data.getStoredPositions());
    }


    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        BlockState placedBlock = event.getPlacedBlock();
        BlockPos pos = event.getPos();

        // Check if the placed block is the custom Teleportation Stone
        if (placedBlock.is(ModBlocks.TELEPORTATION_STONE)) {
            teleportationStones.add(pos);

            // Save position in persistent storage
            if (event.getLevel() instanceof ServerLevel serverLevel) {
                TeleportationStoneData data = TeleportationStoneData.get(serverLevel);
                data.addStone(pos);
            }

//            if (event.getEntity() instanceof Player player) {
//                player.sendSystemMessage(net.minecraft.network.chat.Component.literal("Teleportation Stone placed at: " + pos));
//            }
        }
    }


    @SubscribeEvent
    public static void onBlockBroken(BlockEvent.BreakEvent event) {
        BlockPos pos = event.getPos();
        BlockState blockState = event.getState();

        // Remove from tracking if a Teleportation Stone is broken
        if (blockState.is(ModBlocks.TELEPORTATION_STONE)) {
            teleportationStones.remove(pos);

            // Remove from persistent storage
            if (event.getLevel() instanceof ServerLevel serverLevel) {
                TeleportationStoneData data = TeleportationStoneData.get(serverLevel);
                data.removeStone(pos);
            }

//            event.getPlayer()
//                    .sendSystemMessage(net.minecraft.network.chat.Component.literal("Teleportation Stone removed from: " + pos));
        }
    }

    @SubscribeEvent
    public static void onExplosionDetonate(ExplosionEvent.Detonate event) {
        if (event.getLevel() instanceof ServerLevel serverLevel) {
            List<BlockPos> affectedBlocks = event.getAffectedBlocks();

            for (BlockPos pos : new ArrayList<>(affectedBlocks)) {  // Avoid concurrent modification
                if (serverLevel.getBlockState(pos).is(ModBlocks.TELEPORTATION_STONE.get())) {
                    // Remove from tracking
                    TeleportationStoneData.get(serverLevel).removeStone(pos);

                    // Manually break the block
                    serverLevel.destroyBlock(pos, true);

                    // Remove from affected blocks
                    affectedBlocks.remove(pos);
                }
            }
        }
    }
}
