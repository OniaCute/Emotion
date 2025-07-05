package cc.emotion.features.notifications;

import net.minecraft.client.gui.DrawContext;

public class NormalNotification extends Notification {
    private String description;
    public NormalNotification(String text, String description, double aliveTime) {
        this.text = text;
        this.description = description;
        this.aliveTime = aliveTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void onDraw2D(DrawContext context, float tickDelta) {
    }
}
