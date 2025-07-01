package cc.emotion.modules.combat;

import cc.emotion.features.enums.PlaceModes;
import cc.emotion.features.enums.RotateModes;
import cc.emotion.features.enums.SwingModes;
import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.features.options.impl.DoubleOption;
import cc.emotion.features.options.impl.EnumOption;
import cc.emotion.modules.Module;

public class CombatSetting extends Module {
    public CombatSetting() {
        super("CombatSetting", Category.COMBAT);
    }

    public Option<Enum<?>> rotateMode = addOption(new EnumOption("RotateMode", RotateModes.Vanilla));
    public Option<Boolean> rotateSync = addOption(new BooleanOption("RotateSync", false, v -> (rotateMode.getValue() != RotateModes.Random)));
    public Option<Double> rotateTime = addOption(new DoubleOption("RotateTime", 0, 1000).addSpecialValue(0, "INSTANT"));
    public Option<Enum<?>> swingMode = addOption(new EnumOption("SwingMode", SwingModes.Vanilla));
    public Option<Enum<?>> PlaceMode = addOption(new EnumOption("PlaceMode", PlaceModes.Vanilla));
}
