package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.util.function.Predicate;

public class DoubleOption extends Option<Double> {
    private double maxValue;
    private double minValue;
    private double increase;

    public DoubleOption(String name, String description, double maxValue, double minValue, double value) {
        super(name, description, value, v -> true);
    }

    public DoubleOption(String name, String description, double maxValue, double minValue, double value, Predicate<?> invisibility) {
        super(name, description, value, invisibility);
    }

    public DoubleOption(String name, String description, double maxValue, double minValue) {
        super(name, description, 0.00, v -> true);
    }

    public DoubleOption(String name, double maxValue, double minValue, double value) {
        super(name, value, v -> true);
    }

    public DoubleOption(String name, double maxValue, double minValue, double value, Predicate<?> invisibility) {
        super(name, value, invisibility);
    }

    public DoubleOption(String name, double maxValue, double minValue) {
        super(name, 0.00, v -> true);
    }

    public DoubleOption(String name, Double defaultValue) {
        super(name, defaultValue, v -> true);
    }

    @Override
    public Double getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Double value) {
        super.setValue(value);
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public void setIncrease(double increase) {
        this.increase = increase;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public double getIncrease() {
        return increase;
    }

    public String getValueAsText() {
        return String.valueOf(getValue()) + " tick";
    }
}
