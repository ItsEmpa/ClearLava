package com.github.itsempa.clearlava.mixin;

import net.minecraft.client.renderer.EntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityRenderer.class)
public class MixinEntityRenderer {

    @ModifyConstant(method = "setupFog", constant = @Constant(floatValue = 2.0f))
    private float lavaFogDensity(float original) {
        return 0.01f;
    }

    @ModifyConstant(method = "updateFogColor", constant = @Constant(floatValue = 0.6f, ordinal = 1))
    private float lavaFogColorRed(float original) {
        return 0.8f;
    }

    @ModifyConstant(method = "updateFogColor", constant = @Constant(floatValue = 0.1f))
    private float lavaFogColorGreen(float original) {
        return 0.8f;
    }

    @ModifyConstant(method = "updateFogColor", constant = @Constant(floatValue = 0.0f, ordinal = 6))
    private float lavaFogColorBlue(float original) {
        return 0.8f;
    }

}
