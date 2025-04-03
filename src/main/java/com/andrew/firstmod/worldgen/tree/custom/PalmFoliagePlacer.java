package com.andrew.firstmod.worldgen.tree.custom;

import com.andrew.firstmod.worldgen.tree.ModFoliagePlacers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            palmFoliagePlacerInstance -> foliagePlacerParts(palmFoliagePlacerInstance)
                   .apply(palmFoliagePlacerInstance, PalmFoliagePlacer::new));

    public PalmFoliagePlacer(IntProvider radius, IntProvider offset) {
        super(radius, offset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter foliageSetter,
                                 RandomSource random, TreeConfiguration config, int maxFreeTreeHeight,
                                 FoliageAttachment attachment, int foliageHeight, int foliageRadius, int offset) {

        BlockPos topPos = attachment.pos();

        // Create the top level foliage (+ symbol)
        this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(0, 0, 0), 0, 0, false);
        this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(-1, 0, 0), 0, 0, false);
        this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(1, 0, 0), 0, 0, false);
        this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(0, 0, -1), 0, 0, false);
        this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(0, 0, 1), 0, 0, false);

        // Create the bottom level foliage (5x5 square)
        this.placeLeavesRow(level, foliageSetter, random, config, topPos, 2, -1, false);

        // Attach two random extra blocks on each side and down
        int[] leavesSide1 = getTwoRandomLeavesPositions(random);
        int[] leavesSide2 = getTwoRandomLeavesPositions(random);
        int[] leavesSide3 = getTwoRandomLeavesPositions(random);
        int[] leavesSide4 = getTwoRandomLeavesPositions(random);

        for (int i = 0; i <= 1; i++) {
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(3, 0, leavesSide1[i]), 0, -1, false);
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(-3, 0, leavesSide2[i]), 0, -1, false);
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(leavesSide3[i], 0, 3), 0, -1, false);
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(leavesSide4[i], 0, -3), 0, -1, false);

            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(3, 0, leavesSide1[i]), 0, -2, false);
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(-3, 0, leavesSide2[i]), 0, -2, false);
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(leavesSide3[i], 0, 3), 0, -2, false);
            this.placeLeavesRow(level, foliageSetter, random, config, topPos.offset(leavesSide4[i], 0, -3), 0, -2, false);
        }
    }

    public static int[] getTwoRandomLeavesPositions(RandomSource random) {
        int[] values = {-2, -1, 0, 1, 2};

        int firstIndex = random.nextInt(values.length);
        int secondIndex;

        do {
            secondIndex = random.nextInt(values.length);
        } while (secondIndex == firstIndex); // Ensure distinct values

        return new int[]{values[firstIndex], values[secondIndex]};
    }

    @Override
    public int foliageHeight(RandomSource randomSource, int i, TreeConfiguration treeConfiguration) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource randomSource, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
