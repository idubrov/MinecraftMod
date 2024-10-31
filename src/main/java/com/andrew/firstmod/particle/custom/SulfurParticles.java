package com.andrew.firstmod.particle.custom;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;


public class SulfurParticles extends TextureSheetParticle {

    private final SpriteSet sprites;

    private final double xStart;
    private final double yStart;
    private final double zStart;

    protected SulfurParticles(ClientLevel level, double x, double y, double z,
                              double xSpeed, double ySpeed, double zSpeed, SpriteSet sprites) {

        super(level, x, y, z);
        this.xd = xSpeed;
        this.yd = ySpeed;
        this.zd = zSpeed;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xStart = this.x;
        this.yStart = this.y;
        this.zStart = this.z;
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.lifetime = (int)(Math.random() * 10.0) + 40;
        this.quadSize = 0.1F * (this.random.nextFloat() * this.random.nextFloat() * 1.0F + 1.0F);
        this.sprites = sprites;
        this.setSpriteFromAge(sprites);
    }

    @Override
    public void tick() {
        this.setSpriteFromAge(sprites);
        super.tick();
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class SulfurParticlesProvider implements ParticleProvider<SimpleParticleType> {

        private final SpriteSet sprites;

        public SulfurParticlesProvider(SpriteSet sprites) {
            this.sprites = sprites;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new SulfurParticles(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites);
        }
    }
}