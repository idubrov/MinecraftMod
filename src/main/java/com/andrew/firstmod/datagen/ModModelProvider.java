package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;

import java.util.Collections;


public class ModModelProvider extends ModelProvider {

//    public ModModelProvider(PackOutput output) {
//        super(output, FirstMod.MOD_ID);
//    }

    public ModModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, FirstMod.MOD_ID);
    }

    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        blockModel(blockModels, ModBlocks.SULFUR_BLOCK.get());
        blockModel(blockModels, ModBlocks.SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.DEEPSLATE_SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.NETHER_SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.END_SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.PALM_WOOD.get());
        blockModel(blockModels, ModBlocks.PALM_LOG.get());
        blockModel(blockModels, ModBlocks.STRIPPED_PALM_WOOD.get());
        blockModel(blockModels, ModBlocks.STRIPPED_PALM_LOG.get());
        blockModel(blockModels, ModBlocks.PALM_PLANKS.get());
        blockModel(blockModels, ModBlocks.PALM_SLAB.get());
        blockModel(blockModels, ModBlocks.PALM_STAIRS.get());
        blockModel(blockModels, ModBlocks.PALM_PRESSURE_PLATE.get());
        blockModel(blockModels, ModBlocks.PALM_BUTTON.get());
        blockModel(blockModels, ModBlocks.PALM_FENCE.get());
        blockModel(blockModels, ModBlocks.PALM_FENCE_GATE.get());
        blockModel(blockModels, ModBlocks.PALM_DOOR.get());
        blockModel(blockModels, ModBlocks.PALM_TRAPDOOR.get());
        blockModel(blockModels, ModBlocks.PALM_LEAVES.get());
        blockModel(blockModels, ModBlocks.DRY_PALM_LEAVES_BLOCK.get());
        blockModel(blockModels, ModBlocks.DRY_PALM_LEAVES_SLAB.get());
        blockModel(blockModels, ModBlocks.DRY_PALM_LEAVES_CARPET.get());
        blockModel(blockModels, ModBlocks.PALM_SAPLING.get());
        blockModel(blockModels, ModBlocks.POTTED_PALM_SAPLING.get());
        blockModel(blockModels, ModBlocks.COCONUT_LAMP.get());
        blockModel(blockModels, ModBlocks.RICE_CROP.get());
        blockModel(blockModels, ModBlocks.BANANA_BUSH.get());
        blockModel(blockModels, ModBlocks.RICE_PUDDING.get());
        blockModel(blockModels, ModBlocks.TELEPORTATION_STONE.get());


        itemModel(itemModels, ModItems.SULFUR_POWDER.get());
        itemModel(itemModels, ModItems.SULFUR_SHARD.get());
        itemModel(itemModels, ModItems.COCONUT.get());
        itemModel(itemModels, ModItems.BANANA.get());
        itemModel(itemModels, ModItems.MILK_SHAKE.get());
        itemModel(itemModels, ModItems.FRUIT_SALAD.get());
        itemModel(itemModels, ModItems.MAKI_SUSHI.get());
        itemModel(itemModels, ModItems.NIGIRI_SUSHI.get());
        itemModel(itemModels, ModItems.RICE_SEEDS.get());
        itemModel(itemModels, ModItems.RICE_STEM.get());
        itemModel(itemModels, ModItems.BATTERY.get());
        itemModel(itemModels, ModItems.TELEPORTATION_DEVICE.get());


        itemModel(itemModels, ModItems.ELECTRIC_HELMET.get());
        itemModel(itemModels, ModItems.ELECTRIC_CHESTPLATE.get());
        itemModel(itemModels, ModItems.ELECTRIC_LEGGINGS.get());
        itemModel(itemModels, ModItems.ELECTRIC_BOOTS.get());
        itemModel(itemModels, ModItems.ELECTRIC_HORSE_ARMOR.get());


        toolModel(itemModels, ModItems.ELECTRIC_PICKAXE.get());
        toolModel(itemModels, ModItems.ELECTRIC_AXE.get());
        toolModel(itemModels, ModItems.ELECTRIC_SHOVEL.get());
        toolModel(itemModels, ModItems.ELECTRIC_HOE.get());
        toolModel(itemModels, ModItems.WOODEN_HAMMER.get());
        toolModel(itemModels, ModItems.STONE_HAMMER.get());
        toolModel(itemModels, ModItems.GOLDEN_HAMMER.get());
        toolModel(itemModels, ModItems.IRON_HAMMER.get());
        toolModel(itemModels, ModItems.DIAMOND_HAMMER.get());


    }


    public void blockModel(BlockModelGenerators blockModels, Block block)
    {
        blockModels.createTrivialCube(block);
    }

    public void itemModel(ItemModelGenerators itemModels, Item item)
    {
        this.itemModel(itemModels, item, ModelTemplates.FLAT_ITEM);
    }

    public void toolModel(ItemModelGenerators itemModels, Item item)
    {
        this.itemModel(itemModels, item, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    public void itemModel(ItemModelGenerators itemModels, Item item, ModelTemplate template)
    {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        ResourceLocation textureLoc = ResourceLocation.fromNamespaceAndPath(itemId.getNamespace(), "item/" + itemId.getPath());
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.LAYER0, textureLoc);
        itemModels.itemModelOutput.accept(item, new BlockModelWrapper.Unbaked(template.create(item, textureMapping,
                itemModels.modelOutput), Collections.emptyList()));
    }

    public void armorModel(ItemModelGenerators itemModels, Item item) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String armorType = "";
        if (id.getPath().contains("helmet"))
            armorType = "helmet";
        else if (id.getPath().contains("chestplate"))
            armorType = "chestplate";
        else if (id.getPath().contains("leggings"))
            armorType = "leggings";
        else if (id.getPath().contains("boots"))
            armorType = "boots";
//        itemModels.generateTrimmableItem(item, equipmentKey,
//                ResourceLocation.withDefaultNamespace("trims/items/" + armorType + "_trim"), false);
    }
}