package com.andrew.firstmod.worldgen.tree;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PALMWOOD = new TreeGrower(FirstMod.MOD_ID + ":palmwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PALMWOOD_KEY), Optional.empty());
}
