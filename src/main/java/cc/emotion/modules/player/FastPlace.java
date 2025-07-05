package cc.emotion.modules.player;

import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.DoubleOption;
import cc.emotion.modules.Module;
import cc.emotion.util.interfaces.Wrapper;

public class FastPlace extends Module implements Wrapper {
    public FastPlace() {
        super("FastPlace", Category.PLAYER);
    }

    public Option<Double> delay = addOption(new DoubleOption("Delay", 0, 2, 0));

    @Override
    public void onEnable() {
        mc.player.noClip = true;
    }
}
