package com.github.itsempa.clearlava.mixin;

import net.minecraft.client.renderer.BlockFluidRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockFluidRenderer.class)
public abstract class MixinBlockFluidRenderer {

    @Redirect(
        method = "initAtlasSprites",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureMap;getAtlasSprite(Ljava/lang/String;)Lnet/minecraft/client/renderer/texture/TextureAtlasSprite;")
    )
    TextureAtlasSprite replaceAtlasSpritesWater(TextureMap instance, String iconName) {
        switch (iconName) {
            case "minecraft:blocks/lava_still":
                return instance.getAtlasSprite("minecraft:blocks/water_still");
            case "minecraft:blocks/lava_flow":
                return instance.getAtlasSprite("minecraft:blocks/water_flow");
            default:
                return instance.getAtlasSprite(iconName);
        }
    }
}
