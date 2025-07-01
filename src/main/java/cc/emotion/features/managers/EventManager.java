package cc.emotion.features.managers;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.enums.MouseButtons;
import cc.emotion.features.notifications.Notification;
import cc.emotion.features.options.impl.BindOption;
import cc.emotion.modules.Module;
import cc.emotion.modules.client.Client;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;

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
         FontUtil.drawText(context, "你好, 世界!", 5, 5, new Color(255,255,255), FontSize.LARGEST, false);
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

    public void onMouseMoveInHudEditorScreen(DrawContext context, int mouseX, int mouseY) {
        for (Module module : ModuleManager.modules) {
            if (module.getStatus()) {
                module.onMouseMoveInHudEditorScreen(context, mouseX, mouseY);
            }
        }
    }

    public void onMouseClick(double mouseX, double mouseY, Screen screen, MouseButtons button) {
        Emotion.GUI.onMouseClick(mouseX, mouseY, screen, button);
    }

    public void onMouseRelease(double mouseX, double mouseY, Screen screen, MouseButtons button) {
        Emotion.GUI.onMouseRelease(mouseX, mouseY, screen, button);
    }

    public void onKeyboardActive(int key, int action) {
        if (key == -1 || key == -2) {
            return ;
        }

        for (Module module : ModuleManager.modules) {
            if (module.getBind().getValue() == key) {
                if (action == 1) {
                    if (module.getBind().getBindType().equals(BindOption.BindType.Click)) {
                        if (module.getStatus()) {
                            module.disable();
                        } else {
                            module.enable();
                        }
                    } else {
                        module.enable();
                    }
                } else {
                    module.disable();
                }
            }
        }
    }
}
