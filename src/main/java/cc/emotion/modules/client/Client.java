package cc.emotion.modules.client;

import cc.emotion.features.options.Option;
import cc.emotion.features.options.impl.BooleanOption;
import cc.emotion.features.options.impl.EnumOption;
import cc.emotion.modules.Module;

public class Client extends Module {
    public static Client INSTANCE;

    public Client() {
        super("Client", Category.CLIENT);
    }

    public Option<Boolean> sync = addOption(new BooleanOption("Sync"));
    public Option<Enum<?>> UIScale = addOption(new EnumOption("UIScale", UIScales.X100));
    public Option<Enum<?>> EspScale = addOption(new EnumOption("EspScale", UIScales.X100));
    public Option<Enum<?>> language = addOption(new EnumOption("Language", UIScales.X100));

    public enum UIScales {
        X75,
        X100,
        X125,
        X150,
        X175,
        X200
    }

    public enum EspScales {
        X75,
        X100,
        X125,
        X150,
        X175,
        X200
    }
}
