package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {

    public ModAdvancementProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
        super(packOutput, provider, List.of(new ModAdvancements()));
    }

    private static class ModAdvancements implements AdvancementSubProvider  {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {

            AdvancementHolder plantSeeds = Advancement.Builder.advancement()
                    .parent(AdvancementSubProvider.createPlaceholder("minecraft:husbandry/root"))
                    .display(
                            ModItems.RICE_SEEDS, // You can replace this with your custom seed item
                            Component.translatable("advancements.husbandry.plant_seed.title"),
                            Component.translatable("advancements.husbandry.plant_seed.description"),
                            null,
                            AdvancementType.TASK,
                            true, true, false
                    )
                    .addCriterion("planted_rice_crop", ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(ModBlocks.RICE_CROP.get()))
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "husbandry/plant_seed")));
        }
    }
}
