package com.andrew.firstmod.item.custom;

import com.andrew.firstmod.entity.custom.CoconutProjectileEntity;
import com.andrew.firstmod.sound.ModSounds;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;

public class CoconutItem extends SnowballItem {
    public CoconutItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                ModSounds.COCONUT_POP.get(), SoundSource.BLOCKS, 0.5F, 1.0F);
        if (!level.isClientSide) {
            CoconutProjectileEntity coconutProjectile = new CoconutProjectileEntity(level, player, itemstack);
            coconutProjectile.setItem(itemstack);
            coconutProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 0.5F, 1.0F);
            level.addFreshEntity(coconutProjectile);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, player);
        return InteractionResult.SUCCESS;
    }
}