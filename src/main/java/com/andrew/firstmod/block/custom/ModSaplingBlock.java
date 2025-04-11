package com.andrew.firstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Set;

public class ModSaplingBlock extends SaplingBlock {
    private final Set<Block> allowedBlocks;

    public ModSaplingBlock(TreeGrower treeGrower, Properties properties, Block... blocksToSurviveOn) {
        super(treeGrower, properties);
        this.allowedBlocks = Set.of(blocksToSurviveOn);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return allowedBlocks.contains(state.getBlock());
    }
}
