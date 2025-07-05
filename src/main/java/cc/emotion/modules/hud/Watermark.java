package cc.emotion.modules.hud;

import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.features.options.impl.TextOption;
import cc.emotion.modules.Module;

public class Watermark extends Module {
    public Watermark() {
        super("Watermark", Category.HUD);
    }

    public Option<Boolean> customTitle = addOption(new BooleanOption("CustomTitle"));
    public Option<String> title = addOption(new TextOption("Title", "Emotion", v -> customTitle.getValue()));
    public Option<Boolean> includedTime = addOption(new BooleanOption("IncludedTime"));
    public Option<Boolean> includedFps = addOption(new BooleanOption("IncludedFPS"));
    public Option<Boolean> includedUser = addOption(new BooleanOption("IncludedUser"));
}
