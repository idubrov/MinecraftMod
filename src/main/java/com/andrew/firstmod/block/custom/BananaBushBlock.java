package com.andrew.firstmod.block.custom;

import com.andrew.firstmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.CommonHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class BananaBushBlock extends SweetBerryBushBlock {
    private static final VoxelShape[] SHAPE_BY_AGE =
            new VoxelShape[]{
                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 16.0)};

    public BananaBushBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        // Do nothing, don't hurt anybody
    }

    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    // If hit any block of fully grown banana_bush with BONEMEAL,
    // it should behave as any other item (collect all crop),
    // otherwise apply bonemeal
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        int currentAge = state.getValue(AGE);
        BlockPos abovePos = pos.above();
        BlockPos aboveAbovePos = pos.above(2);
        BlockState aboveBlock = level.getBlockState(abovePos);
        BlockState aboveAboveBlock = level.getBlockState(aboveAbovePos);

        boolean fullyGrownFlag = ((currentAge == MAX_AGE) ||
                (currentAge == 2 && aboveBlock.is(this)) ||
                (currentAge == 0 && aboveAboveBlock.is(this)));

        return !fullyGrownFlag && stack.is(Items.BONE_MEAL) ? ItemInteractionResult.SKIP_DEFAULT_BLOCK_INTERACTION : ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        int currentAge = state.getValue(AGE);

        BlockPos abovePos = pos.above();
        BlockState aboveBlock = level.getBlockState(abovePos);
        BlockPos belowPos = pos.below();
        BlockState belowBlock = level.getBlockState(belowPos);

        int drops = (1 + level.random.nextInt(2)) * 2;

        if (currentAge == MAX_AGE) {
            popResource(level, pos, new ItemStack(ModItems.BANANA.get(), drops + 1));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            level.destroyBlock(pos, false);
            level.setBlock(belowPos, getStateForAge(1), 2);

            level.gameEvent(GameEvent.BLOCK_CHANGE, belowPos, GameEvent.Context.of(player, getStateForAge(1)));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (currentAge == 2 && aboveBlock.isAir()) {
            popResource(level, pos, new ItemStack(ModItems.BANANA.get(), drops));
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            level.setBlock(pos, getStateForAge(1), 2);

            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, getStateForAge(1)));
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else if (currentAge == 2 && aboveBlock.is(this)) {
            return this.useWithoutItem(aboveBlock, level, abovePos, player, hitResult);
        } else if (currentAge == 0 && aboveBlock.is(this)) {
            return this.useWithoutItem(aboveBlock, level, abovePos, player, hitResult);
        } else {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }

    @Override
    public ItemStack getCloneItemStack(LevelReader level, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.BANANA.get());
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        int currentAge = state.getValue(AGE);
        BlockPos abovePos = pos.above();
        BlockState aboveBlock = level.getBlockState(abovePos);

        if (currentAge >= MAX_AGE || level.getRawBrightness(pos.above(), 0) < 8) return;

        if (CommonHooks.canCropGrow(level, pos, state, random.nextInt(3) == 0)) {
            if (aboveBlock.isAir() && currentAge == 0) {
                level.setBlock(abovePos, getStateForAge(currentAge + 1), 3);
            } else if (currentAge == 1) {
                level.setBlock(pos, getStateForAge(currentAge + 1), 2);
            } else if (currentAge == 2 && aboveBlock.isAir()) {
                level.setBlock(abovePos, getStateForAge(currentAge + 1), 3);
            }
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        int currentAge = state.getValue(AGE);
        BlockPos belowPos = pos.below();
        BlockState belowBlock = level.getBlockState(belowPos);

        if (currentAge == 0) {
            // Bottom part must be on valid soil (use method from BushBlock)
            return super.canSurvive(state, level, pos);
        } else {
            // Top parts must be on another banana_bosh block
            return belowBlock.is(this);
        }
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int currentAge = state.getValue(AGE);
        BlockPos abovePos = pos.above();
        BlockState aboveBlock = level.getBlockState(abovePos);

        if (currentAge == 0 && aboveBlock.isAir()) {
            randomTick(state, level, pos, random);
        } else if (currentAge == 0 && aboveBlock.is(this)) {
            randomTick(aboveBlock, level, abovePos, random);
        } else if (currentAge == 1) {
            randomTick(state, level, pos, random);
        } else if (currentAge == 2 && aboveBlock.isAir()) {
            randomTick(state, level, pos, random);
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        BlockPos abovePos = pos.above();
        BlockPos aboveAbovePos = pos.above(2);
        BlockState aboveState = level.getBlockState(abovePos);
        BlockState aboveAboveState = level.getBlockState(aboveAbovePos);

        if (aboveAboveState.is(this)) level.destroyBlock(aboveAbovePos, false);
        if (aboveState.is(this)) level.destroyBlock(abovePos, false);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        int currentAge = state.getValue(AGE);
        BlockState aboveState = level.getBlockState(pos.above());
        BlockState aboveAboveState = level.getBlockState(pos.above(2));

        if ((currentAge >= MAX_AGE) ||
                (currentAge == 2 && aboveState.is(this)) ||
                (currentAge == 0 && aboveState.is(this) && aboveAboveState.is(this))) {
            return false;
        }

        return true; // Otherwise, bonemeal can be applied
    }
}
