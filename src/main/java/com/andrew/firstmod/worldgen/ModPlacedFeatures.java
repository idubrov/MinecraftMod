package com.andrew.firstmod.worldgen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> SULFUR_ORE_PLACED_KEY = registerKey("sulfur_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SULFUR_ORE_PLACED_KEY = registerKey("nether_sulfur_ore_placed");
    public static final ResourceKey<PlacedFeature> END_SULFUR_ORE_PLACED_KEY = registerKey("end_sulfur_ore_placed");

    public static final ResourceKey<PlacedFeature> PALMWOOD_PLACED_MORE_KEY = registerKey("palmwood_placed_more");
    public static final ResourceKey<PlacedFeature> PALMWOOD_PLACED_LESS_KEY = registerKey("palmwood_placed_less");
    public static final ResourceKey<PlacedFeature> PALMWOOD_PLACED_RARE_KEY = registerKey("palmwood_placed_rare");

    public static final ResourceKey<PlacedFeature> BANANA_BUSH_PLACED_KEY = registerKey("banana_bush_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SULFUR_ORE_KEY),
                ModOrePlacement.rareOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-32))));
        register(context, NETHER_SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_SULFUR_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SULFUR_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));



        register(context, PALMWOOD_PLACED_MORE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALMWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.2f, 2),
                        ModBlocks.PALM_SAPLING.get()));

        register(context, PALMWOOD_PLACED_LESS_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALMWOOD_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 1),
                        ModBlocks.PALM_SAPLING.get()));

        register(context, PALMWOOD_PLACED_RARE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALMWOOD_KEY),
                List.of(RarityFilter.onAverageOnceEvery(64), // 1 tree every ~64 chunks
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome(),
                        PlacementUtils.filteredByBlockSurvival(ModBlocks.PALM_SAPLING.get()))); // uses your sapling survival rules



        register(context, BANANA_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BANANA_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(32), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

