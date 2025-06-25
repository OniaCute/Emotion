package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.notifications.Notification;
import cc.emotion.modules.Module;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class EventManager {
    public void onTick() {
        for (Module module : ModuleManager.modules) {
            if (module.getStatus()) {
                module.onTick();
            }
        }
        NotifyManager.onTick();
    }

     public void onDraw2D(DrawContext context, float tickDelta) {
         Render2DUtil.drawRoundedRect(context.getMatrices(), 5, 5, 150, 50, 4, new Color(0, 0, 0));
         FontUtil.drawTextWithAlign(context, "Testing...", 5, 5, 155, 55, Aligns.LEFT, new Color(255, 255, 255), FontSize.MEDIUM);

         for (Module module : ModuleManager.modules) {
             if (module.getStatus()) {
                 module.onDraw2D(context, tickDelta);
             }
         }
         NotifyManager.onDraw2D(context, tickDelta);
     }
}
