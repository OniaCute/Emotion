package cc.emotion.util.other;

import java.util.Arrays;
import java.util.List;

public class EnumTool {
    public static <T extends Enum<T>> T getNextEnumValue(Class<T> enumClass, T currentValue) {
        T[] values = enumClass.getEnumConstants();
        int currentIndex = currentValue.ordinal();
        if (currentIndex == values.length - 1) {
            return values[0];
        } else {
            return values[currentIndex + 1];
        }
    }

    public static <T extends Enum<T>> T getPreviousEnumValue(Class<T> enumClass, T currentValue) {
        T[] values = enumClass.getEnumConstants();
        int currentIndex = currentValue.ordinal();
        if (currentIndex == 0) {
            return values[values.length - 1];
        } else {
            return values[currentIndex - 1];
        }
    }

    public static <T extends Enum<T>> List<T> getAllEnumValues(Class<T> enumClass) {
        return Arrays.asList(enumClass.getEnumConstants());
    }

    public static <T extends Enum<T>> T getEnumValueByName(Class<T> enumClass, String string) {
        T[] values = enumClass.getEnumConstants();
        for (T value : values) {
            if (value.name().equals(string)) {
                return value;
            }
        }
        return null;
    }

    public static <T extends Enum<T>> Class<T> getEnumClassFromValue(T enumValue) {
        return enumValue.getDeclaringClass(); // there is a <NullPointerException> when enum is null!
    }
}
