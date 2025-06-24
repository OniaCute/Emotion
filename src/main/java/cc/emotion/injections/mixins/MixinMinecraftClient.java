package cc.emotion.injections.mixins;

import cc.emotion.Emotion;
import cc.emotion.util.font.FontRenderers;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.RunArgs;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.thread.ReentrantThreadExecutor;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.nio.ByteBuffer;
import java.util.Random;

@Mixin(MinecraftClient.class)
public abstract class MixinMinecraftClient extends ReentrantThreadExecutor<Runnable> {
    @Shadow @Nullable public ClientWorld world;

    public MixinMinecraftClient(String string) {
        super(string);
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    void postWindowInit(RunArgs args, CallbackInfo ci) {
        try {
            FontRenderers.SMOOTH_3F = FontRenderers.SmoothFont(3f);
            FontRenderers.SMOOTH_4F = FontRenderers.SmoothFont(4f);
            FontRenderers.SMOOTH_5F = FontRenderers.SmoothFont(5f);
            FontRenderers.SMOOTH_6F = FontRenderers.SmoothFont(6f);
            FontRenderers.SMOOTH_7F = FontRenderers.SmoothFont(7f);
            FontRenderers.SMOOTH_8F = FontRenderers.SmoothFont(8f);
            FontRenderers.SMOOTH_9F = FontRenderers.SmoothFont(9f);
            FontRenderers.SMOOTH_10F = FontRenderers.SmoothFont(10f);
            FontRenderers.SMOOTH_12F = FontRenderers.SmoothFont(12f);
            FontRenderers.SMOOTH_14F = FontRenderers.SmoothFont(14f);
            FontRenderers.SMOOTH_15F = FontRenderers.SmoothFont(15f);
            FontRenderers.SMOOTH_16F = FontRenderers.SmoothFont(16f);
            FontRenderers.SMOOTH_18F = FontRenderers.SmoothFont(18f);
            FontRenderers.SMOOTH_20F = FontRenderers.SmoothFont(20f);
            FontRenderers.SMOOTH_21F = FontRenderers.SmoothFont(21f);
            FontRenderers.SMOOTH_24F = FontRenderers.SmoothFont(24f);
            FontRenderers.SMOOTH_28F = FontRenderers.SmoothFont(28f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author OniaCute & love
     * @reason No Reason, just change the Title.
     */
    @Overwrite
    private String getWindowTitle() {
        String[] text = {
                "Get unique sense of the Minecraft.",
                "Bypass it, Beat it, Got it."
        };

        Random random = new Random();
        int randomIndex = random.nextInt(text.length);
        String randomSentence = text[randomIndex];
        StringBuilder stringBuilder = new StringBuilder("Emotion Client | ");
        stringBuilder.append(randomSentence);
        stringBuilder.append("  -  emotionclient.cc");

        return stringBuilder.toString();
    }

    @Inject(at = @At("HEAD"), method = "tick()V")
    public void tick(CallbackInfo info) {
        if (this.world != null) {
            if (Emotion.EVENTS != null && Emotion.LOADED) {
                Emotion.EVENTS.onTick();
            }
        }
    }
}
