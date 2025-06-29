package cc.emotion.util.color;

import java.awt.*;

public class HexColor {
    private String value;

    public HexColor(Color color) {
        setValue(color);
    }

    public HexColor(int color) {
        setValue(color);
    }

    public HexColor(String color) {
        setValue(color);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(Color color) {
        int r = color.getRed();
        int g = color.getGreen();
        int b = color.getBlue();
        int a = color.getAlpha();
        this.value = String.format("#%02X%02X%02X%02X", a, r, g, b);
    }

    public void setValue(int color) {
        int alpha = (color >> 24) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        this.value = String.format("#%02X%02X%02X%02X", alpha, red, green, blue);
    }

    public String getValue() {
        return value;
    }

    public Color getValueAsColor() {
        if (this.value == null || this.value.isEmpty()) {
            return null;
        }
        if (this.value.charAt(0) == '#') {
            this.value = this.value.substring(1);
        }
        int alpha = 255;
        int red = 0;
        int green = 0;
        int blue = 0;
        if (this.value.length() == 8) {
            alpha = Integer.parseInt(this.value.substring(0, 2), 16);
            red = Integer.parseInt(this.value.substring(2, 4), 16);
            green = Integer.parseInt(this.value.substring(4, 6), 16);
            blue = Integer.parseInt(this.value.substring(6, 8), 16);
        } else if (this.value.length() == 6) {
            red = Integer.parseInt(this.value.substring(0, 2), 16);
            green = Integer.parseInt(this.value.substring(2, 4), 16);
            blue = Integer.parseInt(this.value.substring(4, 6), 16);
        }
        return new Color(red, green, blue, alpha);
    }

    public int getValueAsInt() {
        Color color = this.getValueAsColor();
        if (color == null) {
            return 0;
        }
        return (color.getAlpha() << 24) | (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
    }
}
