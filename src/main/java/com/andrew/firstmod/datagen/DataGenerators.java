package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = FirstMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();

        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new ModRecipeProvider.Runner(packOutput, lookupProvider));
        //event.addProvider(new ModModelProvider(packOutput, FirstMod.MOD_ID));

        event.addProvider(ModLootTableProvider.create(packOutput, lookupProvider));

        ModBlockTagProvider blockTagGenerator = event.addProvider(
                new ModBlockTagProvider(packOutput, lookupProvider));

        event.addProvider(new ModItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter()));

        event.addProvider(new ModDataMapProvider(packOutput, lookupProvider));

        event.addProvider(new ModWorldGenProvider(packOutput, lookupProvider));

        event.addProvider(new ModGlobalLootModifierProvider(packOutput, lookupProvider));
    }
}
