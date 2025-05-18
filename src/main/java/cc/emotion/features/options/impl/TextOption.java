package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

public class TextOption extends Option<String> {
    public TextOption(String name) {
        super(name, "", "");
    }
    public TextOption(String name, String defaultValue) {
        super(name, "", defaultValue);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }
}
