package com.andrew.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties BANANA = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 1f)
            .build();

    public static final FoodProperties MILK_SHAKE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1f)
            .build();

    public static final FoodProperties FRUIT_SALAD = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400), 1f)
            .usingConvertsTo(Items.BOWL)
            .build();

}
