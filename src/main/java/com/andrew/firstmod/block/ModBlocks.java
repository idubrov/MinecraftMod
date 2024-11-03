package com.andrew.firstmod.block;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.custom.CoconutLampBlock;
import com.andrew.firstmod.block.custom.SulfurOreBlock;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(FirstMod.MOD_ID);


    public static final DeferredBlock<Block> SULFUR_BLOCK = registerBlock("sulfur_block",
            () -> new Block(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_BLOCK)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            () -> new SulfurOreBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.GOLD_ORE)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            () -> new SulfurOreBlock(UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)
                            .lightLevel(state -> 10)
                            .requiresCorrectToolForDrops()));


    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD)));
    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LOG)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_ACACIA_LOG)));
    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS)));


    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SLAB)));
    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(ModBlocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_STAIRS)));

    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockSetType.ACACIA, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_BUTTON)));

    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE)));
    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_TRAPDOOR)));

    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_LEAVES)));
    public static final DeferredBlock<Block> DRY_PALM_LEAVES_BLOCK = registerBlock("dry_palm_leaves_block",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<SlabBlock> DRY_PALM_LEAVES_SLAB = registerBlock("dry_palm_leaves_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));
    public static final DeferredBlock<Block> DRY_PALM_LEAVES_CARPET = registerBlock("dry_palm_leaves_carpet",
            () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.HAY_BLOCK)));


    public static final DeferredBlock<SaplingBlock> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new SaplingBlock(TreeGrower.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SAPLING)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_PALM_SAPLING = registerBlock("potted_palm_sapling",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.PALM_SAPLING, BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ACACIA_SAPLING).noOcclusion()));

    public static final DeferredBlock<Block> COCONUT_LAMP = registerBlock("coconut_lamp",
        () -> new CoconutLampBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.TORCH)
                .lightLevel(state -> state.getValue(CoconutLampBlock.COCONUT_LAMP_CLICKED) ? 10 : 0)));

    //Registering of our new blocks and its items
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //Registering item from the block
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
