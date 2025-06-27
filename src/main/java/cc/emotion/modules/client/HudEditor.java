package cc.emotion.modules.client;

import cc.emotion.modules.Module;

public class HudEditor extends Module {
    public static HudEditor INSTANCE;
    public HudEditor() {
        super("HudEditor", Category.CLIENT);
        INSTANCE = this;
    }
}
