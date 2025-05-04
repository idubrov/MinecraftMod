package com.andrew.firstmod.effect;

import com.andrew.firstmod.item.ModItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ElectrifiedEffect extends MobEffect {

    public ElectrifiedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(@NotNull ServerLevel level, @NotNull LivingEntity livingEntity, int amplifier) {

        if (!(livingEntity instanceof Player) || !hasPlayerElectricArmorOn((Player) livingEntity)) {
            if (livingEntity.getHealth() > 1.0F) {
                livingEntity.hurt(livingEntity.damageSources().generic(), 0.5F);
            }
        }

        AABB aabb = livingEntity.getBoundingBox().inflate(2.0, 2.0, 2.0);

        List<LivingEntity> nearbyEntities = livingEntity.level()
                .getEntitiesOfClass(LivingEntity.class, aabb, EntitySelector.LIVING_ENTITY_STILL_ALIVE);


        for (LivingEntity entity : nearbyEntities) {
            if (!(entity instanceof Player) || !(hasPlayerElectricArmorOn((Player) entity))) {
                entity.hurt(entity.damageSources().generic(), 0.2F);
            }
        }

        return super.applyEffectTick(level, livingEntity, amplifier);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }


    private boolean hasPlayerElectricArmorOn(Player player) {
        return (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ELECTRIC_BOOTS.get()) &&
                (player.getItemBySlot(EquipmentSlot.LEGS).getItem() == ModItems.ELECTRIC_LEGGINGS.get()) &&
                (player.getItemBySlot(EquipmentSlot.CHEST).getItem() == ModItems.ELECTRIC_CHESTPLATE.get()) &&
                (player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.ELECTRIC_HELMET.get());
    }
}