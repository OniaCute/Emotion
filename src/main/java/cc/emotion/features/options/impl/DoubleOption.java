package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

public class DoubleOption extends Option<Double> {
    public DoubleOption(String name) {
        super(name, 0.00);
    }

    public DoubleOption(String name, Double defaultValue) {
        super(name, defaultValue);
    }

    @Override
    public Double getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Double value) {
        super.setValue(value);
    }
}
