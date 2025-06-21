package com.andrew.firstmod.entity.custom;

import com.andrew.firstmod.entity.ModEntities;
import com.andrew.firstmod.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;


public class ModElectricBoatEntity  extends ChestBoat {
    public ModElectricBoatEntity(EntityType<? extends ChestBoat> type, Level level, Supplier<Item> itemSupplier) {
        super(type, level, itemSupplier);
    }

    public ModElectricBoatEntity(Level level, double x, double y, double z) {
        this(ModEntities.PALM_ELECTRIC_BOAT.get(), level, () -> ModItems.PALM_ELECTRIC_BOAT.get());
        setPos(x, y, z);
        setDeltaMovement(Vec3.ZERO);
        xo = x;
        yo = y;
        zo = z;
    }


    public @NotNull InteractionResult interact(Player player, InteractionHand hand) {
        // If the player is not sneaking (not holding Shift), allow riding
        if (!player.isSecondaryUseActive() && this.canAddPassenger(player)) {
            return super.interact(player, hand);
        }
        // Prevent opening the chest by skipping container interaction
        return InteractionResult.PASS;
    }

    public void openCustomInventoryScreen(@NotNull Player player) {
        // Do nothing: disables chest inventory opening
    }

    @Override
    public void tick() {
        super.tick(); // Runs all normal boat logic

        if (this.isLocalInstanceAuthoritative() && (this.getPaddleState(0) || this.getPaddleState(1))) {
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
