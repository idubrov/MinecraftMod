package com.andrew.firstmod.item.custom;

import com.andrew.firstmod.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Objects;


public class ModArmorItem extends ArmorItem {
    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide()) {
            applyArmorEffects(player);
        }
    }

    private static final List<Holder<MobEffect>> EFFECTS = List.of(
            MobEffects.JUMP,
            MobEffects.MOVEMENT_SPEED,
            MobEffects.REGENERATION,
            MobEffects.NIGHT_VISION
    );

    private void applyArmorEffects(Player player) {
        for (int slot : Inventory.ALL_ARMOR_SLOTS) {
            if (player.getInventory().getArmor(slot).getItem() instanceof ArmorItem item &&
                    item.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL) {

                    if (!player.hasEffect(EFFECTS.get(slot))) {
                        player.addEffect(
                            new MobEffectInstance(EFFECTS.get(slot), 400, 1, false, false));
                    }

                    else if (player.getEffect(EFFECTS.get(slot)) != null) {
                        if (player.getEffect(EFFECTS.get(slot)).getDuration() < 220)
                            player.addEffect(
                                    new MobEffectInstance(EFFECTS.get(slot), 400, 1, false, false));
                };
            }
        }
    }
}
