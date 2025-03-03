package com.andrew.firstmod.effect;

import com.andrew.firstmod.item.ModArmorMaterials;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ElectrifiedEffect extends MobEffect {

    public ElectrifiedEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyEffectTick(@NotNull LivingEntity livingEntity, int amplifier) {

        if (!(livingEntity instanceof Player) || !hasPlayerElectricArmorOn((Player) livingEntity)) {
            if (livingEntity.getHealth() > 1.0F) {
                livingEntity.hurt(livingEntity.damageSources().generic(), 0.5F);
            }
        }

        AABB aabb = livingEntity.getBoundingBox().inflate(2.0, 2.0, 2.0);
        TargetingConditions targetingConditions = TargetingConditions.DEFAULT;

        List<LivingEntity> nearbyEntities = livingEntity.level().getNearbyEntities(LivingEntity.class, targetingConditions, livingEntity, aabb);
        for (LivingEntity entity : nearbyEntities) {
            if (!(entity instanceof Player) || !(hasPlayerElectricArmorOn((Player) entity))) {
                entity.hurt(entity.damageSources().generic(), 0.2F);
            }
        }

        return super.applyEffectTick(livingEntity, amplifier);
    }

    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }


    private boolean hasPlayerElectricArmorOn(Player player) {
        for (ItemStack armorStack : player.getArmorSlots()) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL &&
                leggings.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL &&
                chestplate.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL &&
                helmet.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL;
    }
}