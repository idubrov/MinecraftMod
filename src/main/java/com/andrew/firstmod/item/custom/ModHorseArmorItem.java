package com.andrew.firstmod.item.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


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
}
