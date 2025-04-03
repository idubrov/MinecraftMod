package com.andrew.firstmod.worldgen.tree.custom;

import com.andrew.firstmod.worldgen.tree.ModTrunkPlacerTypes;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            palmTrunkPlacerInstance -> trunkPlacerParts(palmTrunkPlacerInstance)
                    .apply(palmTrunkPlacerInstance, PalmTrunkPlacer::new));

    public PalmTrunkPlacer(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.PALM_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter,
                                                            RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        setDirtAt(level, blockSetter, random, pos.below(), config);

        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        // First block
        this.placeLog(level, blockSetter, random, blockpos$mutableblockpos, config);

        // Choose a random bend direction (North, South, East, West)
        int bendDirection = random.nextInt(4);
        int dx = 0, dz = 0;
        switch (bendDirection) {
            case 0 -> dx = 1;  // East
            case 1 -> dx = -1; // West
            case 2 -> dz = 1;  // South
            case 3 -> dz = -1; // North
        }

        // Place the bending trunk with random direction
        for (int i = 0; i < freeTreeHeight; i++) {

            int direction = random.nextInt(3); // 0 = 45 degree, 1 = vertical, 2 = horizontal
            switch (direction) {
                case 0 -> blockpos$mutableblockpos.move(dx, 1, dz);         // 45-degree angle in chosen bend direction
                case 1 -> blockpos$mutableblockpos.move(0, 1, 0);     // Vertical
                case 2 -> blockpos$mutableblockpos.move(dx, 0, dz);         // Horizontal in chosen bend direction
            }

            this.placeLog(level, blockSetter, random, blockpos$mutableblockpos, config);
        }

        // Last block vertically
        blockpos$mutableblockpos.move(0, 1, 0);
        this.placeLog(level, blockSetter, random, blockpos$mutableblockpos, config);

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(blockpos$mutableblockpos.immutable(), 0, false));
    }
}
