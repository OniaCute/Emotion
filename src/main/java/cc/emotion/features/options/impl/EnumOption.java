package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;
import cc.emotion.util.other.EnumTool;

import java.util.List;

public class EnumOption extends Option<Enum<?>> {
    public EnumOption(String name, Enum<?> value) {
        super(name, value);
    }

    @Override
    public Enum<?> getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Enum<?> value) {
        super.setValue(value);
    }

    public <T extends Enum<T>> T getNext(T value) {
        return EnumTool.getNextEnumValue(EnumTool.getEnumClassFromValue(value), value);
    }

    public <T extends Enum<T>> T getPrevious(T value) {
        return EnumTool.getPreviousEnumValue(EnumTool.getEnumClassFromValue(value), value);
    }

    public <T extends Enum<T>> List<T> getList(T value) {
        return EnumTool.getAllEnumValues(value.getDeclaringClass());
    }
}
