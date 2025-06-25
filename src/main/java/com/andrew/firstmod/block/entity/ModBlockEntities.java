package com.andrew.firstmod.block.entity;

import com.andrew.firstmod.FirstMod;
import com.andrew.firstmod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, FirstMod.MOD_ID);

    public static final Supplier<BlockEntityType<ChargingStationBlockEntity>> CHARGING_STATION_BE =
            BLOCK_ENTITIES.register("charging_station_be", () -> new BlockEntityType<>(
                    ChargingStationBlockEntity::new, ModBlocks.CHARGING_STATION.get()));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}