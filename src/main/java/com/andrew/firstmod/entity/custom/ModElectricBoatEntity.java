package com.andrew.firstmod.entity.custom;

import com.andrew.firstmod.entity.ModEntities;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ModElectricBoatEntity extends ChestBoat {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

    public ModElectricBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public ModElectricBoatEntity(Level pLevel, double pX, double pY, double pZ) {
        this(ModEntities.MOD_ELECTRIC_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        switch (getPalmVariant()) {
            case PALM -> {
                return ModItems.PALM_ELECTRIC_BOAT.get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(ModBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, ModBoatEntity.Type.PALM.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getPalmVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public ModBoatEntity.Type getPalmVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        // If the player is not sneaking (not holding Shift), allow riding
        if (!player.isSecondaryUseActive() && this.canAddPassenger(player)) {
            return super.interact(player, hand);
        }
        // Prevent opening the chest by skipping container interaction
        return InteractionResult.SUCCESS;
    }

    @Override
    public void openCustomInventoryScreen(Player player) {
        // Do nothing: disables chest inventory opening
    }


    @Override
    public void tick() {
        super.tick(); // Runs all normal boat logic

        if (this.isControlledByLocalInstance() && (this.getPaddleState(0) || this.getPaddleState(1))) {
            Vec3 currentMotion = this.getDeltaMovement();
            Vec3 forward = this.getForward().scale(0.04); // vanilla: 0.02, boost to 0.04

            // Apply acceleration
            Vec3 newMotion = currentMotion.add(forward);

            // Cap speed
            double maxSpeed = 1.5 * 0.35; // vanilla is ~0.35 blocks/tick
            if (newMotion.length() > maxSpeed) {
                newMotion = newMotion.normalize().scale(maxSpeed);
            }

            this.setDeltaMovement(newMotion);
        }
    }
}