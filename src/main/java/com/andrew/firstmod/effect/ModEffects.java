package com.andrew.firstmod.effect;

import com.andrew.firstmod.FirstMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, FirstMod.MOD_ID);

    public static final Holder<MobEffect> ELECTRIFIED_EFFECT = MOB_EFFECTS.register("electrified",
            () -> new ElectrifiedEffect(MobEffectCategory.NEUTRAL, 0xe2ff68));

    public static final Holder<MobEffect> TELEPORTATiON_EFFECT = MOB_EFFECTS.register("teleportation",
            () -> new TeleportationEffect(MobEffectCategory.NEUTRAL, 0x000000));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
