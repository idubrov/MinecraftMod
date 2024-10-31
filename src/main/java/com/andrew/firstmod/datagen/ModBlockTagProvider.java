package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // FirstMod tags
        tag(ModTags.Blocks.SULFUR_BLOCKS)
                .add(ModBlocks.SULFUR_ORE.get())
                .add(ModBlocks.DEEPSLATE_SULFUR_ORE.get())
                .add(ModBlocks.SULFUR_BLOCK.get());

        tag(ModTags.Blocks.SULFUR_ORES_BLOCKS)
                .add(ModBlocks.SULFUR_ORE.get())
                .add(ModBlocks.DEEPSLATE_SULFUR_ORE.get());

        tag(ModTags.Blocks.PALM_LOGS_BLOCKS)
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get())
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get());


        // Minecraft tags
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SULFUR_BLOCK.get())
                .add(ModBlocks.SULFUR_ORE.get())
                .add(ModBlocks.DEEPSLATE_SULFUR_ORE.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get())
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.PALM_PLANKS.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.PALM_LEAVES.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SULFUR_BLOCK.get())
                .add(ModBlocks.SULFUR_ORE.get())
                .add(ModBlocks.DEEPSLATE_SULFUR_ORE.get());

        tag(BlockTags.LEAVES)
                .add(ModBlocks.PALM_LEAVES.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get())
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get());

        tag(BlockTags.PLANKS)
                .add(ModBlocks.PALM_PLANKS.get());
        tag(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.PALM_SLAB.get());
        tag(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.PALM_STAIRS.get());
        tag(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.PALM_DOOR.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.PALM_FENCE_GATE.get());
        tag(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALM_BUTTON.get());
        tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALM_PRESSURE_PLATE.get());
        tag(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PALM_TRAPDOOR.get());

        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.PALM_SAPLING.get());
        tag(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_PALM_SAPLING.get());
    }
}
