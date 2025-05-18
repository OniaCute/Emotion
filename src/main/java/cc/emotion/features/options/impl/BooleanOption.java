package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

public class BooleanOption extends Option<Boolean> {
    public BooleanOption(String name) {
        super(name, false);
    }
    public BooleanOption(String name, boolean defaultValue) {
        super(name, defaultValue);
    }
}
