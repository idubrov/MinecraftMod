package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.util.ModEquipmentAssets;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplate;

import java.util.*;
import java.util.stream.Stream;

import static com.andrew.firstmod.block.ModBlocks.BLOCKS;
import static net.minecraft.client.data.models.BlockModelGenerators.createSimpleBlock;
import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ModModelProvider extends ModelProvider {

    public ModModelProvider(PackOutput packOutput) {
        super(packOutput, FirstMod.MOD_ID);
    }

    // We create those models / blockstates manually
    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        var blocks = new ArrayList<>(BLOCKS.getEntries());

        blocks.remove(ModBlocks.DRY_PALM_LEAVES_BLOCK);
        blocks.remove(ModBlocks.DRY_PALM_LEAVES_SLAB);
        blocks.remove(ModBlocks.COCONUT_LAMP);
        blocks.remove(ModBlocks.RICE_PUDDING);

        return blocks.stream();
    }


    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

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


        toolModel(itemModels, ModItems.ELECTRIC_PICKAXE.get());
        toolModel(itemModels, ModItems.ELECTRIC_AXE.get());
        toolModel(itemModels, ModItems.ELECTRIC_SHOVEL.get());
        toolModel(itemModels, ModItems.ELECTRIC_HOE.get());
        toolModel(itemModels, ModItems.WOODEN_HAMMER.get());
        toolModel(itemModels, ModItems.STONE_HAMMER.get());
        toolModel(itemModels, ModItems.GOLDEN_HAMMER.get());
        toolModel(itemModels, ModItems.IRON_HAMMER.get());
        toolModel(itemModels, ModItems.DIAMOND_HAMMER.get());


        armorModel(itemModels, ModItems.ELECTRIC_HELMET.get(), ModEquipmentAssets.ELECTRIC);
        armorModel(itemModels, ModItems.ELECTRIC_CHESTPLATE.get(), ModEquipmentAssets.ELECTRIC);
        armorModel(itemModels, ModItems.ELECTRIC_LEGGINGS.get(), ModEquipmentAssets.ELECTRIC);
        armorModel(itemModels, ModItems.ELECTRIC_BOOTS.get(), ModEquipmentAssets.ELECTRIC);
        itemModel(itemModels, ModItems.ELECTRIC_HORSE_ARMOR.get());

        blockModel(blockModels, ModBlocks.SULFUR_BLOCK.get());
        blockModel(blockModels, ModBlocks.SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.DEEPSLATE_SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.NETHER_SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.END_SULFUR_ORE.get());
        blockModel(blockModels, ModBlocks.PALM_PLANKS.get());


        blockModels.woodProvider(ModBlocks.PALM_LOG.get())
                .logWithHorizontal(ModBlocks.PALM_LOG.get())
                .wood(ModBlocks.PALM_WOOD.get());
        blockModels.woodProvider(ModBlocks.STRIPPED_PALM_LOG.get())
                .logWithHorizontal(ModBlocks.STRIPPED_PALM_LOG.get())
                .wood(ModBlocks.STRIPPED_PALM_WOOD.get());


        slabBlock(blockModels, ModBlocks.PALM_SLAB.get());
        stairsBlock(blockModels, ModBlocks.PALM_STAIRS.get());
        pressurePlateBlock(blockModels, ModBlocks.PALM_PRESSURE_PLATE.get());
        fenceBlock(blockModels, ModBlocks.PALM_FENCE.get());
        fenceGateBlock(blockModels, ModBlocks.PALM_FENCE_GATE.get());
        buttonBlock(blockModels, ModBlocks.PALM_BUTTON.get());
        doorBlock(blockModels, ModBlocks.PALM_DOOR.get());
        trapdoorBlock(blockModels, ModBlocks.PALM_TRAPDOOR.get());


        blockModels.createTrivialBlock(ModBlocks.PALM_LEAVES.get(), TexturedModel.LEAVES);

        carpetBlock(blockModels, ModBlocks.DRY_PALM_LEAVES_CARPET.get());

        saplingBlock(blockModels, ModBlocks.PALM_SAPLING.get(), ModBlocks.POTTED_PALM_SAPLING.get());

        riceCropBlock(blockModels, ModBlocks.RICE_CROP.get());
        bananaBushBlock(blockModels, ModBlocks.BANANA_BUSH.get());

        blockModels.createRotatedPillarWithHorizontalVariant(ModBlocks.TELEPORTATION_STONE.get(),
                TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
    }


    public void blockModel(BlockModelGenerators blockModels, Block block) {
        blockModels.createTrivialCube(block);
    }

    public void itemModel(ItemModelGenerators itemModels, Item item) {
        this.itemModel(itemModels, item, ModelTemplates.FLAT_ITEM);
    }

    public void toolModel(ItemModelGenerators itemModels, Item item) {
        this.itemModel(itemModels, item, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    public void itemModel(ItemModelGenerators itemModels, Item item, ModelTemplate template) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        ResourceLocation textureLoc = ResourceLocation.fromNamespaceAndPath(itemId.getNamespace(), "item/" + itemId.getPath());
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.LAYER0, textureLoc);
        itemModels.itemModelOutput.accept(item, new BlockModelWrapper.Unbaked(template.create(item, textureMapping,
                itemModels.modelOutput), Collections.emptyList()));
    }

    public void armorModel(ItemModelGenerators itemModels, Item item, ResourceKey<EquipmentAsset> equipmentKey) {
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
        itemModels.generateTrimmableItem(item, equipmentKey,
                ResourceLocation.withDefaultNamespace("trims/items/" + armorType + "_trim"), false);
    }


    public void slabBlock(BlockModelGenerators blockModels, Block slab) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(slab));
        String parent = id.getPath().replace("_slab", "_planks");
        ResourceLocation parentTexture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + parent);

        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.BOTTOM, parentTexture).put(TextureSlot.TOP, parentTexture).put(TextureSlot.SIDE, parentTexture);
        MultiVariant slabBottomModel = plainVariant(ModelTemplates.SLAB_BOTTOM.create(slab, textureMapping, blockModels.modelOutput));
        MultiVariant slabTopModel = plainVariant(ModelTemplates.SLAB_TOP.create(slab, textureMapping, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createSlab(slab, slabBottomModel, slabTopModel, plainVariant(parentTexture)));

        blockModels.itemModelOutput.accept(slab.asItem(), new BlockModelWrapper.Unbaked(this.blockStateLocation(id), Collections.emptyList()));
    }

    public void stairsBlock(BlockModelGenerators blockModels, Block stairs) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(stairs));
        String parent = id.getPath().replace("_stairs", "_planks");
        ResourceLocation parentTexture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + parent);

        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.BOTTOM, parentTexture).put(TextureSlot.SIDE, parentTexture).put(TextureSlot.TOP, parentTexture);
        MultiVariant stairsInnerModel = plainVariant(ModelTemplates.STAIRS_INNER.create(stairs, textureMapping, blockModels.modelOutput));
        ResourceLocation stairsStraightModelLoc = ModelTemplates.STAIRS_STRAIGHT.create(stairs, textureMapping, blockModels.modelOutput);
        MultiVariant stairsStraightModel = plainVariant(stairsStraightModelLoc);
        MultiVariant stairsOuterModel = plainVariant(ModelTemplates.STAIRS_OUTER.create(stairs, textureMapping, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createStairs(stairs, stairsInnerModel, stairsStraightModel, stairsOuterModel));

        blockModels.itemModelOutput.accept(stairs.asItem(), new BlockModelWrapper.Unbaked(stairsStraightModelLoc, Collections.emptyList()));
    }

    public void pressurePlateBlock(BlockModelGenerators blockModels, Block pressurePlate) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(pressurePlate));
        String parent = id.getPath().replace("_pressure_plate", "_planks");
        ResourceLocation parentTexture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + parent);

        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.TEXTURE, parentTexture);
        MultiVariant plateModelUp = plainVariant(ModelTemplates.PRESSURE_PLATE_UP.create(pressurePlate, textureMapping, blockModels.modelOutput));
        MultiVariant plateModelDown = plainVariant(ModelTemplates.PRESSURE_PLATE_DOWN.create(pressurePlate, textureMapping, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createPressurePlate(pressurePlate, plateModelUp, plateModelDown));

        blockModels.itemModelOutput.accept(pressurePlate.asItem(), new BlockModelWrapper.Unbaked(this.blockStateLocation(id), Collections.emptyList()));
    }

    public void fenceBlock(BlockModelGenerators blockModels, Block fence) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(fence));
        String parent = id.getPath().replace("_fence", "_planks");
        ResourceLocation parentTexture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + parent);

        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.TEXTURE, parentTexture);
        MultiVariant fencePostModel = plainVariant(ModelTemplates.FENCE_POST.create(fence, textureMapping, blockModels.modelOutput));
        MultiVariant fenceSideModel = plainVariant(ModelTemplates.FENCE_SIDE.create(fence, textureMapping, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createFence(fence, fencePostModel, fenceSideModel));

        ResourceLocation fenceInventoryModel = ModelTemplates.FENCE_INVENTORY.create(fence, textureMapping, blockModels.modelOutput);
        blockModels.itemModelOutput.accept(fence.asItem(), new BlockModelWrapper.Unbaked(fenceInventoryModel, Collections.emptyList()));
    }

    public void fenceGateBlock(BlockModelGenerators blockModels, Block fenceGate) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(fenceGate));
        String parent = id.getPath().replace("_fence_gate", "_planks");
        ResourceLocation parentTexture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + parent);

        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.TEXTURE, parentTexture);
        MultiVariant fenceGateModelOpen = plainVariant(ModelTemplates.FENCE_GATE_OPEN.create(fenceGate, textureMapping, blockModels.modelOutput));
        MultiVariant fenceGateModelClosed = plainVariant(ModelTemplates.FENCE_GATE_CLOSED.create(fenceGate, textureMapping, blockModels.modelOutput));
        MultiVariant fenceGateWallModelOpen = plainVariant(ModelTemplates.FENCE_GATE_WALL_OPEN.create(fenceGate, textureMapping, blockModels.modelOutput));
        MultiVariant fenceGateWallModelClosed = plainVariant(ModelTemplates.FENCE_GATE_WALL_CLOSED.create(fenceGate, textureMapping, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createFenceGate(fenceGate, fenceGateModelOpen, fenceGateModelClosed, fenceGateWallModelOpen, fenceGateWallModelClosed, true));

        blockModels.itemModelOutput.accept(fenceGate.asItem(), new BlockModelWrapper.Unbaked(this.blockStateLocation(id), Collections.emptyList()));
    }

    public void buttonBlock(BlockModelGenerators blockModels, Block button) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(button));
        String parent = id.getPath().replace("_button", "_planks");
        ResourceLocation parentTexture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + parent);

        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.TEXTURE, parentTexture);
        MultiVariant buttonModel = plainVariant(ModelTemplates.BUTTON.create(button, textureMapping, blockModels.modelOutput));
        MultiVariant buttonPressedModel = plainVariant(ModelTemplates.BUTTON_PRESSED.create(button, textureMapping, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(BlockModelGenerators.createButton(button, buttonModel, buttonPressedModel));

        ResourceLocation buttonInventoryModel = ModelTemplates.BUTTON_INVENTORY.create(button, textureMapping, blockModels.modelOutput);
        blockModels.itemModelOutput.accept(button.asItem(), new BlockModelWrapper.Unbaked(buttonInventoryModel, Collections.emptyList()));
    }


    public void doorBlock(BlockModelGenerators blockModels, Block door) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(door));
        ResourceLocation texture_top = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + id.getPath() + "_top");
        ResourceLocation texture_bottom = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + id.getPath() + "_bottom");

        TextureMapping textureMapping = TextureMapping.door(door)
                .put(TextureSlot.BOTTOM, texture_bottom).put(TextureSlot.TOP, texture_top);

        MultiVariant bottomLeft = plainVariant(ModelTemplates.DOOR_BOTTOM_LEFT
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant bottomLeftOpen = plainVariant(ModelTemplates.DOOR_BOTTOM_LEFT_OPEN
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant bottomRight = plainVariant(ModelTemplates.DOOR_BOTTOM_RIGHT
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant bottomRightOpen = plainVariant(ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant topLeft = plainVariant(ModelTemplates.DOOR_TOP_LEFT
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant topLeftOpen = plainVariant(ModelTemplates.DOOR_TOP_LEFT_OPEN
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant topRight = plainVariant(ModelTemplates.DOOR_TOP_RIGHT
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));
        MultiVariant topRightOpen = plainVariant(ModelTemplates.DOOR_TOP_RIGHT_OPEN
                .extend().renderType("cutout").build().create(door, textureMapping, blockModels.modelOutput));

        blockModels.blockStateOutput.accept(BlockModelGenerators.createDoor(
                door, bottomLeft, bottomLeftOpen, bottomRight, bottomRightOpen,
                topLeft, topLeftOpen, topRight, topRightOpen));

        blockModels.registerSimpleFlatItemModel(door.asItem());
    }

    public void trapdoorBlock(BlockModelGenerators blockModels, Block trapdoor) {
        ResourceLocation id = Objects.requireNonNull(BuiltInRegistries.BLOCK.getKey(trapdoor));
        ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + id.getPath());
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.TEXTURE, texture);

        ExtendedModelTemplate bottom = ModelTemplates.TRAPDOOR_BOTTOM.extend().renderType("cutout").build();
        ExtendedModelTemplate top = ModelTemplates.TRAPDOOR_TOP.extend().renderType("cutout").build();
        ExtendedModelTemplate open = ModelTemplates.TRAPDOOR_OPEN.extend().renderType("cutout").build();


        ResourceLocation bottomModelId = bottom.create(trapdoor, textureMapping, blockModels.modelOutput);

        MultiVariant bottomVariant = plainVariant(bottomModelId);
        MultiVariant topVariant = plainVariant(top.create(trapdoor, textureMapping, blockModels.modelOutput));
        MultiVariant openVariant = plainVariant(open.create(trapdoor, textureMapping, blockModels.modelOutput));


        blockModels.blockStateOutput.accept(BlockModelGenerators.createOrientableTrapdoor(
                trapdoor, topVariant, bottomVariant, openVariant));

        blockModels.itemModelOutput.accept(trapdoor.asItem(), new BlockModelWrapper.Unbaked(bottomModelId, Collections.emptyList()));
    }


    public void carpetBlock(BlockModelGenerators blockModels, Block carpetBlock) {
        MultiVariant multivariant = plainVariant(TexturedModel.CARPET.get(carpetBlock).create(carpetBlock, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(carpetBlock, multivariant));
    }



    public void bananaBushBlock(BlockModelGenerators blockModels, Block bananaBushBlock) {
        ExtendedModelTemplate crossWithCutout = ModelTemplates.CROSS.extend().renderType("cutout").build();

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(bananaBushBlock).with(
                        PropertyDispatch.initial(BlockStateProperties.AGE_3)
                                .generate(age -> {
                                    // Get model ID with suffix using withPath()
                                    ResourceLocation modelId = BuiltInRegistries.BLOCK
                                            .getKey(bananaBushBlock)
                                            .withPath(path -> "block/" + path + "_stage" + age);

                                    // Use the modelId as both the model and texture base
                                    TextureMapping texture = TextureMapping.cross(modelId);

                                    return BlockModelGenerators.plainVariant(
                                            crossWithCutout.create(modelId, texture, blockModels.modelOutput)
                                    );
                                })
                )
        );
    }


    public void riceCropBlock(BlockModelGenerators blockModels, Block riceCropBlock) {

        ExtendedModelTemplate cropWithCutout = ModelTemplates.CROP.extend().renderType("cutout").build();

        ResourceLocation[] nowaterModels = new ResourceLocation[6];
        ResourceLocation[] waterModels = new ResourceLocation[6];
        TextureMapping[] texture = new TextureMapping[6];

        ResourceLocation baseId = BuiltInRegistries.BLOCK.getKey(riceCropBlock);

        for (int i = 0; i <= 5; i++) {
            int finalI = i;
            nowaterModels[i] = baseId.withPath(path -> "block/" + path + "_nowater_stage" + finalI);
            waterModels[i] = baseId.withPath(path -> "block/" + path + "_water_stage" + finalI);
            texture[i] = TextureMapping.crop(baseId.withPath(path -> "block/" + path + "_stage" + finalI));
        }

        blockModels.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(riceCropBlock)
                                .with(
                                        PropertyDispatch.initial(BlockStateProperties.AGE_5, BlockStateProperties.WATERLOGGED)
                                                .select(0, false, BlockModelGenerators.plainVariant(cropWithCutout.create(nowaterModels[0], texture[0], blockModels.modelOutput)))
                                                .select(1, false, BlockModelGenerators.plainVariant(cropWithCutout.create(nowaterModels[1], texture[1], blockModels.modelOutput)))
                                                .select(2, false, BlockModelGenerators.plainVariant(cropWithCutout.create(nowaterModels[2], texture[2], blockModels.modelOutput)))
                                                .select(3, false, BlockModelGenerators.plainVariant(cropWithCutout.create(nowaterModels[3], texture[3], blockModels.modelOutput)))
                                                .select(4, false, BlockModelGenerators.plainVariant(cropWithCutout.create(nowaterModels[4], texture[4], blockModels.modelOutput)))
                                                .select(5, false, BlockModelGenerators.plainVariant(cropWithCutout.create(nowaterModels[5], texture[5], blockModels.modelOutput)))

                                                .select(0, true, BlockModelGenerators.plainVariant(cropWithCutout.create(waterModels[0], texture[0], blockModels.modelOutput)))
                                                .select(1, true, BlockModelGenerators.plainVariant(cropWithCutout.create(waterModels[1], texture[1], blockModels.modelOutput)))
                                                .select(2, true, BlockModelGenerators.plainVariant(cropWithCutout.create(waterModels[2], texture[2], blockModels.modelOutput)))
                                                .select(3, true, BlockModelGenerators.plainVariant(cropWithCutout.create(waterModels[3], texture[3], blockModels.modelOutput)))
                                                .select(4, true, BlockModelGenerators.plainVariant(cropWithCutout.create(waterModels[4], texture[4], blockModels.modelOutput)))
                                                .select(5, true, BlockModelGenerators.plainVariant(cropWithCutout.create(waterModels[5], texture[5], blockModels.modelOutput)))

                                )
                );
    }


    public void saplingBlock(BlockModelGenerators blockModels, Block sapling, Block pottedSapling) {
        // Define cutout versions of cross and flower pot templates
        ExtendedModelTemplate crossWithCutout = ModelTemplates.CROSS.extend().renderType("cutout").build();
        ExtendedModelTemplate potWithCutout = ModelTemplates.FLOWER_POT_CROSS.extend().renderType("cutout").build();


        TextureMapping textureMapping1 = TextureMapping.cross(sapling);
        MultiVariant multivariant1 = plainVariant(crossWithCutout.create(sapling, textureMapping1, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(sapling, multivariant1));

        // Create the potted variant
        TextureMapping textureMapping2 = BlockModelGenerators.PlantType.NOT_TINTED.getPlantTextureMapping(sapling);
        MultiVariant multivariant2 = plainVariant(potWithCutout.create(pottedSapling, textureMapping2, blockModels.modelOutput));
        blockModels.blockStateOutput.accept(createSimpleBlock(pottedSapling, multivariant2));

        blockModels.registerSimpleFlatItemModel(sapling);
    }



    private ResourceLocation blockStateLocation(ResourceLocation id) {
        return ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "block/" + id.getPath());
    }
}