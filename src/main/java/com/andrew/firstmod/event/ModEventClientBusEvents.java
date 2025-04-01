package com.andrew.firstmod.event;

import com.andrew.firstmod.particle.ModParticlesTypes;
import com.andrew.firstmod.particle.custom.SulfurParticles;
import com.andrew.firstmod.particle.custom.TeleportationParticles;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;


public class ModEventClientBusEvents {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {

        event.registerSpriteSet(ModParticlesTypes.SULFUR_PARTICLES.get(), SulfurParticles.SulfurParticlesProvider::new);
        event.registerSpriteSet(ModParticlesTypes.TELEPORTATION_PARTICLES.get(), TeleportationParticles.TeleportationParticlesProvider::new);
    }
}
