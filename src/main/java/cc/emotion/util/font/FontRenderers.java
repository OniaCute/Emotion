package cc.emotion.util.font;

import cc.emotion.util.font.FontAdapter;
import cc.emotion.util.font.RendererFontAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class FontRenderers {
    public static FontAdapter SMOOTH_3F;
    public static FontAdapter SMOOTH_4F;
    public static FontAdapter SMOOTH_5F;
    public static FontAdapter SMOOTH_6F;
    public static FontAdapter SMOOTH_7F;
    public static FontAdapter SMOOTH_8F;
    public static FontAdapter SMOOTH_9F;
    public static FontAdapter SMOOTH_10F;
    public static FontAdapter SMOOTH_12F;
    public static FontAdapter SMOOTH_14F;
    public static FontAdapter SMOOTH_15F;
    public static FontAdapter SMOOTH_16F;
    public static FontAdapter SMOOTH_18F;
    public static FontAdapter SMOOTH_20F;
    public static FontAdapter SMOOTH_21F;
    public static FontAdapter SMOOTH_24F;
    public static FontAdapter SMOOTH_28F;

    public static RendererFontAdapter create(String name, int style, float size) {
        return new RendererFontAdapter(new Font(name, style, (int) size), size);
    }

    public static RendererFontAdapter SmoothFont(float size) throws IOException, FontFormatException {
        InputStream fontStream = FontRenderers.class.getClassLoader().getResourceAsStream("assets/emotion/font/smooth.otf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.PLAIN, size);
        return new RendererFontAdapter(font, size);
    }
}