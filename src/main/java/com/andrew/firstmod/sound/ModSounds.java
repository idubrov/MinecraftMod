package com.andrew.firstmod.sound;

import com.andrew.firstmod.FirstMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, FirstMod.MOD_ID);

    public static final Supplier<SoundEvent> COCONUT_POP = registerSoundEvent("coconut_pop_event");


    public static final Supplier<SoundEvent> BASSOON_SONGS = registerSoundEvent("bassoon_songs_sound_event");
    public static final Supplier<SoundEvent> BASSOON_SOLOS = registerSoundEvent("bassoon_solos_sound_event");
    public static final ResourceKey<JukeboxSong> BASSOON_SONGS_KEY = createSong("bassoon_songs_key");
    public static final ResourceKey<JukeboxSong> BASSOON_SOLOS_KEY = createSong("bassoon_solos_key");


    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
    }


    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
