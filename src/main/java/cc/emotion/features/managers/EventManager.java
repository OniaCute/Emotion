package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.features.enums.FontSize;
import cc.emotion.modules.Module;
import cc.emotion.util.font.FontUtil;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class EventManager {
    public void onTick() {
        for (Module module : ModuleManager.modules) {
            module.onTick();
        }
    }

     public void onDraw2D(DrawContext context, float tickDelta) {
         Emotion.CONSOLE.logInfo("============================== on Rendered().");
         FontUtil.drawText(context, "Emotion.cc", 5, 5, new Color(255, 255, 255).getRGB(), FontSize.MEDIUM);
         for (Module module : ModuleManager.modules) {
//             if (module.getStatus()) {
                 module.onDraw2D(context, tickDelta);
//             }
         }
     }
}
