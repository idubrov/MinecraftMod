package com.andrew.firstmod.item;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.item.custom.HammerItem;
import com.andrew.firstmod.item.custom.MilkShakeFoodItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
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
  /*  public static final DeferredItem<Item> HAMMER = ITEMS.register("hammer",
            () -> new HammerItem(new Item.Properties().durability(64)));
    public static final DeferredItem<Item> COMPOST = ITEMS.register("compost",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HOT_CHOCOLATE = ITEMS.register("hot_chocolate",
            () -> new Item(new Item.Properties()));*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
