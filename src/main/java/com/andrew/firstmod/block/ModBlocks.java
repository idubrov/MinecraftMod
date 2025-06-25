package com.andrew.firstmod.block;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.custom.*;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(FirstMod.MOD_ID);


    public static final DeferredBlock<Block> SULFUR_BLOCK = registerBlock("sulfur_block",
            () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "sulfur_block")))));

    public static final DeferredBlock<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            () -> new SulfurOreBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "sulfur_ore")))));

    public static final DeferredBlock<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            () -> new SulfurOreBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "deepslate_sulfur_ore")))));

    public static final DeferredBlock<Block> NETHER_SULFUR_ORE = registerBlock("nether_sulfur_ore",
            () -> new SulfurOreBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "nether_sulfur_ore")))));

    public static final DeferredBlock<Block> END_SULFUR_ORE = registerBlock("end_sulfur_ore",
            () -> new SulfurOreBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "end_sulfur_ore")))));



    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_wood")))));

    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_log")))));

    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "stripped_palm_wood")))));

    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "stripped_palm_log")))));

    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new ModFlammableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_planks")))));



    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_slab")))));

    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(ModBlocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)
                            .setId(ResourceKey.create(Registries.BLOCK,
                                    ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_stairs")))));

    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PRESSURE_PLATE)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_pressure_plate")))));

    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockSetType.ACACIA, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_BUTTON)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_button")))));

    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_fence")))));

    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_fence_gate")))));

    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_DOOR).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_door")))));

    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_TRAPDOOR).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_trapdoor")))));



    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new ModFlammableLeavesBlock(0.01F, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_leaves")))));

    public static final DeferredBlock<Block> DRY_PALM_LEAVES_BLOCK = registerBlock("dry_palm_leaves_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "dry_palm_leaves_block")))));

    public static final DeferredBlock<SlabBlock> DRY_PALM_LEAVES_SLAB = registerBlock("dry_palm_leaves_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "dry_palm_leaves_slab")))));

    public static final DeferredBlock<Block> DRY_PALM_LEAVES_CARPET = registerBlock("dry_palm_leaves_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "dry_palm_leaves_carpet")))));



    public static final DeferredBlock<ModSaplingBlock> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.PALMWOOD, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SAPLING).noCollission()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "palm_sapling"))),
                    Blocks.DIRT, Blocks.SAND, Blocks.GRASS_BLOCK));

    public static final DeferredBlock<FlowerPotBlock> POTTED_PALM_SAPLING = registerBlock("potted_palm_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),
                    ModBlocks.PALM_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "potted_palm_sapling")))));



    public static final DeferredBlock<Block> COCONUT_LAMP = registerBlock("coconut_lamp",
            () -> new CoconutLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH)
                    .lightLevel(state -> state.getValue(CoconutLampBlock.COCONUT_LAMP_CLICKED) ? 10 : 0)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "coconut_lamp")))));



    public static final DeferredBlock<Block> RICE_CROP = BLOCKS.register("rice_crop",
            () -> new RiceCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "rice_crop")))));



    public static final DeferredBlock<Block> BANANA_BUSH = BLOCKS.register("banana_bush",
            () -> new BananaBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "banana_bush")))));



    public static final DeferredBlock<Block> RICE_PUDDING = registerBlock("rice_pudding",
            () -> new RicePuddingBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "rice_pudding")))), 1);



    public static final DeferredBlock<Block> TELEPORTATION_STONE = registerBlock("teleportation_stone",
            () -> new TeleportationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.LODESTONE)
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "teleportation_stone")))));


    public static final DeferredBlock<Block> CHARGING_STATION = registerBlock("charging_station",
            () -> new ChargingStationBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)
                    .noOcclusion()
                    .setId(ResourceKey.create(Registries.BLOCK,
                            ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "charging_station")))));



    //Registering of our new blocks and its item
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block, int stacksTo) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, stacksTo);
        return toReturn;
    }

    //Registering item from the block
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name)))));
    }

    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, int stacksTo) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().stacksTo(stacksTo)
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
