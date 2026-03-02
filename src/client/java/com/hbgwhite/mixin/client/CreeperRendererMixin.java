package com.hbgwhite.mixin.client;

import net.minecraft.client.render.entity.CreeperEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreeperEntityRenderer.class)
public class CreeperRendererMixin {

    @Inject(at = @At("HEAD"), method = "getTexture", cancellable = true)
    private void overrideTexture(CallbackInfoReturnable<Identifier> info) {
        info.setReturnValue(Identifier.of("mecha-mine", "textures/entity/creeper/creeper.png"));
    }
}