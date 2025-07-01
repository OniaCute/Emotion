package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.util.function.Predicate;

public class BooleanOption extends Option<Boolean> {
    public BooleanOption(String name) {
        super(name, false, v -> true);
    }
    public BooleanOption(String name, boolean defaultValue) {
        super(name, defaultValue, v -> true);
    }
    public BooleanOption(String name, boolean defaultValue, Predicate<?> invisibility) {
        super(name, defaultValue, invisibility);
    }

    @Override
    public void setValue(Boolean value) {
        super.setValue(value);
    }

    @Override
    public Boolean getValue() {
        return super.getValue();
    }
}
