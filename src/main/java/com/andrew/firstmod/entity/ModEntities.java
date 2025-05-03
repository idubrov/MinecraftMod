package com.andrew.firstmod.entity;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.entity.custom.CoconutProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FirstMod.MOD_ID);

    public static final Supplier<EntityType<CoconutProjectileEntity>> COCONUT =
            ENTITY_TYPES.register("coconut", () -> EntityType.Builder
                            .<CoconutProjectileEntity>of(CoconutProjectileEntity::new, MobCategory.MISC)
                            .noLootTable()
                            .sized(0.5f, 0.5f)
                            .clientTrackingRange(10)
                            .updateInterval(10)
                            .build(entityId("coconut")));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

    private static ResourceKey<EntityType<?>> entityId(String name)
    {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
    }
}