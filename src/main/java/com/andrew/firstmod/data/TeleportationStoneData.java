package com.andrew.firstmod.data;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.saveddata.SavedDataType;

import java.util.HashSet;
import java.util.List;

public class TeleportationStoneData extends SavedData {
    private final HashSet<BlockPos> storedPositions = new HashSet<>();

    // Constructor used when decoding
    public TeleportationStoneData(HashSet<BlockPos> positions) {
        this.storedPositions.addAll(positions);
    }

    // Default constructor
    public TeleportationStoneData() {}

    // Add a position
    public void addStone(BlockPos pos) {
        storedPositions.add(pos);
        setDirty();
    }

    // Remove a position
    public void removeStone(BlockPos pos) {
        storedPositions.remove(pos);
        setDirty();
    }

    public HashSet<BlockPos> getStoredPositions() {
        return storedPositions;
    }

    // --- Codec for serialization ---
    public static final Codec<TeleportationStoneData> CODEC = BlockPos.CODEC
            .listOf()
            .xmap(
                    list -> new TeleportationStoneData(new HashSet<>(list)),
                    data -> List.copyOf(data.storedPositions)
            );

    // --- SavedDataType for the registry system ---
    public static final SavedDataType<TeleportationStoneData> TYPE =
            new SavedDataType<>("teleportation_stone_data", TeleportationStoneData::new, CODEC);

    // --- Access method (used to get or create data) ---
    public static TeleportationStoneData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(TYPE);
    }
}