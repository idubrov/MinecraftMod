package com.andrew.firstmod.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;

import java.util.List;

public class MilkShakeFoodItem extends Item {

    public MilkShakeFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line1"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line2"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line3"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line4"));
        tooltipComponents.add(Component.translatable("tooltip.firstmod.milkshake.tooltip.line5"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
