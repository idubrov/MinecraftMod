package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        // FirstMod tags

        tag(ModTags.Items.SULFUR_ITEMS)
                .add(ModItems.SULFUR_SHARD.get())
                .add(ModItems.SULFUR_POWDER.get())
                .add(ModBlocks.SULFUR_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_SULFUR_ORE.asItem())
                .add(ModBlocks.NETHER_SULFUR_ORE.asItem())
                .add(ModBlocks.END_SULFUR_ORE.asItem())
                .add(ModBlocks.SULFUR_BLOCK.asItem());

        tag(ModTags.Items.SULFUR_ORES_ITEMS)
                .add(ModBlocks.SULFUR_ORE.asItem())
                .add(ModBlocks.DEEPSLATE_SULFUR_ORE.asItem())
                .add(ModBlocks.NETHER_SULFUR_ORE.asItem())
                .add(ModBlocks.END_SULFUR_ORE.asItem());

        tag(ModTags.Items.PALM_LOGS_ITEMS)
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem())
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem());

        tag(ModTags.Items.HAMMERS_ITEMS)
                .add(ModItems.WOODEN_HAMMER.get())
                .add(ModItems.STONE_HAMMER.get())
                .add(ModItems.IRON_HAMMER.get())
                .add(ModItems.GOLDEN_HAMMER.get())
                .add(ModItems.DIAMOND_HAMMER.get());

        // Minecraft tags

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ELECTRIC_HELMET.get())
                .add(ModItems.ELECTRIC_CHESTPLATE.get())
                .add(ModItems.ELECTRIC_LEGGINGS.get())
                .add(ModItems.ELECTRIC_BOOTS.get());

        tag(ItemTags.LEAVES)
                .add(ModBlocks.PALM_LEAVES.asItem());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem())
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.PALM_PLANKS.asItem());
        tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.PALM_SLAB.asItem());
        tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.PALM_STAIRS.asItem());
        tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.PALM_DOOR.asItem());
        tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE.asItem());
        tag(ItemTags.FENCE_GATES)
                .add(ModBlocks.PALM_FENCE_GATE.asItem());
        tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALM_BUTTON.asItem());
        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALM_PRESSURE_PLATE.asItem());
        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PALM_TRAPDOOR.asItem());

        tag(ItemTags.SAPLINGS)
                .add(ModBlocks.PALM_SAPLING.asItem());

        tag(ItemTags.PICKAXES)
                .add(ModItems.ELECTRIC_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.ELECTRIC_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.ELECTRIC_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.ELECTRIC_HOE.get());


        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.ELECTRIC_CHESTPLATE.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.ELECTRIC_BOOTS.get());
        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.ELECTRIC_HELMET.get());
        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.ELECTRIC_LEGGINGS.get());


        tag(ItemTags.CHEST_BOATS)
                .add(ModItems.PALM_CHEST_BOAT.get());
        tag(ItemTags.BOATS)
                .add(ModItems.PALM_BOAT.get())
                .add(ModItems.PALM_ELECTRIC_BOAT.get());
    }
}
