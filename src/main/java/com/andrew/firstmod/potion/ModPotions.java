package com.andrew.firstmod.potion;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.effect.ModEffects;
import com.mojang.blaze3d.shaders.Effect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, FirstMod.MOD_ID);

    public static final Holder<Potion> ELECTRIFIED_POTION = POTIONS.register("electrified_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.ELECTRIFIED_EFFECT, 600 , 0)));
    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
