package com.hbgwhite.mechamods;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

/**
 * A block that bounces players high into the air — like a giant trampoline!
 * Crouch (Shift) while landing to cancel the bounce.
 */
public class BounceBlock extends Block {
    private static final double BOUNCE_POWER = 1.5;

    public BounceBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void fallOn(Level level, BlockState state, BlockPos pos, Entity entity, float fallHeight) {
        // Cancel fall damage on the bounce block
        entity.causeFallDamage(fallHeight, 0.0f, level.damageSources().fall());
    }

    @Override
    public void updateEntityAfterFallOn(Level level, Entity entity) {
        super.updateEntityAfterFallOn(level, entity);
        if (entity instanceof LivingEntity livingEntity && !livingEntity.isShiftKeyDown()) {
            Vec3 current = entity.getDeltaMovement();
            entity.setDeltaMovement(current.x, BOUNCE_POWER, current.z);
            entity.hasImpulse = true;
        }
    }
}
