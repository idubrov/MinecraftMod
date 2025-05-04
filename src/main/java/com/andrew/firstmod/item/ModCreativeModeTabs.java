package com.andrew.firstmod.item;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.potion.ModPotions;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);


    public static final Supplier<CreativeModeTab> ITEMS_TAB1 = CREATIVE_MODE_TAB.register("electric_bananas_items_tab1",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BANANA.get()))
                    .title(Component.translatable("creativetab.firstmod.electric_bananas_items_tab1"))
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
                        output.accept(ModBlocks.NETHER_SULFUR_ORE);
                        output.accept(ModBlocks.END_SULFUR_ORE);
                        output.accept(ModItems.SULFUR_SHARD);
                        output.accept(ModBlocks.SULFUR_BLOCK);
                        output.accept(ModItems.SULFUR_POWDER);

                        output.accept(ModBlocks.PALM_LEAVES);
                        output.accept(ModBlocks.DRY_PALM_LEAVES_BLOCK);
                        output.accept(ModBlocks.DRY_PALM_LEAVES_SLAB);
                        output.accept(ModBlocks.DRY_PALM_LEAVES_CARPET);
                        output.accept(ModBlocks.PALM_SAPLING);

                        output.accept(ModItems.COCONUT);
                        output.accept(ModBlocks.COCONUT_LAMP);

                        output.accept(ModItems.RICE_SEEDS);
                        output.accept(ModItems.RICE_STEM);

                        output.accept(ModItems.BANANA);
                        output.accept(ModItems.MILK_SHAKE);
                        output.accept(ModItems.FRUIT_SALAD);
                        output.accept(ModItems.MAKI_SUSHI);
                        output.accept(ModItems.NIGIRI_SUSHI);
                        output.accept(ModBlocks.RICE_PUDDING);
                    }).build());

    public static final Supplier<CreativeModeTab> ITEMS_TAB2 = CREATIVE_MODE_TAB.register("electric_bananas_items_tab2",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.BATTERY.get()))
                    .title(Component.translatable("creativetab.firstmod.electric_bananas_items_tab2"))
                    .displayItems((itemDisplayParameters, output) -> {

                        output.accept(ModItems.BATTERY);

                        output.accept(ModItems.ELECTRIC_PICKAXE);
                        output.accept(ModItems.ELECTRIC_SHOVEL);
                        output.accept(ModItems.ELECTRIC_AXE);
                        output.accept(ModItems.ELECTRIC_HOE);

                        output.accept(ModItems.WOODEN_HAMMER);
                        output.accept(ModItems.STONE_HAMMER);
                        output.accept(ModItems.GOLDEN_HAMMER);
                        output.accept(ModItems.IRON_HAMMER);
                        output.accept(ModItems.DIAMOND_HAMMER);

                        output.accept(ModItems.ELECTRIC_HELMET);
                        output.accept(ModItems.ELECTRIC_CHESTPLATE);
                        output.accept(ModItems.ELECTRIC_LEGGINGS);
                        output.accept(ModItems.ELECTRIC_BOOTS);

                        output.accept(ModItems.ELECTRIC_HORSE_ARMOR);

                        output.accept(PotionContents.createItemStack(Items.POTION, ModPotions.ELECTRIFIED_POTION));
                        output.accept(PotionContents.createItemStack(Items.SPLASH_POTION, ModPotions.ELECTRIFIED_POTION));
                        output.accept(PotionContents.createItemStack(Items.LINGERING_POTION, ModPotions.ELECTRIFIED_POTION));
                        output.accept(PotionContents.createItemStack(Items.TIPPED_ARROW, ModPotions.ELECTRIFIED_POTION));

                        output.accept(ModBlocks.TELEPORTATION_STONE);
                        output.accept(ModItems.TELEPORTATION_DEVICE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
