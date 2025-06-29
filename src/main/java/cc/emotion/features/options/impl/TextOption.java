package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.util.Objects;
import java.util.function.Predicate;

public class TextOption extends Option<String> {
    public TextOption(String name, String defaultValue) {
        super(name, "", defaultValue, v -> true);
    }
    public TextOption(String name, String defaultValue, Predicate<?> invisibility) {
        super(name, "", defaultValue, invisibility);
    }
    public TextOption(String name, String description, String defaultValue) {
        super(name, description, defaultValue, v -> true);
    }
    public TextOption(String name, String description, String defaultValue, Predicate<?> invisibility) {
        super(name, description, defaultValue, invisibility);
    }

    @Override
    public void setValue(String value) {
        super.setValue(value);
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    public char getFirstChar() {
        return getValue().charAt(0);
    }

    public char getLastChar() {
        return getValue().charAt(getValue().length() - 1);
    }
}
