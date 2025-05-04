package com.andrew.firstmod.item;

import com.andrew.firstmod.effect.ModEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoodProperties {
    public static final FoodProperties BANANA = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(0.5f)
            .build();
    public final static Consumable BANANA_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 400, 2), 1f)).build();


    public static final FoodProperties MILK_SHAKE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.25f)
            .alwaysEdible()
            .build();
    public final static Consumable MILK_SHAKE_EFFECT = Consumables.defaultDrink()
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, 400, 0), 1f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HASTE, 400, 0), 1f))
            .onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.SPEED, 400, 0), 1f))
            .build();


    public static final FoodProperties FRUIT_SALAD = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1f)
            .build();
    public final static Consumable FRUIT_SALAD_EFFECT = Consumables.defaultFood().onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 400), 1f)).build();


    public static final FoodProperties MAKI_SUSHI = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(1f)
            .build();
    public final static Consumable MAKI_SUSHI_EFFECT = Consumables.defaultFood().consumeSeconds(0.8F).onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 0), 0.25f)).build();


    public static final FoodProperties NIGIRI_SUSHI = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(1f)
            .build();
    public final static Consumable NIGIRI_SUSHI_EFFECT = Consumables.defaultFood().consumeSeconds(0.8F).onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 20, 0), 0.25f)).build();


    public static final FoodProperties TELEPORTATION_DEVICE = new FoodProperties.Builder()
            .alwaysEdible()
            .build();
    public final static Consumable TELEPORTATION_EFFECT = Consumables.defaultDrink().consumeSeconds(0.5F).onConsume(
            new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(ModEffects.TELEPORTATiON_EFFECT, 1, 0), 1f)).build();
}
