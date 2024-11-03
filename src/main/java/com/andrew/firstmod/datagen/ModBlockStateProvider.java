package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.block.custom.CoconutLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SULFUR_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SULFUR_ORE);
        blockWithItem(ModBlocks.SULFUR_BLOCK);


        blockWithItem(ModBlocks.PALM_PLANKS);

        logBlock((RotatedPillarBlock) ModBlocks.PALM_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PALM_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.PALM_WOOD.get(),
                blockTexture(ModBlocks.PALM_LOG.get()), blockTexture(ModBlocks.PALM_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PALM_WOOD.get(),
                blockTexture(ModBlocks.STRIPPED_PALM_LOG.get()), blockTexture(ModBlocks.STRIPPED_PALM_LOG.get()));

        stairsBlock(ModBlocks.PALM_STAIRS.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        slabBlock(ModBlocks.PALM_SLAB.get(), blockTexture(ModBlocks.PALM_PLANKS.get()),
                blockTexture(ModBlocks.PALM_PLANKS.get()));
        buttonBlock(ModBlocks.PALM_BUTTON.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        pressurePlateBlock(ModBlocks.PALM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        fenceBlock(ModBlocks.PALM_FENCE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        fenceGateBlock(ModBlocks.PALM_FENCE_GATE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
        doorBlockWithRenderType(ModBlocks.PALM_DOOR.get(), modLoc("block/palm_door_bottom"),
                modLoc("block/palm_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PALM_TRAPDOOR.get(),
                modLoc("block/palm_trapdoor"), true, "cutout");


        simpleBlockWithItem(ModBlocks.PALM_LEAVES.get(), models().leaves(ModBlocks.PALM_LEAVES.getRegisteredName(),
                blockTexture(ModBlocks.PALM_LEAVES.get())));
        simpleBlockWithItem(ModBlocks.DRY_PALM_LEAVES_CARPET.get(), models().carpet(ModBlocks.DRY_PALM_LEAVES_CARPET.getRegisteredName(),
                modLoc("block/dry_palm_leaves_top")));
        // DRY_PALM_LEAVES_SLAB and DRY_PALM_LEAVES_BLOCK models and blockstates created manually

        simpleBlock(ModBlocks.PALM_SAPLING.get(), models().cross(ModBlocks.PALM_SAPLING.getRegisteredName(),
                blockTexture(ModBlocks.PALM_SAPLING.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_PALM_SAPLING.get(),
                models().singleTexture("potted_palm_tree", mcLoc("flower_pot_cross"), "plant",
                        blockTexture(ModBlocks.PALM_SAPLING.get())).renderType("cutout"));


        blockItem(ModBlocks.PALM_LOG);
        blockItem(ModBlocks.STRIPPED_PALM_LOG);
        blockItem(ModBlocks.PALM_WOOD);
        blockItem(ModBlocks.STRIPPED_PALM_WOOD);
        blockItem(ModBlocks.PALM_STAIRS);
        blockItem(ModBlocks.PALM_SLAB);
        blockItem(ModBlocks.PALM_PRESSURE_PLATE);
        blockItem(ModBlocks.PALM_FENCE_GATE);
        blockItem(ModBlocks.PALM_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("firstmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("firstmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}