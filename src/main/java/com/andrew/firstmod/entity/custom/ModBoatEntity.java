package com.andrew.firstmod.entity.custom;

import com.andrew.firstmod.block.ModBlocks;
import com.andrew.firstmod.entity.ModEntities;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.function.IntFunction;

public class ModBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModBoatEntity.class, EntityDataSerializers.INT);

    public ModBoatEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModBoatEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.MOD_BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getPalmVariant()) {
            case PALM -> ModItems.PALM_BOAT.get();
        };
    }

    public void setVariant(Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }
    public Type getPalmVariant() {
        return Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, Type.PALM.ordinal());
    }
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getPalmVariant().getSerializedName());
    }
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(Type.byName(pCompound.getString("Type")));
        }
    }
    public static enum Type implements StringRepresentable {
        PALM(ModBlocks.PALM_PLANKS.get(), "palm");
        private final String name;
        private final Block planks;
        public static final EnumCodec<Type> CODEC = StringRepresentable.fromEnum(Type::values);
        private static final IntFunction<Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
        private Type(Block pPlanks, String pName) {
            this.name = pName;
            this.planks = pPlanks;
        }
        public String getSerializedName() {
            return this.name;
        }
        public String getName() {
            return this.name;
        }
        public Block getPlanks() {
            return this.planks;
        }
        public String toString() {
            return this.name;
        }
        /**
         * Get a boat type by its enum ordinal
         */
        public static Type byId(int pId) {
            return BY_ID.apply(pId);
        }
        public static Type byName(String pName) {
            return CODEC.byName(pName, PALM);
        }
    }
}