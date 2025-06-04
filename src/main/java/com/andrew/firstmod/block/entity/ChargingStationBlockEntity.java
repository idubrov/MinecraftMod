package com.andrew.firstmod.block.entity;

import com.andrew.firstmod.item.ModItems;
import com.andrew.firstmod.screen.custom.ChargingStationMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;


public class ChargingStationBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(2) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final ContainerData data;
    private int speed_factor = 20;
    private int progress = 0;
    private int maxProgress = 72 * speed_factor;

    public ChargingStationBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.CHARGING_STATION_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> ChargingStationBlockEntity.this.progress;
                    case 1 -> ChargingStationBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0:
                        ChargingStationBlockEntity.this.progress = value;
                    case 1:
                        ChargingStationBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Charging Station");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new ChargingStationMenu(i, inventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("charging_station.progress", progress);
        pTag.putInt("charging_station.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("charging_station.progress");
        maxProgress = pTag.getInt("charging_station.max_progress");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if (canBeCharged()) {
            increaseChargingProgress();
            setChanged(level, blockPos, blockState);

            if (hasChargingFinished()) {
                chargeItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void chargeItem() {
        ItemStack output = new ItemStack(itemHandler.getStackInSlot(INPUT_SLOT).getItemHolder(), 1);

        itemHandler.extractItem(INPUT_SLOT, 1, false);
        itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(output.getItem(), 1));
    }

    private boolean hasChargingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseChargingProgress() {
        progress++;
    }

    private boolean canBeCharged() {
        ItemStack inputItem = itemHandler.getStackInSlot(INPUT_SLOT);
        boolean isChargeable =
                inputItem.is(ModItems.ELECTRIC_AXE) || inputItem.is(ModItems.ELECTRIC_HOE) ||
                        inputItem.is(ModItems.ELECTRIC_SHOVEL) || inputItem.is(ModItems.ELECTRIC_PICKAXE) ||
                        inputItem.is(ModItems.ELECTRIC_HELMET) || inputItem.is(ModItems.ELECTRIC_CHESTPLATE) ||
                        inputItem.is(ModItems.ELECTRIC_LEGGINGS) || inputItem.is(ModItems.ELECTRIC_BOOTS);

        if (isChargeable && itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty()) {
            if (progress == 0 && inputItem.isDamageableItem()) {
//                int itemDamage = inputItem.getDamageValue();
//                int itemMaxDamage = inputItem.getMaxDamage();
//                float damagePercent = (float) itemDamage / itemMaxDamage;
                // Set progress based on remaining durability
                //this.progress = Math.round((1.0f - damagePercent) * this.maxProgress);

                this.maxProgress = inputItem.getMaxDamage() * speed_factor;
                this.progress = (inputItem.getMaxDamage() - inputItem.getDamageValue()) * speed_factor;
            }
            return true;
        }

        return false;
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 72 * speed_factor;
    }


    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }


    private float rotation;

    public float getRenderingRotation() {
        rotation += 0.5f;
        if (rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }
}
