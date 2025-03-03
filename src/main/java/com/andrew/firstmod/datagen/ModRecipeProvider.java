package com.andrew.firstmod.datagen;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> SULFUR_SMELTABLES = List.of(
                ModItems.SULFUR_SHARD,
                ModBlocks.SULFUR_ORE,
                ModBlocks.DEEPSLATE_SULFUR_ORE);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SULFUR_BLOCK.get(), 1)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SULFUR_SHARD.get())
                .unlockedBy("has_sulfur_shard", has(ModItems.SULFUR_SHARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_WOOD.get(), 3)
                .group("bark")
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.PALM_LOG.get())
                .unlockedBy("has_palm_log", has(ModBlocks.PALM_LOG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STRIPPED_PALM_WOOD.get(), 3)
                .group("bark")
                .pattern("##")
                .pattern("##")
                .define('#', ModBlocks.STRIPPED_PALM_LOG.get())
                .unlockedBy("has_stripped_palm_log", has(ModBlocks.STRIPPED_PALM_LOG))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_SLAB.get(), 6)
                .group("wooden_slab")
                .pattern("###")
                .define('#', ModBlocks.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_STAIRS.get(), 4)
                .group("wooden_stairs")
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.PALM_PLANKS.get())
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRY_PALM_LEAVES_BLOCK.get(), 1)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("LLL")
                .define('L', ModBlocks.PALM_LEAVES.get())
                .unlockedBy("has_palm_leaves", has(ModBlocks.PALM_LEAVES))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRY_PALM_LEAVES_SLAB.get(), 1)
                .pattern("LLL")
                .pattern("LLL")
                .pattern("   ")
                .define('L', ModBlocks.PALM_LEAVES.get())
                .unlockedBy("has_palm_leaves", has(ModBlocks.PALM_LEAVES))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRY_PALM_LEAVES_CARPET.get(), 1)
                .pattern("LLL")
                .pattern("   ")
                .pattern("   ")
                .define('L', ModBlocks.PALM_LEAVES.get())
                .unlockedBy("has_palm_leaves", has(ModBlocks.PALM_LEAVES))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.MILK_SHAKE.get(), 3)
                .pattern("M  ")
                .pattern("BBB")
                .pattern("   ")
                .define('M', Items.MILK_BUCKET)
                .define('B', ModItems.BANANA.get())
                .unlockedBy("has_banana", has(ModItems.BANANA))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BATTERY.get(), 3)
                .pattern("III")
                .pattern("SSS")
                .pattern("CCC")
                .define('I', Items.IRON_INGOT)
                .define('S', ModItems.SULFUR_POWDER.get())
                .define('C', Items.COPPER_INGOT)
                .unlockedBy("has_sulfur_powder", has(ModItems.SULFUR_POWDER))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.COCONUT_LAMP.get(), 1)
                .pattern("   ")
                .pattern("ACA")
                .pattern("   ")
                .define('A', Items.CANDLE)
                .define('C', ModItems.COCONUT.get())
                .unlockedBy("has_coconut", has(ModItems.COCONUT))
                .unlockedBy("has_candle", has(Items.CANDLE))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SULFUR_SHARD.get(), 9)
                .requires(ModBlocks.SULFUR_BLOCK)
                .unlockedBy("has_sulfur", has(ModBlocks.SULFUR_BLOCK)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_PLANKS.get(), 4)
                .group("planks")
                .requires(ModTags.Items.PALM_LOGS_ITEMS)
                .unlockedBy("has_palm_logs", has(ModTags.Items.PALM_LOGS_ITEMS)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.FRUIT_SALAD.get(), 1)
                .requires(ModItems.BANANA)
                .requires(ModItems.COCONUT)
                .requires(Items.APPLE)
                .requires(Items.MELON_SLICE)
                .requires(Items.BOWL)
                .unlockedBy("has_banana", has(ModItems.BANANA))
                .unlockedBy("has_coconut", has(ModItems.COCONUT))
                .unlockedBy("has_apple", has(Items.APPLE))
                .unlockedBy("has_melon_slice", has(Items.MELON_SLICE))
                .unlockedBy("has_bowl", has(Items.BOWL))
                .save(recipeOutput);


        oreSmelting(recipeOutput, SULFUR_SMELTABLES, RecipeCategory.MISC, ModItems.SULFUR_POWDER.get(), 0.5f, 100, "sulfur");
        oreBlasting(recipeOutput, SULFUR_SMELTABLES, RecipeCategory.MISC, ModItems.SULFUR_POWDER.get(), 0.7f, 80, "sulfur");


        buttonBuilder(ModBlocks.PALM_BUTTON.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("wooden_button")
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.PALM_PRESSURE_PLATE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("wooden_pressure_plate")
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        fenceBuilder(ModBlocks.PALM_FENCE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("wooden_fence")
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.PALM_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("wooden_fence_gate")
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        doorBuilder(ModBlocks.PALM_DOOR.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("wooden_door")
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PALM_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("wooden_trapdoor")
                .unlockedBy("has_palm_planks", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.WOODEN_HAMMER.get(), 1)
                .pattern(" WW")
                .pattern(" SW")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('W', ItemTags.PLANKS)
                .unlockedBy("has_sticks", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.STONE_HAMMER.get(), 1)
                .pattern(" WW")
                .pattern(" SW")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('W', Items.COBBLESTONE)
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_HAMMER.get(), 1)
                .pattern(" WW")
                .pattern(" SW")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('W', Items.GOLD_INGOT)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_HAMMER.get(), 1)
                .pattern(" WW")
                .pattern(" SW")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('W', Items.IRON_INGOT)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_HAMMER.get(), 1)
                .pattern(" WW")
                .pattern(" SW")
                .pattern("S  ")
                .define('S', Items.STICK)
                .define('W', Items.DIAMOND)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .save(recipeOutput);



        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_PICKAXE.get(), 1)
                .pattern("IBI")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_AXE.get(), 1)
                .pattern("BI ")
                .pattern("IS ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_SHOVEL.get(), 1)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('B', ModItems.BATTERY)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_HOE.get(), 1)
                .pattern("IB ")
                .pattern(" S ")
                .pattern(" S ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_HELMET.get(), 1)
                .pattern("BNB")
                .pattern("I I")
                .pattern("   ")
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .define('N', Items.NETHERITE_HELMET)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_CHESTPLATE.get(), 1)
                .pattern("B B")
                .pattern("INI")
                .pattern("IBI")
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .define('N', Items.NETHERITE_CHESTPLATE)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_LEGGINGS.get(), 1)
                .pattern("BNB")
                .pattern("I I")
                .pattern("I I")
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .define('N', Items.NETHERITE_LEGGINGS)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ELECTRIC_BOOTS.get(), 1)
                .pattern("   ")
                .pattern("BNB")
                .pattern("I I")
                .define('I', Items.IRON_INGOT)
                .define('B', ModItems.BATTERY)
                .define('N', Items.NETHERITE_BOOTS)
                .unlockedBy("has_battery", has(ModItems.BATTERY))
                .save(recipeOutput);
    }


    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
