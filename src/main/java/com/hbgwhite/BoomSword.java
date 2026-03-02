package com.hbgwhite;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public class BoomSword extends Item {

    public BoomSword() {
        super(ToolMaterial.DIAMOND.applySwordSettings(
            new Item.Settings().registryKey(MechaMine.BOOM_SWORD_KEY), 
            96.0f, -2.4f));
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && attacker.getEntityWorld() instanceof ServerWorld serverWorld) {
            Vec3d look = player.getRotationVec(1.0f);

            TntEntity tnt = new TntEntity(serverWorld,
                player.getX() + look.x * 2,
                player.getEyeY(),
                player.getZ() + look.z * 2,
                null);

            tnt.setVelocity(look.x * 2, look.y * 0.5 + 0.3, look.z * 2);
            serverWorld.spawnEntity(tnt);
        }
        super.postHit(stack, target, attacker);
    }
}