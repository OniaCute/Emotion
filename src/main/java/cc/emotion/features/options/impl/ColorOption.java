package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.awt.*;

public class ColorOption extends Option<Color> {
    public ColorOption(String name) {
        super(name, new Color(0));
    }

    public ColorOption(String name, int defaultValue) {
        super(name, new Color(defaultValue));
    }

    public ColorOption(String name, Color defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public Color getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Color value) {
        super.setValue(value);
    }

    public void setValue(int value) {
        super.setValue(new Color(value));
    }
}
