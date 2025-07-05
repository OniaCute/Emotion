package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.util.ArrayList;

public class MultipleOption extends Option<ArrayList<String>> {
    public  MultipleOption(String name, Enum<?> value) {
        super(name, new ArrayList<>(), v -> true);
        this.value.add(value.name());
    }

    @Override
    public ArrayList<String> getValue() {
        return this.value;
    }

    @Override
    public void setValue(ArrayList<String> value) {
        this.value = value;
    }
}
