package com.andrew.firstmod.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class ModHorseArmorItem extends Item {
    public ModHorseArmorItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onAnimalArmorTick(ItemStack stack, Level level, Mob mob) {
        if (mob instanceof Horse horse && !level.isClientSide()) {
            horse.addEffect(new MobEffectInstance(MobEffects.SPEED, 60, 2, false, false));
        }

    }

//    @Override
//    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
//        tooltipComponents.add(Component.translatable("tooltip.firstmod.empty_line"));
//        tooltipComponents.add(Component.translatable("tooltip.firstmod.electric.tooltip.title"));
//        tooltipComponents.add(Component.translatable("tooltip.firstmod.electric_horse_armor.tooltip.line1"));
//        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
//    }
}
