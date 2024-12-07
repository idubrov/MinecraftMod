package com.andrew.firstmod.item;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.item.custom.ElectricTool;
import com.andrew.firstmod.item.custom.HammerItem;
import com.andrew.firstmod.item.custom.MilkShakeFoodItem;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(FirstMod.MOD_ID);


    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFUR_POWDER = ITEMS.register("sulfur_powder",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SULFUR_SHARD = ITEMS.register("sulfur_shard",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> FRUIT_SALAD = ITEMS.register("fruit_salad",
            () -> new Item(new Item.Properties().food(ModFoodProperties.FRUIT_SALAD)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line1"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line2"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.fruit_salad.tooltip.line3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> BANANA = ITEMS.register("banana",
            () -> new Item(new Item.Properties().food(ModFoodProperties.BANANA)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.banana.tooltip.line1"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.banana.tooltip.line2"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.banana.tooltip.line3"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> MILK_SHAKE = ITEMS.register("milk_shake",
            () -> new MilkShakeFoodItem(new Item.Properties().food(ModFoodProperties.MILK_SHAKE)));


    public static final DeferredItem<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
                    tooltipComponents.add(Component.translatable("tooltip.firstmod.battery.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<ElectricTool> ELECTRIC_PICKAXE = ITEMS.register("electric_pickaxe",
            () -> new ElectricTool(ModToolTiers.ELECTRIC, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.ELECTRIC, 1.0F, -2.8f))));
    public static final DeferredItem<ElectricTool> ELECTRIC_SHOVEL = ITEMS.register("electric_shovel",
            () -> new ElectricTool(ModToolTiers.ELECTRIC, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.ELECTRIC, 1.5F, -3.0f))));
    public static final DeferredItem<ElectricTool> ELECTRIC_AXE = ITEMS.register("electric_axe",
            () -> new ElectricTool(ModToolTiers.ELECTRIC, BlockTags.MINEABLE_WITH_AXE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.ELECTRIC, 8.0F, -3.0f))));
    public static final DeferredItem<ElectricTool> ELECTRIC_HOE = ITEMS.register("electric_hoe",
            () -> new ElectricTool(ModToolTiers.ELECTRIC, BlockTags.MINEABLE_WITH_HOE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.ELECTRIC, 0.5F, -3.0f))));


    public static final DeferredItem<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new HammerItem(Tiers.WOOD, new Item.Properties()));
    public static final DeferredItem<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new HammerItem(Tiers.STONE, new Item.Properties()));
    public static final DeferredItem<Item> GOLDEN_HAMMER = ITEMS.register("golden_hammer",
            () -> new HammerItem(Tiers.GOLD, new Item.Properties()));
    public static final DeferredItem<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new HammerItem(Tiers.IRON, new Item.Properties()));
    public static final DeferredItem<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new HammerItem(Tiers.DIAMOND, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
