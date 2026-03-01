package com.hbgwhite.mechamods;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

/**
 * A block that gives players a speed boost when they step on it.
 * Great for building fast race tracks!
 */
public class SpeedBlock extends Block {
    /** Duration of the speed effect in ticks (2 seconds). */
    private static final int EFFECT_DURATION = 40;
    /** Amplifier 2 = Speed III. */
    private static final int EFFECT_AMPLIFIER = 2;

    public SpeedBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide() && entity instanceof Player player) {
            player.addEffect(new MobEffectInstance(
                    MobEffects.MOVEMENT_SPEED,
                    EFFECT_DURATION,
                    EFFECT_AMPLIFIER,
                    false,
                    false,
                    false));
        }
        super.stepOn(level, pos, state, entity);
    }
}
