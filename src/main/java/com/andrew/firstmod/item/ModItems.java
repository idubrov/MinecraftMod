package com.andrew.firstmod.item;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.item.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;


public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(FirstMod.MOD_ID);


    public static final DeferredItem<Item> SULFUR_POWDER = ITEMS.register("sulfur_powder",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "sulfur_powder")))));
    public static final DeferredItem<Item> SULFUR_SHARD = ITEMS.register("sulfur_shard",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "sulfur_shard")))));


    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut",
            () -> new CoconutItem(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "coconut")))
                    .stacksTo(16)));


    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new BlockItem(ModBlocks.BANANA_BUSH.get(),
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "banana")))
                            .food(ModFoodProperties.BANANA, ModFoodProperties.BANANA_EFFECT)));

    public static final DeferredItem<Item> MILK_SHAKE = ITEMS.register("milk_shake",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "milk_shake")))
                    .food(ModFoodProperties.MILK_SHAKE, ModFoodProperties.MILK_SHAKE_EFFECT)));

    public static final DeferredItem<Item> FRUIT_SALAD = ITEMS.register("fruit_salad",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "fruit_salad")))
                    .food(ModFoodProperties.FRUIT_SALAD, ModFoodProperties.FRUIT_SALAD_EFFECT)
                    .usingConvertsTo(Items.BOWL)));

    public static final DeferredItem<Item> MAKI_SUSHI = ITEMS.register("maki_sushi",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "maki_sushi")))
                    .food(ModFoodProperties.MAKI_SUSHI, ModFoodProperties.MAKI_SUSHI_EFFECT)));

    public static final DeferredItem<Item> NIGIRI_SUSHI = ITEMS.register("nigiri_sushi",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "nigiri_sushi")))
                    .food(ModFoodProperties.NIGIRI_SUSHI, ModFoodProperties.NIGIRI_SUSHI_EFFECT)));


    public static final DeferredItem<Item> RICE_SEEDS = ITEMS.register("rice_seeds",
            () -> new BlockItem(ModBlocks.RICE_CROP.get(),
                    new Item.Properties()
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "rice_seeds")))));

    public static final DeferredItem<Item> RICE_STEM = ITEMS.register("rice_stem",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "rice_stem")))));






    public static final DeferredItem<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "battery")))));


    public static final DeferredItem<Item> ELECTRIC_PICKAXE = ITEMS.register("electric_pickaxe",
            () -> new ElectricPickaxeItem(ModToolTiers.ELECTRIC, 1.0F, -2.8F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_pickaxe")))));

    public static final DeferredItem<Item> ELECTRIC_AXE = ITEMS.register("electric_axe",
            () -> new ElectricAxeItem(ModToolTiers.ELECTRIC, 6.0F, -3.1F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_axe")))));

    public static final DeferredItem<Item> ELECTRIC_SHOVEL = ITEMS.register("electric_shovel",
            () -> new ElectricShovelItem(ModToolTiers.ELECTRIC, 1.5F, -3.0F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_shovel")))));

    public static final DeferredItem<Item> ELECTRIC_HOE = ITEMS.register("electric_hoe",
            () -> new ElectricHoeItem(ModToolTiers.ELECTRIC, -2F, -1F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_hoe")))));


    public static final DeferredItem<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new HammerItem(ToolMaterial.WOOD, 1.0F, -2.8F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "wooden_hammer")))));

    public static final DeferredItem<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(ToolMaterial.WOOD, 1.0F, -2.8F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "stone_hammer")))));

    public static final DeferredItem<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(ToolMaterial.WOOD, 1.0F, -2.8F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "golden_hammer")))));

    public static final DeferredItem<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(ToolMaterial.WOOD, 1.0F, -2.8F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "iron_hammer")))));

    public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(ToolMaterial.WOOD, 1.0F, -2.8F, new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "diamond_hammer")))));


    public static final DeferredItem<Item> ELECTRIC_HELMET = ITEMS.register("electric_helmet",
            () -> new ModArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorType.HELMET)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_helmet")))));
//            {
//                @Override
//                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_helmet.tooltip.line1"));
//                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//                }
//            });

    public static final DeferredItem<Item> ELECTRIC_CHESTPLATE = ITEMS.register("electric_chestplate",
            () -> new ModArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorType.CHESTPLATE)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_chestplate")))));
//            {
//                @Override
//                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_chestplate.tooltip.line1"));
//                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//                }
//            });

    public static final DeferredItem<Item> ELECTRIC_LEGGINGS = ITEMS.register("electric_leggings",
            () -> new ModArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorType.LEGGINGS)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_leggings")))));
//            {
//                @Override
//                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_leggings.tooltip.line1"));
//                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//                }
//            });

    public static final DeferredItem<Item> ELECTRIC_BOOTS = ITEMS.register("electric_boots",
            () -> new ModArmorItem(new Item.Properties()
                    .humanoidArmor(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL, ArmorType.BOOTS)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_boots")))));
//            {
//                @Override
//                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
//                    tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_boots.tooltip.line1"));
//                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//                }
//            });

    public static final DeferredItem<Item> ELECTRIC_HORSE_ARMOR = ITEMS.register("electric_horse_armor",
            () -> new Item(new Item.Properties().stacksTo(1)
                    .horseArmor(ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL)
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "electric_horse_armor")))));


//    public static final DeferredItem<Item> TELEPORTATION_DEVICE = ITEMS.register("teleportation_device",
//            () -> new Item(new Item.Properties()
//                    .food(ModFoodProperties.TELEPORTATION_DEVICE, ModFoodProperties.TELEPORTATION_EFFECT)
//                    .stacksTo(1)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
