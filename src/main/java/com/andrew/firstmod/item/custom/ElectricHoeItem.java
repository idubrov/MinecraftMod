package com.andrew.firstmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;

import java.util.List;

public class ElectricHoeItem extends HoeItem {

    public ElectricHoeItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(material, attackDamage, attackSpeed, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);

        if (context.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        } else {
            Player player = context.getPlayer();

            // Get 2x2 area blocks to be tilled
            List<BlockPos> blocksToTill = ElectricTool.getBlocksToBeChangedHorizontally(blockpos, player);
            boolean tilled = false;

            for (BlockPos targetPos : blocksToTill) {
                BlockState targetState = level.getBlockState(targetPos);
                BlockPos abovePos = targetPos.above();
                BlockState aboveState = level.getBlockState(abovePos);

                // Check if the block has a valid tillable state and there's nothing growing above
                BlockState tilledState = targetState.getToolModifiedState(context, ItemAbilities.HOE_TILL, false);
                if (tilledState != null && aboveState.isAir()) {
                    if (!level.isClientSide) {
                        level.setBlock(targetPos, tilledState, 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, targetPos, GameEvent.Context.of(player, tilledState));
                        if (player != null) {
                            context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                        }
                    }
                    level.playSound(player, targetPos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                    tilled = true;
                }
            }

            return tilled ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
    }

}
