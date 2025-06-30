package cc.emotion.util.maths;

import oshi.util.tuples.Pair;

public class PositionUtil {
    public static Pair<Double, Double> getGapPosition(double mouseX, double mouseY, double newMouseX, double MouseY) {
        return new Pair<>(Math.abs(mouseX - newMouseX), Math.abs(mouseY - newMouseX));
    }
}
