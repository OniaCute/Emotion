package cc.emotion.features.notifications;

import cc.emotion.Emotion;
import cc.emotion.features.enums.Aligns;
import cc.emotion.features.enums.FontSize;
import cc.emotion.features.managers.NotifyManager;
import cc.emotion.features.managers.ThemeManager;
import cc.emotion.modules.client.Notify;
import cc.emotion.util.font.FontUtil;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;

public class SimpleNotification extends Notification{
    public SimpleNotification(String text, double aliveTime) {
        this.text = text;
        this.aliveTime = aliveTime;
    }

    @Override
    public void onDraw2D(DrawContext context, float tickDelta) {
        if (Notify.INSTANCE.rounded.getValue()) {
            Render2DUtil.drawRoundedRect(
                    context.getMatrices(),
                    NotifyManager.nextNotificationPos.getA(),
                    NotifyManager.nextNotificationPos.getB(),
                    FontUtil.getWidth(FontSize.MEDIUM, this.text),
                    FontUtil.getHeight(FontSize.MEDIUM),
                    Notify.INSTANCE.radius.getValue(),
                    Emotion.THEME.getTheme().getNotificationBackgroundColor()
            );
        } else {
            Render2DUtil.drawRect(
                    context,
                    NotifyManager.nextNotificationPos.getA() - 2,
                    NotifyManager.nextNotificationPos.getB() - 2,
                    FontUtil.getWidth(FontSize.MEDIUM, this.text) + 4,
                    FontUtil.getHeight(FontSize.MEDIUM) + 4,
                    Emotion.THEME.getTheme().getNotificationBackgroundColor()
            );
        }

        FontUtil.drawTextWithAlign(
                context,
                text,
                NotifyManager.nextNotificationPos.getA(),
                NotifyManager.nextNotificationPos.getB(),
                FontUtil.getWidth(FontSize.MEDIUM, this.text),
                FontUtil.getHeight(FontSize.MEDIUM),
                Aligns.LEFT,
                Emotion.THEME.getTheme().getNotificationTextColor(),
                FontSize.MEDIUM);
    }
}
