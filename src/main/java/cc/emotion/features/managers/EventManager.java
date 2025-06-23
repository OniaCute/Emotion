package cc.emotion.features.managers;

import cc.emotion.modules.Module;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class EventManager {
    public void onTick() {
        for (Module module : ModuleManager.modules) {
            module.onTick();
        }
    }

     public void onDraw2D(DrawContext drawContext, float tickDelta) {
         FontManager.drawText(drawContext, "Emotion.cc", 5, 5, new Color(255, 255, 255).getRGB());
         for (Module module : ModuleManager.modules) {
             module.onDraw2D(drawContext, tickDelta);
         }
     }
}
