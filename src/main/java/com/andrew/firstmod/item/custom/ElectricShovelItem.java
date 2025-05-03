package com.andrew.firstmod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;

import java.util.List;

public class ElectricShovelItem extends ShovelItem {

    public ElectricShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties properties) {
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

            // Get 2x2 area blocks to be modified
            List<BlockPos> blocksToModify = ElectricTool.getBlocksToBeChangedHorizontally(blockpos, player);

            BlockState blockstate1 = blockstate.getToolModifiedState(context, ItemAbilities.SHOVEL_FLATTEN, false);
            BlockState blockstate2 = null;
            boolean modified = false;

            // Iterate over each block in the 2x2 area
            for (BlockPos targetPos : blocksToModify) {
                BlockState targetState = level.getBlockState(targetPos);

                if (blockstate1 != null && level.getBlockState(targetPos.above()).isAir()) {
                    level.playSound(player, targetPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    blockstate2 = blockstate1;
                    modified = true;
                } else if ((blockstate2 = targetState.getToolModifiedState(context, ItemAbilities.SHOVEL_DOUSE, false)) != null && !level.isClientSide()) {
                    level.levelEvent((Player) null, 1009, targetPos, 0);
                    modified = true;
                }

                if (blockstate2 != null) {
                    if (!level.isClientSide) {
                        level.setBlock(targetPos, blockstate2, 11);
                        level.gameEvent(GameEvent.BLOCK_CHANGE, targetPos, GameEvent.Context.of(player, blockstate2));
                        if (player != null) {
                            context.getItemInHand().hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                        }
                    }
                }
            }

            return modified ? InteractionResult.SUCCESS : InteractionResult.PASS;
        }
    }
}
