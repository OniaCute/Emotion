package cc.emotion.modules.misc;

import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.features.options.impl.EnumOption;
import cc.emotion.modules.Module;

public class Spam extends Module {
    public Spam() {
        super("Spam", Category.MISC);
    }

    public Option<Enum<?>> listOrder = addOption(new EnumOption("ListOrder", ListOrder.Random));

    public enum ListOrder {
        Order,
        Random
    }
}
