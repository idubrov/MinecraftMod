package com.andrew.firstmod.data;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.HashSet;

public class TeleportationStoneData extends SavedData {

    private final HashSet<BlockPos> storedPositions = new HashSet<>();

    // Create new instance of saved data
    public static TeleportationStoneData create() {
        return new TeleportationStoneData();
    }


    // Load existing instance of saved data
    public static TeleportationStoneData load(CompoundTag tag, HolderLookup.Provider provider) {

        TeleportationStoneData data = TeleportationStoneData.create();
        ListTag list = tag.getList("positions", 10);

        for (int i = 0; i < list.size(); i++) {
            CompoundTag posTag = list.getCompound(i);
            data.storedPositions.add(new BlockPos(posTag.getInt("x"), posTag.getInt("y"), posTag.getInt("z")));
        }
        return data;
    }


    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider provider) {

        ListTag list = new ListTag();
        for (BlockPos pos : storedPositions) {
            CompoundTag posTag = new CompoundTag();
            posTag.putInt("x", pos.getX());
            posTag.putInt("y", pos.getY());
            posTag.putInt("z", pos.getZ());
            list.add(posTag);
        }
        tag.put("positions", list);
        return tag;
    }


    public void addStone(BlockPos pos) {
        storedPositions.add(pos);
        setDirty(); // Marks the data as changed so it gets saved
    }


    public void removeStone(BlockPos pos) {
        storedPositions.remove(pos);
        setDirty();
    }


    public HashSet<BlockPos> getStoredPositions() {
        return storedPositions;
    }


    public static TeleportationStoneData get(ServerLevel world) {
        return world.getDataStorage()
            .computeIfAbsent(new Factory<>(TeleportationStoneData::create, TeleportationStoneData::load), "teleportation_stone_data");
    }
}
