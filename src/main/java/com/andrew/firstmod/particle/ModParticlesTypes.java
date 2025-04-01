package com.andrew.firstmod.particle;

import com.andrew.firstmod.FirstMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModParticlesTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, FirstMod.MOD_ID);


    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SULFUR_PARTICLES =
            PARTICLE_TYPES.register("sulfur_particles", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TELEPORTATION_PARTICLES =
            PARTICLE_TYPES.register("teleportation_particles", () -> new SimpleParticleType(false));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}