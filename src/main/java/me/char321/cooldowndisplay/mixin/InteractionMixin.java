package me.char321.cooldowndisplay.mixin;

import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ClientPlayerInteractionManager.class)
public interface InteractionMixin {
    @Accessor
    int getBlockBreakingCooldown();
}
