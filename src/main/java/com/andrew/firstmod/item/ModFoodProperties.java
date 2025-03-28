package com.andrew.firstmod.item;

import com.andrew.firstmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {
    public static final FoodProperties BANANA = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 2), 1f)
            .build();

    public static final FoodProperties MILK_SHAKE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 400, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 400, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1f)
            .build();

    public static final FoodProperties FRUIT_SALAD = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400), 1f)
            .usingConvertsTo(Items.BOWL)
            .build();

    public static final FoodProperties MAKI_SUSHI = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20, 0), 0.25f)
            .fast()
            .build();

    public static final FoodProperties NIGIRI_SUSHI = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 20, 0), 0.25f)
            .fast()
            .build();

    public static final FoodProperties TELEPORTATION_DRINK = new FoodProperties.Builder()
            .alwaysEdible()
            .effect(() -> new MobEffectInstance(ModEffects.TELEPORTATiON_EFFECT, 1, 0), 1f)
            .build();
}
