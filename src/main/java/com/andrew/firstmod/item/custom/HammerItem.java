package com.andrew.firstmod.item.custom;

import com.andrew.firstmod.block.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;


public class HammerItem extends Item {
    private static final Map<Block,Block> HAMMER_MAP =
            Map.of(
                    Blocks.STONE, Blocks.GRAVEL,
                    Blocks.DEEPSLATE, Blocks.GRAVEL,
                    ModBlocks.SULFUR_ORE.get(), Blocks.GRAVEL
            );
    public HammerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context){
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(HAMMER_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), HAMMER_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.AMETHYST_BLOCK_BREAK, SoundSource.BLOCKS);
            }

        }


        return InteractionResult.SUCCESS;
    }


}
