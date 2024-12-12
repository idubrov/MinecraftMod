package com.andrew.firstmod.item.custom;

import com.andrew.firstmod.item.ModArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


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

    private void applyArmorEffects(Player player) {
        ArmorItem boots = null;
        ArmorItem leggings = null;
        ArmorItem chestplate = null;
        ArmorItem helmet = null;

        if (player.getInventory().getArmor(0).getItem() instanceof ArmorItem) {
            boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
            if (boots.getMaterial() == ModArmorMaterials.ELECTRIC_ARMOR_MATERIAL) {
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 1, 1, false, false));
            }

        }
    }
}
