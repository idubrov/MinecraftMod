package com.andrew.firstmod.datagen;

import com.andrew.firstmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.BATTERY.getId(), new FurnaceFuel(3200), false);

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
                .add(ModItems.RICE_SEEDS.getId(), new Compostable(0.5f), false)
                .add(ModItems.RICE_STEM.getId(), new Compostable(0.75f), false);
    }
}
