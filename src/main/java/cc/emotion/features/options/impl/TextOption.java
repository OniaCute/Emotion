package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

public class TextOption extends Option<Boolean> {
    public TextOption(String name) {
        super(name, false);
    }
    public TextOption(String name, boolean defaultValue) {
        super(name, defaultValue);
    }
}
