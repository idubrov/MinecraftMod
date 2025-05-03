package com.andrew.firstmod.item.custom;

import com.andrew.firstmod.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;


public class ModArmorItem extends Item {
    public ModArmorItem(Properties properties) {
        super(properties);
    }

    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof Player player && !level.isClientSide()) {
            applyArmorEffects(player);
        }
    }

//    private static final List<Holder<MobEffect>> EFFECTS1 = List.of(
//            MobEffects.JUMP_BOOST,
//            MobEffects.SPEED,
//            MobEffects.REGENERATION,
//            MobEffects.NIGHT_VISION
//    );


    private static final Map<EquipmentSlot, Holder<MobEffect>> EFFECTS = Map.of(
            EquipmentSlot.FEET, MobEffects.SPEED,
            EquipmentSlot.LEGS, MobEffects.JUMP_BOOST,
            EquipmentSlot.CHEST, MobEffects.RESISTANCE,
            EquipmentSlot.HEAD, MobEffects.NIGHT_VISION
    );

    private void applyArmorEffects(Player player) {






        for (EquipmentSlot slot : EquipmentSlot.values()) {
            // Only check armor slots
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack armorStack = player.getItemBySlot(slot);

//                Optional<ArmorData> armorDataOpt = armorStack.getData(ItemComponents.ARMOR);
//                if (armorDataOpt.isPresent()) {
//                    ArmorData armorData = armorDataOpt.get();
//
//                    if (armorData.material() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL) {
//                        if (!player.hasEffect(EFFECTS.get(slot.ordinal()))) {
//                            player.addEffect(new MobEffectInstance(EFFECTS.get(slot.ordinal()), 400, 1, false, false));
//                        } else {
//                            var instance = player.getEffect(EFFECTS.get(slot.ordinal()));
//                            if (instance != null && instance.getDuration() < 220) {
//                                player.addEffect(new MobEffectInstance(EFFECTS.get(slot.ordinal()), 400, 1, false, false));
//                            }
//                        }
//                    }
//                }
            }
        }
    }



//
//    private void applyArmorEffects(Player player) {
//        for (int slot : Inventory.ALL_ARMOR_SLOTS) {
//            if (player.getInventory().getArmor(slot).getItem() instanceof ArmorItem item &&
//                    item.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL) {
//
//                    if (!player.hasEffect(EFFECTS.get(slot))) {
//                        player.addEffect(
//                            new MobEffectInstance(EFFECTS.get(slot), 400, 1, false, false));
//                    }
//
//                    else if (player.getEffect(EFFECTS.get(slot)) != null) {
//                        if (player.getEffect(EFFECTS.get(slot)).getDuration() < 220)
//                            player.addEffect(
//                                    new MobEffectInstance(EFFECTS.get(slot), 400, 1, false, false));
//                };
//            }
//        }
//    }



}
