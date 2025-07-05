package cc.emotion.features.notifications;

import cc.emotion.Emotion;
import cc.emotion.util.render.Render2DUtil;
import net.minecraft.client.gui.DrawContext;

public class WindowNotification extends Notification {
    private double x;
    private double y;
    private double width;
    private double height;
    private String description;

    public WindowNotification(String text, String description, Double aliveTime) {
        this.text = text;
        this.aliveTime = aliveTime;
        this.description = description;
    }

    @Override
    public void onDraw2D(DrawContext context, float tickDelta) {
        Render2DUtil.drawRoundedRect(
                context.getMatrices(),
                this.x,
                this.y,
                this.width,
                this.height,
                2 * Render2DUtil.getScaleFactor(),
                Emotion.THEME.getTheme().getNotificationBackgroundColor()
        );
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
