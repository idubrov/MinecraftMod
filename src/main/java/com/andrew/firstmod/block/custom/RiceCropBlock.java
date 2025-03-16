package com.andrew.firstmod.block.custom;

import com.andrew.firstmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


//   System.out.println("current age: "+ currentAge);

public class RiceCropBlock extends CropBlock {

    public static final BooleanProperty WATERLOGGED = BooleanProperty.create("waterlogged");

    public static final int BOTTOM_PART_MAX_AGE = 2;    // stage0, stage1, stage2
    public static final int TOTAL_MAX_AGE = 5;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 5);

    private static final VoxelShape[] SHAPE_BY_AGE =
            new VoxelShape[]{
                    Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};

    public RiceCropBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, true));
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return ModItems.RICE_SEEDS;
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return TOTAL_MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        builder.add(WATERLOGGED);
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.defaultFluidState() : super.getFluidState(state);
    }

    // Where to place seeds
    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter world, BlockPos pos) {

        BlockPos abovePos = pos.above();
        BlockPos aboveAbovePos = pos.above(2);

        FluidState aboveFluid = world.getFluidState(abovePos);
        BlockState aboveAboveBlock = world.getBlockState(aboveAbovePos);

        return state.is(Blocks.FARMLAND) &&
                aboveFluid.isSourceOfType(Fluids.WATER) && aboveFluid.getAmount() == 8 && // Full water block
                aboveAboveBlock.isAir();
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {

        if (!hasSufficientLight(level, pos)) return false;

        int currentAge = state.getValue(AGE);

        BlockPos belowPos = pos.below();
        BlockPos abovePos = pos.above();
        BlockState belowBlock = level.getBlockState(belowPos);
        BlockState aboveBlock = level.getBlockState(abovePos);

        if (currentAge <= BOTTOM_PART_MAX_AGE) {
            // Bottom part must be on valid soil

            boolean isOnFarmland = belowBlock.is(Blocks.FARMLAND);
            boolean isInOneBlockDeepWater = level.getFluidState(pos).is(Fluids.WATER) && level.getFluidState(pos).getAmount() == 8;
            boolean isAirAbove = aboveBlock.isAir();

            return isOnFarmland && isInOneBlockDeepWater && (isAirAbove || aboveBlock.is(this));

        } else {
            // Top part must have a mature bottom part
            return belowBlock.is(this) && belowBlock.getValue(AGE) == BOTTOM_PART_MAX_AGE;
        }
    }


    // This is natural growth with time one by one stage
    public void randomTick(BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {

        int currentAge = state.getValue(AGE);

        // Already fully grown or too dark, do nothing
        if (currentAge >= TOTAL_MAX_AGE || !hasSufficientLight(level, pos)) return;

        // Try to grow the crop - 1/3 chance to grow
        if (random.nextInt(3) == 0) {

            int nextAge = Math.min(currentAge + 1, TOTAL_MAX_AGE);

            // Grow the bottom part first
            if (currentAge < BOTTOM_PART_MAX_AGE) {
                level.setBlock(pos, getStateForAge(nextAge), 2);
            }

            // If the bottom reaches its max, create the top part
            else if ((currentAge == BOTTOM_PART_MAX_AGE) && (level.getBlockState(pos.above()).isAir())) {
                level.setBlock(pos.above(), getStateForAge(nextAge).setValue(WATERLOGGED, false), 3);
            }

            // Grow top part (it already exists)
            else if (currentAge > BOTTOM_PART_MAX_AGE) {
                level.setBlock(pos, getStateForAge(nextAge).setValue(WATERLOGGED, false), 2);
            }
        }
    }


    // This is forced growth with Bonemeal (random growth from 2 to 5 stages)
    @Override
    public void growCrops(@NotNull Level level, @NotNull BlockPos pos, BlockState state) {

        int currentAge = state.getValue(AGE);
        // Already fully grown or too dark, do nothing
        if (currentAge >= TOTAL_MAX_AGE || !hasSufficientLight(level, pos)) return;

        int numberOfStages = getBonemealAgeIncrease(level);
        int nextAge = Math.min(currentAge + numberOfStages, TOTAL_MAX_AGE);

        //Bonemeal applied to small bottom
        //Grow bottom and if necessary and possible - grow top
        if (currentAge < BOTTOM_PART_MAX_AGE) {
            if (nextAge <= BOTTOM_PART_MAX_AGE) {
                level.setBlock(pos, getStateForAge(nextAge), 2);
            } else if (level.getBlockState(pos.above()).isAir()) {
                level.setBlock(pos, getStateForAge(BOTTOM_PART_MAX_AGE), 2);
                level.setBlock(pos.above(), getStateForAge(nextAge).setValue(WATERLOGGED, false), 3);
            }
        }

        // Bonemeal applied to fully grown bottom
        // Create the top part and grow it to requested stage
        else if ((currentAge == BOTTOM_PART_MAX_AGE) && (level.getBlockState(pos.above()).isAir())) {
            level.setBlock(pos.above(), getStateForAge(nextAge).setValue(WATERLOGGED, false), 3);
        }

        // Bonemeal applied to the top - just grow top
        else if (currentAge > BOTTOM_PART_MAX_AGE) {
            level.setBlock(pos, getStateForAge(nextAge).setValue(WATERLOGGED, false), 2);
        }
    }


    @Override
    public void performBonemeal(ServerLevel level, @NotNull RandomSource random, BlockPos pos, BlockState state) {

        int currentAge = state.getValue(AGE);
        BlockState aboveState = level.getBlockState(pos.above());

        if ((currentAge == BOTTOM_PART_MAX_AGE) && (level.getBlockState(pos.above()).is(this))) {
            super.performBonemeal(level, random, pos.above(), aboveState);
        } else {
            super.performBonemeal(level, random, pos, state);
        }
    }

    @Override
    public void playerDestroy(@NotNull Level level, @NotNull Player player, @NotNull BlockPos pos,
                              @NotNull BlockState state, @Nullable BlockEntity blockEntity, @NotNull ItemStack tool) {

        int age = state.getValue(AGE);
        BlockPos otherHalf = (age > BOTTOM_PART_MAX_AGE) ? pos.below() : pos.above();

        // If the other half is still there, break it too
        if (level.getBlockState(otherHalf).is(this)) {
            level.destroyBlock(otherHalf, false);
        }

        // Continue with normal block breaking behavior
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
    }


    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pos, BlockState state) {
        int currentAge = state.getValue(AGE);

        // If the crop is fully grown, bonemeal should not work
        if (currentAge >= TOTAL_MAX_AGE) {
            return false;
        }

        // If this is the bottom part and the top part exists AND is fully grown, don't allow bonemeal
        if (currentAge <= BOTTOM_PART_MAX_AGE) {
            BlockState aboveState = level.getBlockState(pos.above());
            if (aboveState.is(this) && aboveState.getValue(AGE) >= TOTAL_MAX_AGE) {
                return false;
            }
        }
        return true; // Otherwise, bonemeal can be applied
    }
}
