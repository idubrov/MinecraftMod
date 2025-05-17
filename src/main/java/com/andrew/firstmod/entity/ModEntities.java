package com.andrew.firstmod.entity;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.entity.custom.CoconutProjectileEntity;
import com.andrew.firstmod.entity.custom.ModBoatEntity;
import com.andrew.firstmod.entity.custom.ModChestBoatEntity;
import com.andrew.firstmod.entity.custom.ModElectricBoatEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, FirstMod.MOD_ID);


    public static final Supplier<EntityType<CoconutProjectileEntity>> COCONUT =
            ENTITY_TYPES.register("coconut", () -> EntityType.Builder
                    .<CoconutProjectileEntity>of(CoconutProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f)
                    .clientTrackingRange(4)
                    .updateInterval(10)
                    .build("coconut"));

    public static final Supplier<EntityType<ModBoatEntity>> MOD_BOAT =
            ENTITY_TYPES.register("mod_boat", () -> EntityType.Builder
                    .<ModBoatEntity>of(ModBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .build("mod_boat"));
    public static final Supplier<EntityType<ModChestBoatEntity>> MOD_CHEST_BOAT =
            ENTITY_TYPES.register("mod_chest_boat", () -> EntityType.Builder
                    .<ModChestBoatEntity>of(ModChestBoatEntity::new, MobCategory.MISC)
                    .sized(1.375f, 0.5625f)
                    .build("mod_chest_boat"));

    
//    public static final Supplier<EntityType<ModElectricBoatEntity>> MOD_ELECTRIC_BOAT =
//            ENTITY_TYPES.register("mod_electric_boat", () -> EntityType.Builder
//                    .<ModElectricBoatEntity>of(ModElectricBoatEntity::new, MobCategory.MISC)
//                    .sized(1.375f, 0.5625f)
//                    .build("mod_electric_boat"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
