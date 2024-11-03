package com.andrew.firstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class CoconutLampBlock extends Block {
    public static final BooleanProperty COCONUT_LAMP_CLICKED = BooleanProperty.create("coconut_lamp_clicked");
    private static final VoxelShape SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 8.0, 12.0);

    public CoconutLampBlock(Properties properties) {
        super(properties);
    this.registerDefaultState(this.defaultBlockState().setValue(COCONUT_LAMP_CLICKED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide()) {
            boolean currentState = state.getValue(COCONUT_LAMP_CLICKED);
            level.setBlockAndUpdate(pos, state.setValue(COCONUT_LAMP_CLICKED, !currentState));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(COCONUT_LAMP_CLICKED);
    }

   @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    //TODO Doesn't work
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return !level.isEmptyBlock(pos.below());
    }
}