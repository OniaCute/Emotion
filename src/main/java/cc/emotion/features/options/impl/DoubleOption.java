package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

public class DoubleOption extends Option<Double> {
    private double maxValue;
    private double minValue;
    private double increase;
    private HashMap<Integer, String> specialValueMap = new HashMap<>();

    public DoubleOption(String name, String description, double minValue, double maxValue, double value) {
        super(name, description, value, v -> true);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public DoubleOption(String name, String description, double minValue, double maxValue, double value, Predicate<?> invisibility) {
        super(name, description, value, invisibility);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public DoubleOption(String name, String description, double minValue, double maxValue) {
        super(name, description, 0.00, v -> true);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public DoubleOption(String name, double minValue, double maxValue, double value) {
        super(name, value, v -> true);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public DoubleOption(String name, double minValue, double maxValue, double value, Predicate<?> invisibility) {
        super(name, value, invisibility);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public DoubleOption(String name, double minValue, double maxValue) {
        super(name, 0.00, v -> true);
        this.minValue = minValue;
        this.maxValue = maxValue;
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
        if (specialValueMap.get(this.getValue().intValue()) == null) {
            return String.valueOf(getValue()) + " tick";
        }
        return specialValueMap.get(this.getValue().intValue());
    }

    public DoubleOption addSpecialValue(Integer number, String displayString) {
        specialValueMap.put(number, displayString);
        return this;
    }
}
