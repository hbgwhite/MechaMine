package com.hbgwhite.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreeperEntity.class)
public class CreeperMixin {

    @Inject(at = @At("HEAD"), method = "explode", cancellable = true)
    private void onExplode(CallbackInfo info) {
        CreeperEntity creeper = (CreeperEntity)(Object)this;

        if (creeper.getEntityWorld() instanceof ServerWorld serverWorld) {
            info.cancel();

            serverWorld.createExplosion(
                creeper,
                creeper.getX(), creeper.getY(), creeper.getZ(),
                9.0f,
                World.ExplosionSourceType.MOB
            );

            LightningEntity lightning = new LightningEntity(
                EntityType.LIGHTNING_BOLT, serverWorld
            );
            lightning.refreshPositionAfterTeleport(
                creeper.getX(), creeper.getY(), creeper.getZ()
            );
            serverWorld.spawnEntity(lightning);
        }
    }
}