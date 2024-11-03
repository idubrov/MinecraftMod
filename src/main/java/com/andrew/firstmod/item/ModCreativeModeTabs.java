package com.andrew.firstmod.item;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);


    public static final Supplier<CreativeModeTab> TROPICS_ITEMS_TAB = CREATIVE_MODE_TAB.register("tropics_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BANANA.get()))
                    .title(Component.translatable("creativetab.firstmod.tropics_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModBlocks.PALM_LOG);
                        output.accept(ModBlocks.PALM_WOOD);
                        output.accept(ModBlocks.STRIPPED_PALM_LOG);
                        output.accept(ModBlocks.STRIPPED_PALM_WOOD);
                        output.accept(ModBlocks.PALM_PLANKS);
                        output.accept(ModBlocks.PALM_STAIRS);
                        output.accept(ModBlocks.PALM_SLAB);
                        output.accept(ModBlocks.PALM_FENCE);
                        output.accept(ModBlocks.PALM_FENCE_GATE);
                        output.accept(ModBlocks.PALM_DOOR);
                        output.accept(ModBlocks.PALM_TRAPDOOR);
                        output.accept(ModBlocks.PALM_PRESSURE_PLATE);
                        output.accept(ModBlocks.PALM_BUTTON);

                        output.accept(ModBlocks.SULFUR_ORE);
                        output.accept(ModBlocks.DEEPSLATE_SULFUR_ORE);
                        output.accept(ModItems.SULFUR_SHARD);
                        output.accept(ModBlocks.SULFUR_BLOCK);
                        output.accept(ModItems.SULFUR_POWDER);

                        output.accept(ModBlocks.PALM_LEAVES);
                        output.accept(ModBlocks.DRY_PALM_LEAVES_BLOCK);
                        output.accept(ModBlocks.DRY_PALM_LEAVES_SLAB);
                        output.accept(ModBlocks.DRY_PALM_LEAVES_CARPET);
                        output.accept(ModBlocks.PALM_SAPLING);

                        output.accept(ModItems.BANANA);
                        output.accept(ModItems.COCONUT);
                        output.accept(ModItems.MILK_SHAKE);
                        output.accept(ModItems.FRUIT_SALAD);

                        output.accept(ModItems.BATTERY);
                        output.accept(ModBlocks.COCONUT_LAMP);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
