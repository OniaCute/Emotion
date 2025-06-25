package cc.emotion.modules.client;

import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.features.options.impl.DoubleOption;
import cc.emotion.modules.Module;

public class Notify extends Module {
    public static Notify INSTANCE;

    public Notify() {
        super("Notify", Category.CLIENT);
        INSTANCE = this;
    }

    public Option<Boolean> rounded = addOption(new BooleanOption("Rounded", true));
    public Option<Double> radius = addOption(new DoubleOption("Radius", 1, 6, 3, v -> rounded.getValue()));
    public Option<Double> notificationAliveTime = addOption(new DoubleOption("NotificationAliveTime", 100, 1000, 300));

}
