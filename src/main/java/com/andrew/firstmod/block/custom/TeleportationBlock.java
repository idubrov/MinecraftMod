package com.andrew.firstmod.block.custom;

import com.andrew.firstmod.particle.ModParticlesTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

public class TeleportationBlock extends RotatedPillarBlock {
    public TeleportationBlock(Properties properties) {
        super(properties);
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
            level.addParticle(ModParticlesTypes.TELEPORTATION_PARTICLES.get(), d0, d1, d2, d3, d4, d5);
        }
    }
}
