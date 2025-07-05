package cc.emotion.features.notifications;

import net.minecraft.client.gui.DrawContext;

public abstract class Notification {
    protected String text;
    protected double aliveTime;

    public void setText(String text) {
        this.text = text;
    }

    public void reduceAliveTime(double unit) {
        aliveTime -= unit;
    }

    public double getAliveTime() {
        return aliveTime;
    }

    public boolean isAlive() {
        return aliveTime > 0.0;
    }

    public abstract void onDraw2D(DrawContext context, float tickDelta);
}
