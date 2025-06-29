package cc.emotion.util.color;

import java.awt.*;

public class ColorUtil {
    public Color setRed(Color color, int red) {
        return new Color(red, color.getGreen(), color.getBlue(), color.getAlpha());
    }

    public Color setGreen(Color color, int green) {
        return new Color(color.getRed(), green, color.getBlue(), color.getAlpha());
    }

    public Color setBlue(Color color, int blue) {
        return new Color(color.getRed(), color.getGreen(), blue, color.getAlpha());
    }

    public Color setAlpha(Color color, int alpha) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), alpha);
    }

    public HexColor asHexColor(Color color) {
        return new HexColor(color);
    }

    public HexColor asHexColor(int color) {
        return new HexColor(color);
    }

    public int asIntColor(Color color) {
        return color.getRGB();
    }

    public int asIntColor(HexColor color) {
        return color.getValueAsInt();
    }

    public Color asColor(int color) {
        return new Color(color);
    }

    public Color asColor(HexColor color) {
        return color.getValueAsColor();
    }
}
