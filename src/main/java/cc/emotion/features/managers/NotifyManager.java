package cc.emotion.features.managers;

import cc.emotion.features.notifications.NormalNotification;
import cc.emotion.features.notifications.Notification;
import net.minecraft.client.gui.DrawContext;
import oshi.util.tuples.Pair;

import java.util.ArrayList;

public class NotifyManager {
    public static Pair<Double, Double> nextNotificationPos = null;
    public static ArrayList<Notification> notifications = new ArrayList<>();

    public static void addNotification(NormalNotification notification) {
        notifications.add(notification);
    }

    public static void popNotification() {
        if (notifications.isEmpty()) {return;}
        
        notifications.remove(0);
    }

    public static void check(Notification notification) {
        if (!notification.isAlive()) {
            notifications.add(notification);
        }
    }

    public static void onTick() {
        for (Notification notification : notifications) {
            notification.reduceAliveTime(0.1);
            NotifyManager.check(notification);
        }
    }

    public static void onDraw2D(DrawContext context, float tickDelta) {
        for (Notification notification : notifications) {
            NotifyManager.check(notification);
            if (notification.isAlive()) {
                notification.onDraw2D(context, tickDelta);
            }
        }
    }
}
