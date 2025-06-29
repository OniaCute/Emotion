package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.enums.MouseButtons;
import cc.emotion.features.notifications.Notification;
import cc.emotion.modules.Module;
import cc.emotion.modules.client.Client;
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
         Client.INSTANCE.UIScale.setValue(Client.UIScales.X50);

         Render2DUtil.drawCircleWithInline(
                 context.getMatrices(),
                 new Color(0, 0, 0, 136),
                 new Color(22, 115, 255, 182),
                 35,
                 35,
                 360,
                 5,
                 3,
                 360);

//         Render2DUtil.drawRoundedRect(context.getMatrices(), 5, 5, 150, 150, 4, new Color(0, 0, 0));
//         FontUtil.drawText(context, "你好, 世界!", 200, 0, new Color(255,255,255), FontSize.LARGEST, false);
//         FontUtil.drawTextWithAlign(context, "+", 5, 5, 155, 155, Aligns.CENTER, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "左", 5, 5, 155, 155, Aligns.LEFT, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "上", 5, 5, 155, 155, Aligns.TOP, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "右", 5, 5, 155, 155, Aligns.RIGHT, new Color(  255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "下", 5, 5, 155, 155, Aligns.BOTTOM, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "AAA", 5, 5, 155, 155, Aligns.LEFT_BOTTOM, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "左上", 5, 5, 155, 155, Aligns.LEFT_TOP, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "右上", 5, 5, 155, 155, Aligns.RIGHT_TOP, new Color(255, 255, 255), FontSize.MEDIUM);
//         FontUtil.drawTextWithAlign(context, "右下", 5, 5, 155, 155, Aligns.RIGHT_BOTTOM, new Color(255, 255, 255), FontSize.MEDIUM);

         for (Module module : ModuleManager.modules) {
             if (module.getStatus()) {
                 module.onDraw2D(context, tickDelta);
             }
         }
         NotifyManager.onDraw2D(context, tickDelta);
     }

     public void onMouseMoveInClickGuiScreen(DrawContext context, int mouseX, int mouseY) {
         for (Module module : ModuleManager.modules) {
             if (module.getStatus()) {
                 module.onMouseMoveInClickGuiScreen(context, mouseX, mouseY);
             }
         }
     }

    public void onMouseClick(double mouseX, double mouseY, MouseButtons button) {
        Emotion.GUI.onMouseClick(mouseX, mouseY, button);
    }

    public void onMouseRelease(double mouseX, double mouseY, MouseButtons button) {
        Emotion.GUI.onMouseRelease(mouseX, mouseY, button);
    }
}
