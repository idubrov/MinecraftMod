package com.andrew.firstmod.item.custom;

import com.andrew.firstmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;
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

    private static final Map<EquipmentSlot, Holder<MobEffect>> EFFECTS = Map.of(
            EquipmentSlot.FEET, MobEffects.JUMP_BOOST,
            EquipmentSlot.LEGS, MobEffects.SPEED,
            EquipmentSlot.CHEST, MobEffects.REGENERATION,
            EquipmentSlot.HEAD, MobEffects.NIGHT_VISION
    );

    private void applyArmorEffects(Player player) {
        for (EquipmentSlot slot : EquipmentSlot.values()) {
            if (slot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack stack = player.getItemBySlot(slot);
                Item item = stack.getItem();

                // Check if it's your custom armor via item identity or tag
                if (item == ModItems.ELECTRIC_HELMET.get() ||  // repeat for other armor pieces
                        item == ModItems.ELECTRIC_CHESTPLATE.get() ||
                        item == ModItems.ELECTRIC_LEGGINGS.get() ||
                        item == ModItems.ELECTRIC_BOOTS.get()) {

                    var effect = EFFECTS.get(slot);
                    var currentEffect = player.getEffect(effect);

                    if (currentEffect == null || currentEffect.getDuration() < 220) {
                        player.addEffect(new MobEffectInstance(effect, 400, 1, false, false));
                    }
                }
            }
        }
    }
}
