package cc.emotion.util.interfaces;

import net.minecraft.client.gl.Framebuffer;

public interface IShaderEffect {
    void emotion$addFakeTargetHook(String name, Framebuffer buffer);
}