package cc.emotion.features.options.impl;

import cc.emotion.features.options.Option;
import cc.emotion.util.other.EnumTool;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Predicate;

public class EnumOption extends Option<Enum<?>> {

    public EnumOption(String name, Enum<?> value) {
        super(name, value, v -> true);
    }

    public EnumOption(String name, Enum<?> value, Predicate<?> invisibility) {
        super(name, value, invisibility);
    }

    @Override
    public Enum<?> getValue() {
        return this.value;
    }

    @Override
    public void setValue(Enum<?> value) {
        this.value = value;
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
