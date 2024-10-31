package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Objects;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.COCONUT.get());
        basicItem(ModItems.BANANA.get());
        basicItem(ModItems.FRUIT_SALAD.get());
        basicItem(ModItems.MILK_SHAKE.get());
        basicItem(ModItems.SULFUR_POWDER.get());
        basicItem(ModItems.SULFUR_SHARD.get());
        basicItem(ModItems.BATTERY.get());

        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);

        basicItem(ModBlocks.PALM_DOOR.asItem());
        saplingItem(ModBlocks.PALM_SAPLING);
    }


    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void saplingItem(DeferredBlock<?> block) {
        this.withExistingParent(block.getId().getPath(), mcLoc("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID,
                        "block/" + block.getId().getPath()));
    }
}
