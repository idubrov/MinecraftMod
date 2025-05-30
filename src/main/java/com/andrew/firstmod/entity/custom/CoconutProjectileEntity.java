package com.andrew.firstmod.entity.custom;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;

public class CoconutProjectileEntity extends Snowball {
    private float rotation;
    public Vec2 groundedOffset;

    public CoconutProjectileEntity(EntityType<? extends Snowball> entityType, Level level) {
        super(entityType, level);
    }

    public CoconutProjectileEntity(Level level, LivingEntity shooter) {
        super(level, shooter);
    }

    public CoconutProjectileEntity(Level level, double x, double y, double z) {
        super(level, x, y, z);
    }


    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(this.damageSources().thrown(this, this.getOwner()), 2);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }

}