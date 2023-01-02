package me.char321.cooldowndisplay.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class ClientMixin {

    @Inject(method = "render", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/toast/ToastManager;draw(Lnet/minecraft/client/util/math/MatrixStack;)V", shift = At.Shift.AFTER))
    public void draw(boolean tick, CallbackInfo ci) {
        MatrixStack matrixStack = new MatrixStack();
        ClientPlayerInteractionManager interactionManager = MinecraftClient.getInstance().interactionManager;
        if (interactionManager == null) return;

        MinecraftClient.getInstance().textRenderer.draw(matrixStack, new LiteralText("cooldown: " + ((InteractionMixin) interactionManager).getBlockBreakingCooldown()), 100, 100, 0xffffff);

    }

}
