package com.andrew.firstmod.block.custom;

import com.andrew.firstmod.item.custom.HammerItem;
import com.andrew.firstmod.particle.ModParticlesTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SulfurOreBlock extends DropExperienceBlock {
    public SulfurOreBlock(IntProvider xpRange, Properties properties) {
        super(xpRange, properties);
    }

    @Override
    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack tool) {
       if (tool.getItem() instanceof HammerItem) return UniformInt.of(2, 5).sample(level.getRandom());
       else return ConstantInt.of(0).sample(level.getRandom());
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().hotFloor(), 1.0F);
        }

        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        for (int i = 0; i < 3; i++) {
            int j = random.nextInt(2) * 2 - 1;
            int k = random.nextInt(2) * 2 - 1;
            double d0 = (double) pos.getX() + 0.5 + 0.25 * (double) j;
            double d1 = (float) pos.getY() + random.nextFloat();
            double d2 = (double) pos.getZ() + 0.5 + 0.25 * (double) k;
            double d3 = (double) (random.nextFloat() * (float) j) * 0.03;
            double d4 = ((double) random.nextFloat() - 0.5) * 0.08;
            double d5 = (double) (random.nextFloat() * (float) k) * 0.03;
            level.addParticle(ModParticlesTypes.SULFUR_PARTICLES.get(), d0, d1, d2, d3, d4, d5);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.sulfur_ore.tooltip"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
