package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.util.function.Predicate;

public class BindOption extends Option<Integer> {
    private BindType bindType;
    public BindOption(String name, Integer key, BindType bindType) {
        super(name, key, v -> true);
        this.bindType = bindType;
    }

    public BindOption(String name, Integer key, BindType bindType, Predicate<?> invisibility) {
        super(name, key, invisibility);
        this.bindType = bindType;
    }

    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }

    @Override
    public Integer getValue() {
        return super.getValue();
    }

    public char getValueAsChar() {
        return (char) (getValue().intValue());
    }

    public void setBindType(BindType bindType) {
        this.bindType = bindType;
    }

    public BindType getBindType() {
        return bindType;
    }

    public enum BindType {
        Press,
        Click
    }
}
